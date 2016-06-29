package com.sdingba.servlet;

import com.sdingba.Service.SettingsService;
import com.sdingba.Service.UUIDSetDateService;
import com.sdingba.domain.daoBean.Settings;
import com.sdingba.factory.Factory;
import com.sdingba.utils.TimeUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;

/**
 * Created by su on 16-6-25.
 * 客服端 提交给 服务数据
 * http://localhost:8080/alphabetService/SubmitSetDataYan?username=sdingba&starttime=20160808&datasetSc=6:6,6:6,6:6,6:12,6:12,7:12
 */
@WebServlet(name = "SubmitSetDataYan", urlPatterns = "/SubmitSetDataYan")
public class SubmitSetDataYan extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

    /*
    *
    * username
    * startTime
    * endTime
    * date 3:10,3:8,2:8,3:8
    *
    * */
    //
    private void execute(HttpServletRequest request, HttpServletResponse response) {
        SettingsService serviceSettings = Factory.getFactory().getInstance(SettingsService.class);
        UUIDSetDateService uuidSetDateService = Factory.getFactory().getInstance(UUIDSetDateService.class);

        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String username = request.getParameter("username");
        String starttime = request.getParameter("starttime");
        String datastr = request.getParameter("datasetSc");


        // 6:6,6:6,6:6,6:12,6:12,7:12
//        String aa = "6:6,6:6,6:6,6:12,6:12,7:12";

//      dao.getLastTimeSetTimeSetNum("sdingba");
        Settings setMax = serviceSettings.getMaxTimeTbale(username);

        if (setMax == null) {
            //可能 返回的值为空的原因是 这个用户还没有数据。

            int timesetnum = 1;
            String alltime = TimeUtils.getalltime(datastr);
            String endtime = TimeUtils.getEndDateTime(alltime);



            Settings settings = new Settings();
            settings.setSid(username);
            settings.setUserId(username);
            settings.setTimeNum(alltime);
            settings.setTimeSetNum(String.valueOf(timesetnum));
            settings.setBeginDatetime(TimeUtils.dayStringToSQLData(starttime));
            settings.setEndDatetime(TimeUtils.dayStringToSQLData(endtime));

            //保存 settings 的
            serviceSettings.insertSetDataservice(settings);

            //// TODO: 16-6-26 处理 datastr的数据了，加入到 UUIDSetData 数据库 中 ；
            //datastr = 6:6,6:6,6:6,6:12,6:12,7:12
            int result = uuidSetDateService.InsertDataUUIDSetDate(datastr, username, String.valueOf(timesetnum));

            if (result > 0) {
                //ok
                out.print("submitDateOk");
            } else {
                out.print("submitDateError");
            }

        } else {

            //// TODO: 16-6-28 判断 是否  最后一天大于  现在的 时间
//        if (Integer.parseInt(setMax.getEndDatetime().toString().replace("-", "")) < Integer.parseInt(TimeUtils.getNewDay())) {
//            //还有 历史 计划
//            System.out.println("xxxx");
//
//        } else {
            int timeSetNum = Integer.parseInt(setMax.getTimeSetNum()) + 1;

//          String alltime = TimeUtils.getalltime("6:6,6:6,6:6,6:12,6:12,7:12");
            String alltime = TimeUtils.getalltime(datastr);
            String endtime = TimeUtils.getEndDateTime(alltime);

            // TODO: 16-6-26 判断 是否小鱼 最后 一天 的 时间

            Settings settings = new Settings();
            settings.setSid(username + timeSetNum);
            settings.setUserId(username);
            settings.setTimeNum(alltime);
            settings.setTimeSetNum(String.valueOf(timeSetNum));
            settings.setBeginDatetime(TimeUtils.dayStringToSQLData(starttime));
            settings.setEndDatetime(TimeUtils.dayStringToSQLData(endtime));

            //保存 settings 的
            serviceSettings.insertSetDataservice(settings);

            //// TODO: 16-6-26 处理 datastr的数据了，加入到 UUIDSetData 数据库 中 ；
            //datastr = 6:6,6:6,6:6,6:12,6:12,7:12
            int result = uuidSetDateService.InsertDataUUIDSetDate(datastr, username, String.valueOf(timeSetNum));

            if (result > 0) {
                //ok
                out.print("submitDateOk");
            } else {
                out.print("submitDateError");
            }
            //
            //1,获取最后一次是第几次设置，然后 加1

            //| sid   | userId  | timeNum | timeSetNum | beginDatetime | endDatetime |

            //| sid =userId+timeSetNum |
            //| userId  | timeNum | timeSetNum (getMaxTimeTbale()+1)| beginDatetime | endDatetime |


            //| uuIDId   | setId   |  setNum (  ) |   timeCyc  | timeOrder     | yanNumber |


        }
    }


//    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }


}
