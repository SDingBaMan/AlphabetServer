package com.sdingba.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by su on 16-6-25.
 */
public class TimeUtils {
    public static String getNewDay() {

        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");

        return df.format(new Date());
    }

    public static String getSqlNewDay() {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        return df.format(new Date());
    }

    public static  java.sql.Date getesqlNewDayF() {
        String time = TimeUtils.getSqlNewDay();
        java.sql.Date datatimeCun = java.sql.Date.valueOf(time);
        return datatimeCun;
    }

    public static java.sql.Date getsetSendNumberYanzengsongDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);//让日期加1

        String dayTime = df.format(calendar.getTime());
        return java.sql.Date.valueOf(dayTime);
    }

    /**
     * 返回最后一天的 时间
     *
     * @param alltime 时间 天数
     * @return
     */
    public static String getEndDateTime(String alltime) {

        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
        String ActividayTime = df.format(new Date());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + Integer.parseInt(alltime));//让日期加1

        String dayTime = df.format(calendar.getTime());

        return dayTime;
    }


    /**
     * //输入 6:6,6:6,6:6,6:12,6:12,7:12
     * 返回时间
     *
     * @param datastr
     * @return
     */
    public static String getalltime(String datastr) {
        String[] strlist = datastr.split("\\,");
        int alltime = 0;
        for (String str : strlist) {
            int s = Integer.parseInt(str.split(":")[0]);
            alltime += s;
        }
        return String.valueOf(alltime);
    }


    /**
     * 通过开始时间  和   结束 时间 计算 所用时间
     *
     * @param start
     * @param end
     * @return
     */
    public static String getalltimebytime(String start, String end) {
//        String d1 = "2015-04-17";
//        String d2 = "2015-06-17";
        /* 先转成毫秒并求差 */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long m = 0;
        try {
            m = sdf.parse(end).getTime() - sdf.parse(start).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long alltime = (m / (1000 * 60 * 60 * 24));
        return String.valueOf(alltime);
    }

    /**
     * 吧 20130303 的 utils.data格式  转化 成 sql.date的格式
     *
     * @param day
     * @return
     */
    public static java.sql.Date dayStringToSQLData(String day) {

        Date df = null;//设置日期格式
        try {
            df = new SimpleDateFormat("yyyyMMdd").parse(day);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String format = new SimpleDateFormat("yyyy-MM-dd").format(df);
        java.sql.Date datatimeCun = java.sql.Date.valueOf(format);
        return datatimeCun;
    }
}
