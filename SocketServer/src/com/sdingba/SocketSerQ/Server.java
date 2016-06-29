package com.sdingba.SocketSerQ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by su on 16-6-6.
 * 服务器 段 主程序负责界面，以及服务的主线程ServerThread的启动
 * ，服务段主线程ServerThread又产生BroadCast以及ClientThread的线程
 */
public class Server extends JFrame implements ActionListener {

    BorderLayout borderLayout1 = new BorderLayout();
    BorderLayout borderLayout2 = new BorderLayout();

    JPanel jPanel1 = new JPanel();
    JPanel jPanel2 = new JPanel();
    JButton jButton1 = new JButton();
    JButton jButton2 = new JButton();
    JScrollPane jScrollPane1 = new JScrollPane();

    //创建 服务器 接受 信息的文本框
    static JTextArea jTextArea1 = new JTextArea();
    boolean bool = false, start = false;

    //声明 serverThread线程类对象
    ServerThread serverThread;
    Thread thread;

    public Server(){
        super("Server");
        getContentPane().setLayout(borderLayout1);

        jButton1.setText("Start Ser");
        jButton1.addActionListener(this);
        jButton2.setText("Stop Ser");
        jButton2.addActionListener(this);

        this.getContentPane().add(jPanel1, BorderLayout.NORTH);
        jPanel1.add(jButton1);
        jPanel1.add(jButton2);

        jTextArea1.setText("");
        jPanel2.setLayout(borderLayout2);
        jPanel2.add(jScrollPane1, BorderLayout.CENTER);
        jScrollPane1.getViewport().add(jTextArea1);
        this.getContentPane().add(jPanel2, BorderLayout.CENTER);

        this.setSize(400, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Server server = new Server();

    }



    //服务界面中按钮点击事件
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == jButton1) {
            serverThread = new ServerThread();
            serverThread.start();


        } else if (e.getSource() == jButton2) {

            bool = false;
            start = false;
            serverThread.finalize();
            this.setVisible(false);

        }

    }
}
