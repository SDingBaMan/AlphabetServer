package client;

import com.sdingba.utils.StringUtils;
import sun.awt.WindowClosingListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.*;

public class Client extends JFrame implements Runnable, ActionListener {
    private static final long serialVersionUID = 1L;
    public static final int PORT = 19990;

    FlowLayout flowLayout1 = new FlowLayout();
    BorderLayout borderLayout1 = new BorderLayout();

    BorderLayout borderLayout2 = new BorderLayout();
    JPanel jPanel1 = new JPanel();
    JPanel jPanel2 = new JPanel();
    static JTextArea jTextArea1 = new JTextArea();


    JLabel JLabel_username = new JLabel();
    JTextField JTextField_username = new JTextField();
    JTextField JTextField_revicesname = new JTextField();
    JButton JButton_login = new JButton();
    JButton JButton_leave = new JButton();

    JTextField jTextField_history = new JTextField();
    JLabel JLabel_address = new JLabel();
    JTextField jTextField_address = new JTextField();
    JTextField jTextField_info = new JTextField();
    JButton JButton_send = new JButton();
    JScrollPane jScrollPane1 = new JScrollPane();
    Socket socket;
    Thread thread;
    DataInputStream in;
    DataOutputStream out;
    boolean flag = false;
    String name, chat_txt, chat_in, revicesname;
    String ip = null;

    public Client() {
        super("Server");

        JLabel_username.setText("用户名");
        JTextField_username.setText("modelsim");
        JTextField_revicesname.setText("sdingba");
        JButton_login.setText("进入聊天室");
        JButton_leave.setText("退出聊天室");
        jTextField_history.setText("历史信息");
        JLabel_address.setText("服务器地址");
        jTextField_address.setText("127.0.0.1");
        jTextField_info.setText("要发送的信息");
        JButton_send.setText("发送");

        getContentPane().setLayout(borderLayout1);
        this.getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel1.add(JLabel_username);
        jPanel1.add(JTextField_username);
        jPanel1.add(JTextField_revicesname);
        jPanel1.add(JButton_login);
        jPanel1.add(JButton_leave);


        jPanel1.add(jTextField_history);
        jPanel1.add(JLabel_address);
        jPanel1.add(jTextField_address);

        jPanel1.add(jTextField_info);
        jPanel1.add(JButton_send);

        jPanel2.setLayout(borderLayout2);
        jPanel2.add(jScrollPane1, BorderLayout.CENTER);
        jScrollPane1.getViewport().add(jTextArea1);
        this.getContentPane().add(jPanel2, BorderLayout.CENTER);

        JButton_login.addActionListener(this);
        JButton_leave.addActionListener(this);
        JButton_send.addActionListener(this);

        this.setSize(800, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Client client = new Client();
//        client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == JButton_login) {
            name = JTextField_username.getText().trim();
            revicesname = JTextField_revicesname.getText().trim();
            ip = jTextField_address.getText();
            if (name != "用户名输入" && ip != null) {
                try {
                    socket = new Socket(ip, PORT);
                    in = new DataInputStream(socket.getInputStream());
                    out = new DataOutputStream(socket.getOutputStream());
                    Date now = new Date(System.currentTimeMillis());
                    SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
                    String nowStr = format.format(now);
                    out.writeUTF("[$$" + ":" + name + ":" + revicesname + ":" + nowStr + "上线了]");
                } catch (Exception e1) {
                    System.out.println("can not connect");
                }
                thread = new Thread(this);
                thread.start();
                flag = true;
            }
        } else if (e.getSource() == JButton_send) {
            chat_txt = jTextField_info.getText();
            if (chat_txt != null) {
                Date now = new Date(System.currentTimeMillis());
                SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
                String nowStr = format.format(now);
                try {
//                    System.out.println(socket.is);
                    out.writeUTF("[id=" + name + ":"
                            + "message=" + chat_txt + ":"
                            + "time=" + nowStr + ":"
                            + "reciver=" + revicesname + "]");
                    String sendStr = "我" + ":" + chat_txt;

                    jTextArea1.append(sendStr + "\n");
                } catch (Exception e2) {
                    System.out.println("服务器 没有 开启");
                    System.out.println(e);
                    jTextArea1.append("服务器 没有 开启" + "\n");
                }
            } else {
                try {
                    out.writeUTF("请说话");
                } catch (Exception e3) {
                }
            }
        } else if (e.getSource() == JButton_leave) {
            chat_txt = jTextField_history.getText();
            if (flag = true) {
                try {
                    out.writeUTF("[##" + ":" + name + ":" + revicesname + ":" + "下线了]");
                    out.close();
                    in.close();
                    socket.close();


                } catch (Exception e4) {
                    System.out.println("xxccccvvvv");
                }
            }
            flag = false;
            this.setVisible(false);
            dispose();
        }
    }


    @Override
    public void run() {
        while (true) {
            try {
                // // TODO: 16-6-16  添加（新加入；） 
                if (socket == null) {
                    return;
                }
                chat_in = in.readUTF();
                if (chat_in.contains("history$$$")) {
                    String messString = chat_in.replace("history$$$", "");
                    String[] messsageList = messString.split("\\;");
                    for (String mess : messsageList) {
                        jTextArea1.append(mess + "\n");
                    }
                }else{
                    jTextArea1.append(chat_in + "\n");
                }

            } catch (IOException e) {
            }
        }
    }
}