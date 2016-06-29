package com.sdingba.utils;

import com.sdingba.bean.Message;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by su on 16-6-6.
 */
public class StringUtils {

    public static void main(String[] args) {

    }
    /*
        [id= : reciver= :message=]

     */

    @Test
    public void test(){

        String a = "[id=2:message=eeee:reciver=sss:time=2222]";
        Message message = PullString(a);
        System.out.println("==============");
        System.out.println(message.toString());


        String b = "iifid&dsfsdfs";
        System.out.println(changeSaveSocketUUID(b));

        List<Message> aa = pullListSendMessage("xxxx:dsfdfs;jjjjj:ooooo;iiiiii:ppppp");
        for (Message aaaaa : aa) {
            System.out.println(aaaaa.getId());
            System.out.println(aaaaa.getMessage());
        }
    }


    /**
     * 把  String a = "[id=2:message=eeee]";解析成对象；
     * [id=bbb:message=要发送的信息:time=08:28:44:reciver=aaa]
     * @param str
     * @return
     */
    public static Message PullString(String str) {
        Message mes = new Message();
        int lenth = str.length();
        if (str !=null && str.substring(0, 1).equals("[") && str.substring(lenth - 1, lenth).equals("]")){

            String STR = str.substring(1,lenth-1);
            String[] strs = STR.split(":");
            for (String strsss : strs) {
                String[] users = strsss.split("=");
                if (users[0].equals("id") && users[0] != null) {
//                    System.out.print("id : ");
//                    System.out.println(users[1]);
                    mes.setId(users[1]);
                } else if (users[0].equals("message") && users[0] != null) {
//                    System.out.print("message : ");
//                    System.out.println(users[1]);
                    mes.setMessage(users[1]);
                } else if (users[0].equals("reciver") && users[0] != null) {
//                    System.out.print("reciver : ");
//                    System.out.println("谁谁谁");
                    mes.setReciver(users[1]);
                } else if (users[0].equals("time") && users[0] != null) {
//                    System.out.println("time");
//                    System.out.println("时间多少");
                    mes.setTime(users[1]);

                }
            }
        }
        return mes;
    }

    /**
     *  把 带 & 符号的字符串交换
     * @param s 传入进来的是  aaa&bbb
     * @return  bbb&aaa
     */
    public static String changeSaveSocketUUID(String s) {
        String aaa[] = s.split("\\&");
        return aaa[1] +"&" + aaa[0];
    }

    /**
     * 发送的  id   MAP Key
     * @param mess
     * @return
     */
    public static String changeMesstoSocketSend(Message mess) {
        return mess.getReciver() + "&" + mess.getId();
    }


    /**
     * 解析  对象的集合 ；
     * 主要给 客户端使用的，服务器端 没有使用的地方；
     * xxxx:dsfdfs;jjjjj:ooooo;iiiiii:ppppp
     * @param string
     * @return
     */
    public static List<Message> pullListSendMessage(String string){
        //id:message;====> send:message;send:message;
        List<Message> listMessage = new ArrayList<Message>();
        String[] messStr = string.split("\\;");
        for (String aaa : messStr) {
            Message mess = new Message();
            String[] messageValue = aaa.split("\\:");
            mess.setId(messageValue[0]);
            mess.setMessage(messageValue[1]);
            listMessage.add(mess);
        }
        return listMessage;
    }



}
