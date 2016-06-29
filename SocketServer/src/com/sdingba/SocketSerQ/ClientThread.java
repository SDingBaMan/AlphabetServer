package com.sdingba.SocketSerQ;

import com.sdingba.bean.Message;
import com.sdingba.utils.StringUtils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by su on 16-6-6.
 */
public class ClientThread extends Thread {
    //维护服务器 和 单个客服端的链接线程，负责接受客服端发来的消息

    Socket clientSocket;


    /**
     * 自己的ID
     */
    private String myId;

    /**
     * 发送对方的ID
     */
    private String revicedId;
    /**
     * 发送对方的ID
     */
    public String getRevicedId() {
        return revicedId;
    }

    /**
     * 发送对方的ID
     */
    public void setRevicedId(String revicedId) {
        this.revicedId = revicedId;
    }

    /**
     * 自己的ID
     */
    public String getMyId() {
        return myId;
    }

    /**
     * 自己的ID
     */
    public void setMyId(String myId) {
        this.myId = myId;
    }

    boolean flag = true;
    DataInputStream in = null;
    DataOutputStream out = null;

    ServerThread serverThread;


    public static int ConnectNumber = 0;

    public ClientThread(Socket socket, ServerThread serverThread) {
        this.clientSocket = socket;
        this.serverThread = serverThread;
        flag = true;
        try {
            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("建立IO通道失败" + e);
            System.exit(3);
        }
    }

    //该方法监听该连接对应的客服端是否有消息发送
    @Override
    public void run() {
        Message mess;
        while (flag) {
            try {

//              System.out.println(clientSocket == null);
                String message="";
                if (clientSocket != null) {
                    message = in.readUTF();  //程序会一直停在这儿，，，等待数据的到来。
                }else{
                    System.out.println("退出了=====clientSocket is null==============");
                    break;
                }
                //读取客服端发送来的消息。
                System.out.println(this.getMyId()+"  =======   ClientThread=======");
                /*
                    格式===》[id= :message=]
                 */


                //// TODO: 16-6-16  
//                mess = StringUtils.PullString(message);
//                System.out.println(message.toString());
//                System.out.println("*******"+mess.toString());


                //1 先 获取 他 id，
                if (message.contains("上线了")){

                    String shangxian[] = message.split(":");

                    this.setMyId(shangxian[1]);
                    this.setRevicedId(shangxian[2]);



                    // 发送方+"&"+接收方       ===》 我本人的ID+"&"+对方的ID
                    String saveSocket = shangxian[1] + "&" + shangxian[2];
                    System.out.println("==上线了======" + saveSocket);
                    serverThread.mapClients.put(saveSocket, this);


                    //todo 进行数据库数据的查询，并且吧数据存储到。

                    //todo 然后在 BroadCast里面查看是否有数据，没有的话，不惊醒返回。

                    // 在这儿获取数据，有的话，封装成 数据，存入到message里面，
                    // 没有的话，不做处理




                } else if (message.contains("下线了")) {
                    String shangxian[] = message.split(":");
//                    this.setMyId(shangxian[1]);
//                    this.setRevicedId(shangxian[2]);



                    // 发送方+"&"+接收方       ===》 我本人的ID+"&"+对方的ID
                    String saveSocket = shangxian[1] + "&" + shangxian[2];
                    System.out.println("下线了：：：：" +
                            "" + message+";;;下线的是"+saveSocket);

                    //// TODO: 16-6-16  移除前 ，要先 获取 socket；设置为空 clientSocket.close();；？？？是否？？？
                    //                      不设置为空是否会造成   内存泄露
                    serverThread.mapClients.remove(saveSocket);

                    clientSocket = null;
//                    clientSocket.close();
                }else{

                    //// TODO: 16-6-8 如果是上线，下线，可以不对 message里卖存入数据，
                    //   todo 这样，BroadCast可以不对 上线下线2中情况进行处理。
                    // todo 或者说，分开发送数据，这样在上面的上线栏目中，
                    // todo 可以查询数据库进行历史数据的发送。

                }
                //todo  2 对下面的 message进行解析，发送的实时消息进行解析
//                Message mes = StringUtils.PullString(message);
//                System.out.println("ClientThread   :  "+mes.toString());
                //3 ，存储到 数据表中持久化；
                synchronized (serverThread.messages) {
                    if (message != null) {
                        //将客服端发送来的信息存于serverThread的messageS的数组中
                        serverThread.messages.addElement(message);
                        Server.jTextArea1.append(message + '\n');
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
                try {
                    System.out.println("。ClientThread关闭线程。IOException  异常");
                    flag = false;
                    in.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }


}
