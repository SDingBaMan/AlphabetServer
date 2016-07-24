package com.sdingba.servlet;

import com.sdingba.Service.UserManService;
import com.sdingba.factory.Factory;
import com.sdingba.utils.CommonUtil;

import javax.servlet.RequestDispatcher;
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
 * Created by su on 16-6-22.
 * http://localhost:8080/alphabetService/GetFriendById?username=sdingba
 *
 * {"friendlistdata":[
 *
 * {"umId":"aaaa","username":"aaaa"},
 * {"umId":"admin","username":"管理猿"},
 * {"umId":"alphabet","username":"之母表"},
 * {"umId":"jayzhou","username":"周杰伦"},
 * {"umId":"kobe","username":"科比"},
 * {"umId":"kunling","username":"昆凌"},
 * {"umId":"xiong","username":"熊"},
 * {"umId":"xiongxiong","username":"熊"}
 *
 * ],"response":"friendlist"}
 *
 */
@WebServlet(name = "GetFriendById",urlPatterns = "/GetFriendById")
public class GetFriendById extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request,response);
    }

    private void execute(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("xxxxxxxxxxxxxx");
        String username = request.getParameter("username");

        if (username == null || username.equals("")) {
            return;
        }

        UserManService serviceUserMan = Factory.getFactory().getInstance(UserManService.class);

        List<Map<String, Object>> map = serviceUserMan.UserManFormIDByFriendList(username);

        Map<String, Object> data = new HashMap<String, Object>();
        if (map.isEmpty()) {

        }else{
            //no null
            data.put("response", "friendlist");
            data.put("friendlistdata", map);
//          System.out.println("xxx :     "+map.toString());
            System.out.println("xxxxxsss  "+data.toString());
        }
//      List<UserMan> mapss = DAO.returnFriendListUserManDao("sdingba");

        System.out.println(data);

        CommonUtil.renderJson(response, data);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request,response);
    }


}
