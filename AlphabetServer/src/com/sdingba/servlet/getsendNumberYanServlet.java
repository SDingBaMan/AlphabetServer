package com.sdingba.servlet;

import com.sdingba.Service.sendNumberService;
import com.sdingba.factory.Factory;
import com.sdingba.utils.CommonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by su on 16-7-23.
 */
@WebServlet(name = "getsendNumberYanServlet",urlPatterns = "/getsendNumberYanServlet")
public class getsendNumberYanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

    private void execute(HttpServletRequest request, HttpServletResponse response) {

        String userId = request.getParameter("userId");
        if (userId == null) {
            return;
        }

        sendNumberService service = Factory.getFactory().getInstance(sendNumberService.class);

        String number = service.getsendNumberYan(userId);

        Map<String, Object> sendMap = new HashMap<String, Object>();

        if (number != null) {
//            System.out.println(userDatas.toString());
            sendMap.put("response", "sendNumber");
            sendMap.put("sendNumber", number);
//            System.out.println("xxx  "+sendMap.toString());
        }else{
            sendMap.put("response", "sendNumber");
            sendMap.put("sendNumber", "noDate");
        }
        CommonUtil.renderJson(response,sendMap);
    }
}
