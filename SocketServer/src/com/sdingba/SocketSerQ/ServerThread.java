package com.sdingba.SocketSerQ;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * Created by su on 16-6-6.
 */
public class ServerThread extends Thread {


    private boolean stat = true;
    //声明ServerSocket的对象
    ServerSocket serverSocket;

    public static final int PORT = 19990;

    //指定 一个 Vector对象,用于存储客服端链接的ClientThread对象
    Vector<ClientThread> clients;

    /**
     * map的形式 对 数据进行 存储，、
     * String  ==》 id；
     * ClientThread  ==>  子线程；
     */
    Map<String, ClientThread> mapClients;


    /**
     * 存消息的 messages 数组集合。
     */
    Vector<Object> messages;


    BroadCast broadCast;

    String ip;
    InetAddress myIPaddress = null;

    public ServerThread() {
        //创建 2个 vector数组。很重要的；
        clients = new Vector<ClientThread>();
        messages = new Vector<Object>();
        mapClients = new HashMap<String, ClientThread>();

        try {
            serverSocket = new ServerSocket(PORT);
            stat = true;

        } catch (IOException e) {

        }

        //获取本地服务器的信息
        try {
            myIPaddress = InetAddress.getLocalHost();


        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.out.println(e.toString());

        }
        ip = myIPaddress.getHostAddress();
        Server.jTextArea1.append("服务器地址：" + ip + "端口号:"
                + String.valueOf(serverSocket.getLocalPort() + "\n"));

        //创建 广播信息线程并启动//// TODO: 16-6-8 广播就一个线程，×××× 
        broadCast = new BroadCast(this);
        broadCast.start();

    }

    // 一旦监听的新的客户端 创建 new socket被执行
    //就创建一个新的ClientThread来维护服务器与这个客户端的连接
    @Override
    public void run() {
        while (stat) {
            System.out.println("< serverSocket.accept >等待 socket 的进入：...");
            try {
                //获取客服端的链接，返回一个心得socket对象
                Socket socket = serverSocket.accept();
                System.out.println(serverSocket.getInetAddress());

                //创建 ClientThread线程并启动
                //启动CLientThread之后，可以监听该链接对应的客户端是否发送消息并获取消息
                ClientThread clientThread = new ClientThread(socket, this);

                clientThread.start();
                Thread.sleep(500);
//                System.out.println(clientThread.getMyId() + "=============");
//                System.out.println(clientThread.getRevicedId() + "=============");


                if (socket != null) {
//                    synchronized (clients) {
//                        //将客服端链接加入  数组中 存储
//                        clients.addElement(clientThread);
//                    }
                    synchronized (mapClients) {
                        //// TODO: 16-6-7
                        //将客服端链接加入  数组中 存储
//                        System.out.println("==存入Map的数值是：== id :" +
//                                "" + clientThread.getMyId());
//                        System.out.println("==存入Map的数值是：== Revicedid :" +
//                                "" + clientThread.getRevicedId());
//                        String saveSocketUUID = clientThread.getMyId()
//                                + "&" + clientThread.getRevicedId();

//                        mapClients.put(saveSocketUUID, clientThread);

                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println(e);
                System.out.println("建立客户端连接失败");
                System.exit(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void finalize() {
        try {

            stat = false;

            mapClients.clear();

            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        serverSocket = null;
    }
}
