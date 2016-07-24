package com.sdingba.servlet;

import com.sdingba.Service.messageShareService;
import com.sdingba.factory.Factory;
import com.sdingba.utils.CommonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by su on 16-7-22.
 * http://localhost:8080/alphabetService/getmessageShareSerlvet
 */
@WebServlet(name = "getmessageShareSerlvet",urlPatterns = "/getmessageShareSerlvet")
public class getmessageShareSerlvet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

    private void execute(HttpServletRequest request, HttpServletResponse response) {

        messageShareService service = Factory.getFactory().getInstance(messageShareService.class);
        List<Map<String,Object>> maps =  service.returnMessageShare();


        Map<String, Object> sendMap = new HashMap<String, Object>();

        if (maps != null) {
//            System.out.println(userDatas.toString());
            sendMap.put("response", "messageShareGet");
            sendMap.put("resultMessageShare", maps);
//            System.out.println("xxx  "+sendMap.toString());
        }else{
            sendMap.put("response", "messageShareGet");
            sendMap.put("resultMessageShare", "noDate");
        }

        CommonUtil.renderJson(response,sendMap);


    }
}
