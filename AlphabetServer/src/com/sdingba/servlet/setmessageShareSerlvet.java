package com.sdingba.servlet;

import com.sdingba.Service.messageShareService;
import com.sdingba.domain.daoBean.messageShare;
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
import java.util.Date;

/**
 * Created by su on 16-7-22.
 * http://localhost:8080/alphabetService/setmessageShareSerlvet?userId=sdingba&title=sssss&context=sssss
 */
@WebServlet(name = "setmessageShareSerlvet", urlPatterns = "/setmessageShareSerlvet")
public class setmessageShareSerlvet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

    private void execute(HttpServletRequest request, HttpServletResponse response) {
        messageShareService service = Factory.getFactory().getInstance(messageShareService.class);
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String userId = request.getParameter("userId");
        String title = request.getParameter("title");
        String context = request.getParameter("context");

        if (title == null || userId == null || context == null) {
            out.print("ErrorSetMessageShare");
            return;
        }

        String time = TimeUtils.getSqlNewDay();
        java.sql.Date datatimeCun = java.sql.Date.valueOf(time);

        messageShare messageShare = new messageShare();
        messageShare.setUserId(userId);
        messageShare.setTitle(title);
        messageShare.setContent(context);
        messageShare.setDatetime(datatimeCun);

        int a = service.InsertData(messageShare);

        if (a > 0) {
            // 成功
            out.print("OkSetMessageShare");
        } else {
            // 失败
            out.print("ErrorSetMessageShare");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }
}
