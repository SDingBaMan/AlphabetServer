import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by su on 16-6-23.
 */
public class demo {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(new Date());

        System.out.println(calendar.getWeekYear());

        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));//今天的日期

        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 12);//让日期加1

        System.out.println(calendar.get(Calendar.DATE));//加1之后的日期Top


        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式

        System.out.println(df.format(calendar.getTime()));//加1之后的日期Top


        System.out.println("=================================");


        //"yyyyMMdd"   --  > 要使用的类型。
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间


    }

    @Test
    public void test1() {

        String datastr = "20160303";

        String scheel = "5:18,6:20,3:9";
//
//        //
        String xxx = PullStringToDate(datastr, scheel);
//        // 20160308:18 , 20160314:15 , 20160324:10 , 20160503:7

//        String xxx = "20160308:18,20160314:15";
//        getLastDataSc(xxx);

    }

    private void getLastDataSc(String xxx) {
        System.out.println(xxx);
        String[] list = xxx.split("\\,");
        StringBuffer lastDateSc = new StringBuffer();
        int leng = list.length;
        if (leng > 1) {
            for (int i = 1; i < leng; i++) {
                lastDateSc.append(list[i]+",");
            }
            lastDateSc.delete(lastDateSc.length() - 1, lastDateSc.length());

            Pulldate(list[0]);
        }else{

        }



        // TODO: 16-6-23 修改  值
        System.out.println(lastDateSc.toString());
    }

    /**
     * 解析
     * @param s
     */
    private void Pulldate(String s) {
        String[] sss = s.split("\\:");
        System.out.println(sss[0]+"xxxx"+sss[1]);
    }

    /**
     * @param datastr 设置日期
     * @param scheel  处理安排表
     * @return all 总共时间安排表  生成的安排表
     */
    private String PullStringToDate(String datastr, String scheel) {

        try {
            Date date = new SimpleDateFormat("yyyyMMdd").parse(datastr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            /**
             * 生成的安排表
             */
            StringBuffer anpaibiao = new StringBuffer();

            int allday = 0;

            String[] list = scheel.split("\\,");
            for (String foo : list) {

                String[] anPai = foo.split("\\:");

                int dayNum = Integer.parseInt(anPai[0]);

                allday += dayNum;

                calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + dayNum);//让日期加1
                SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式

                String dayTime = df.format(calendar.getTime());
                anpaibiao.append(dayTime + ":" + anPai[1] + ",");
            }

            System.out.println("dsfdf  " + allday);
            anpaibiao.delete(anpaibiao.length() - 1, anpaibiao.length());
            System.out.println(anpaibiao.toString());
            System.out.println("一共吸烟天使 ： " + allday);

            return anpaibiao.toString();

        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("cccc");
            return "";
        }
    }

    @Test
    public void sss() throws ParseException {
        String s = "20140301";
        String p = "20160101";
        System.out.println(Integer.parseInt(s) < Integer.parseInt(p));
        java.util.Date dfs =new SimpleDateFormat("yyyyMMdd").parse("20130101");//设置日期格式
         String  ff = new SimpleDateFormat("yyyy-MM-dd").format(dfs).toString();
//        System.out.println(ff.format(dfs).toString());
//        System.out.println(dfs.);
//        java.sql.Date df = java.sql.Date.valueOf(ff.format(dfs).toString());
//        System.out.println(df);
    }


    @Test
    public void sta() throws ParseException {
//        String a = "6:6,6:6,6:6,6:12,6:12,7:12";
//        String[] strlist = a.split("\\,");
//        int alltime=0;
//        for (String str : strlist) {
//            int s = Integer.parseInt(str.split(":")[0]);
//            alltime += s;
//        }
//        System.out.println(String.valueOf(alltime));
        //
        String d1 = "2015-04-17";
        String d2 = "2015-06-17";

        /* 先转成毫秒并求差 */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long m = sdf.parse(d2).getTime() - sdf.parse(d1).getTime();

        /* 根据你的需求进行单位转换 */
        System.out.println("相差毫秒数:"+ m );
        System.out.println("相差天数:"+ ( m / (1000 * 60 * 60 * 24) ) );
    }


}
