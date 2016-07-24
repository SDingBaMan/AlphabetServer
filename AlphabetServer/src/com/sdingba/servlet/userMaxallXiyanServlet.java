package com.sdingba.servlet;

import com.sdingba.Service.UserDataService;
import com.sdingba.domain.javabean.avgUserData;
import com.sdingba.factory.Factory;
import com.sdingba.utils.CommonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by su on 16-7-24.
 */
@WebServlet(name = "userMaxallXiyanServlet",urlPatterns = "/userMaxallXiyanServlet")
public class userMaxallXiyanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request,response);
    }

    private void execute(HttpServletRequest request, HttpServletResponse response) {

        UserDataService service = Factory.getFactory().getInstance(UserDataService.class);
        String userId = request.getParameter("userId");

        if (userId.equals("") || userId == null) {
            return;
        }

        String max = service.maxAllXiyan(userId);
        avgUserData avgall = service.avgForAllUserDataObject();
        avgUserData avgper = service.avgForUserIdUserDataObject(userId);

        Map<String, Object> sendMap = new HashMap<String, Object>();

        if (max != null) {

            sendMap.put("response", "userMaxAll");
            sendMap.put("sendNumber", max);
            sendMap.put("avgAll", avgall.getDataNumber());
            sendMap.put("avgUser", avgper.getDataNumber());

        }else{

            sendMap.put("response", "userMaxAll");
            sendMap.put("sendNumber", "noDate");
        }
        CommonUtil.renderJson(response,sendMap);


    }
}
