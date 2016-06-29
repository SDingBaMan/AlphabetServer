package com.sdingba.SocketSerQ;

import com.sdingba.bean.Message;
import com.sdingba.dao.sendMessageDao;
import com.sdingba.factory.Factory;
import com.sdingba.service.sendMessageService;
import com.sdingba.utils.StringUtils;

import java.io.IOException;

/**
 * Created by su on 16-6-6.
 */
public class BroadCast extends Thread {
    //服务器向 客服端 广播 线程

    ClientThread clientThread;

    ServerThread serverThread;

    String str;

    Message mess;

    public BroadCast(ServerThread serverThread) {
        this.serverThread = serverThread;
    }

    //该方法的作用是不停的向所有的服务器发送新消息

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //同步话 serverRThread.messages
            synchronized (serverThread.messages) {
                if (serverThread.messages.isEmpty()) {
                    continue;
                }
                str = (String) this.serverThread.messages.firstElement();
            }

            //同步化 serverThread，client
//            synchronized (serverThread.clients) {
//                //利用循环获取服务器中的存储的数据建立的客户端的链接
//                for (int i=0;i<serverThread.clients.size();i++) {
//                    System.out.println("BroadCast:"+mess.getReciver());
////                    clientThread =  serverThread.mapClients.get("sdingba");
//                    clientThread = serverThread.clients.elementAt(i);
//                    System.out.println(clientThread);
//                    try {
//                        clientThread.out.writeUTF(str);
//                        System.out.println(str);
//                    } catch (IOException e) {
//                        System.out.println(str);
//                        e.printStackTrace();
//                    }
//                }
//                //从vertor数组删除已经发送的那条数据信息
//                this.serverThread.messages.removeElement(str);
//            }

            // map
            // 以下是发送 实时发送的消息；；；；

            System.out.println("broadCast : " + str);
            if (str.contains("上线了")) {
                if (str != null) {
                    String shangxian[] = str.split(":");
                    System.out.println(str+"    []  [] [] [] [] ");
                    // todo 在这儿发送   历史数据，给 谁谁 的；  获取数据库中的数据。
                    //比我上线我是aaa，并且点开了bbb的窗口，所有 查询  aaa和bbb的数据，发送给客户端。
                    sendMessageService impl = Factory.getFactory().getInstance(sendMessageService.class);
                    String stringMessage = impl.MessageHistoryString(shangxian[2], shangxian[1]);
                    System.out.println(stringMessage);

                    clientThread = serverThread.mapClients.get(shangxian[1]+"&"+shangxian[2]);

                    if (clientThread != null&&!stringMessage.equals("")) {
                        try {
                            clientThread.out.writeUTF("history$$$"+stringMessage);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
//                    clientThread.out.writeUTF(sendStr);
                }
                //删除 一句话
                this.serverThread.messages.removeElement(str);

                System.out.println("{}{}{}{}{}{}{}{}{}{}");
                continue;
            }else if (str.contains("下线了")) {

                //删除 一句话
                this.serverThread.messages.removeElement(str);

                // 获取  数据；
                continue;
            }




            mess = StringUtils.PullString(str);
            synchronized (serverThread.mapClients) {

                String sendSocket = StringUtils.changeMesstoSocketSend(mess);
                //查询 对方 的 socket   比如 aaa发送数据给bbb , 则这里面要写 bbb&aaa
//                clientThread = serverThread.mapClients.get(mess.getReciver()+"&"+mess.getId());
                clientThread = serverThread.mapClients.get(sendSocket);

                if (clientThread == null) {
                    // TODO: 16-6-7 发送的对象现在为空。
                    // todo  把 数据存入 数据库中，
                    sendMessageService impl = Factory.getFactory().getInstance(sendMessageService.class);
                    impl.addMessageSendqq(mess.getId(),mess.getReciver(),mess.getMessage());

                    System.out.println("存入数据库了，已经，。。clientThread为空,要发送的对象:"+mess.getReciver()+" && 没有开启,要发送的socket"+sendSocket);

                }else{
                    //todo  不为空就发送数据。
                    System.out.println("clientThread为空,要发送的对象:"+mess.getReciver()+" 开启,要发送的socket"+sendSocket);

                    try {

                        String sendStr = mess.getId() + ":" + mess.getMessage();
                        clientThread.out.writeUTF(sendStr);
                        System.out.println("==================================================");
                        System.out.println(sendStr);
                        System.out.println("==================================================");

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                //删除 一句话
                this.serverThread.messages.removeElement(str);
            }
        }
    }
}
