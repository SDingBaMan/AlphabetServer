package com.sdingba.utils;


import org.junit.Test;


import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by su on 16-6-8.
 */
public class TimeUtiles {
    public static String getDataTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd ");//设置日期格式
        return df.format(new Date());
    }

    @Test
    public void dfdsf(){
        System.out.println(getDataTime());
    }
}
