package com.sdingba.servlet;

import com.sdingba.Service.messageShareService;
import com.sdingba.Service.sendNumberService;
import com.sdingba.domain.daoBean.sendNumber;
import com.sdingba.factory.Factory;
import com.sdingba.utils.TimeUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by su on 16-7-23.
 * http://localhost:8080/alphabetService/setsendNumberYanServlet?reciveId=sdingba&sendId=alphabet&uumber=3
 */
@WebServlet(name = "setsendNumberYanServlet", urlPatterns = "/setsendNumberYanServlet")
public class setsendNumberYanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

    private void execute(HttpServletRequest request, HttpServletResponse response) {

        sendNumberService service = Factory.getFactory().getInstance(sendNumberService.class);


        String reciveId = request.getParameter("reciveId");
        String sendId = request.getParameter("sendId");
        String uumber = request.getParameter("uumber");

        if (sendId.equals("") || uumber == null || reciveId == null || sendId == null) {
            return;
        }

        sendNumber su = new sendNumber();

        su.setReciveId(reciveId);
        su.setSendId(sendId);
        su.setUumber(Integer.parseInt(uumber));


        java.sql.Date datatimeCun = TimeUtils.getsetSendNumberYanzengsongDate();


        su.setDatetime(datatimeCun);

        int a = service.setsendNumberYan(su);
        System.out.println(a);
        PrintWriter out = null;
        try {
            out = response.getWriter();
            if (a > 0) {
                // 成功
                out.print("OkSetsendNumber");
            } else {
                // 失败
                out.print("ErrorSetsendNumber");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
