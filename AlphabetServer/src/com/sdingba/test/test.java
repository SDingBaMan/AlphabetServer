package com.sdingba.test;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by su on 16-6-1.
 */
public class test {

    public static void main(String[] args) {
        ArrayList<String> aa = new ArrayList<>();
        aa.add("xxx");
        aa.add("vvv");
        System.out.println(aa.toString());

        Object[] p = new Object[10];
        Object[] p111 = {"xxx", "vvv"};

        String a1 = "xxx";
        Object p1 = a1;
        p[0] = p1;
        System.out.println(p111.toString());
        System.out.println(p.toString());
    }

    @Test
    public void test() {
        String aa = ":xxx:xxx:xxx";
        String[] s = aa.split(":");
        Object[] r = new Object[s.length];
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("")) {
                r[i] = null;
            } else {

                r[i] = s[i];
            }
        }

        for (Object a : r) {
            if (a == null) {
                System.out.println("sss");
            } else{
                System.out.println(a.toString());
            }
        }
        System.out.println(r.length);
        System.out.println("------------------------");
        System.out.println(s[0] == null);
        System.out.println(s.length);
    }

    @Test
    public void stttt(){

//        StringBuffer sqlstring = new StringBuffer("insert into aaa values(?)").append("ccc");
//        String aa = sqlstring.toString().replace("aaa", "xxx");
//        System.out.println(aa);
//        System.out.println(sqlstring.toString());

        System.out.println("--------------------------");
        StringBuffer sqlstring = new StringBuffer("insert into tableMysql values(");
        for (int i = 0; i < 5; i++) {
            sqlstring = i == 5-1 ? sqlstring.append("?)") : sqlstring.append("?,");
        }
        System.out.println(sqlstring.toString());
    }

}
