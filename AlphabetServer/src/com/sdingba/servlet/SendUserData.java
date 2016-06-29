package com.sdingba.servlet;

import com.sdingba.Service.UserDataService;
import com.sdingba.domain.daoBean.UserData;
import com.sdingba.factory.Factory;
import com.sun.org.apache.xpath.internal.SourceTree;
import sun.java2d.pipe.SpanIterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * Created by su on 16-6-24.
 */
@WebServlet(name = "SendUserData", urlPatterns = "/SendUserData")
public class SendUserData extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }


    private void execute(HttpServletRequest request, HttpServletResponse response) {

        UserDataService service = Factory.getFactory().getInstance(UserDataService.class);

        String id = request.getParameter("userId");
        System.out.println("===== " + id + " ===========");
        String datatime = request.getParameter("datatime");
        String lastYan = request.getParameter("lastYanNumber");
        String yiyanNumber = request.getParameter("yiyanNumber");

        java.sql.Date datatimeCun = null;
        try {
            java.util.Date df = new SimpleDateFormat("yyyyMMdd").parse(datatime);//设置日期格式
            String format = new SimpleDateFormat("yyyy-MM-dd").format(df);
            datatimeCun = java.sql.Date.valueOf(format);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        UserData userdate = new UserData();
        userdate.setDatetime(datatimeCun);
        userdate.setDataNumber(Integer.parseInt(yiyanNumber));
        userdate.setSurplusNumber(Integer.parseInt(lastYan));
        userdate.setUserId(id);

        String result = service.CurdUserDataDay(userdate);
        System.out.println(result + " ====== ");
        try {
            PrintWriter out = response.getWriter();
            if (result.equals("ok")) {
                out.print("OkUserData");
            } else if (result.equals("error")) {
                out.print("errorUserData");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
