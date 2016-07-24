package com.sdingba.servlet;

import com.sdingba.Service.UserDataService;
import com.sdingba.Service.UserManService;
import com.sdingba.domain.daoBean.UserData;
import com.sdingba.domain.daoBean.UserMan;
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
 * Created by su on 16-7-2.
 */
@WebServlet(name = "UserDataServlet", urlPatterns = "/UserDataServlet")
public class UserDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

    private void execute(HttpServletRequest request, HttpServletResponse response) {
        String nameId = request.getParameter("userId");


        UserManService userManService = Factory.getFactory().getInstance(UserManService.class);
        Map<String, Object> map = userManService.findUser(nameId);
        if (map.isEmpty()) {
            return;
        }

        UserDataService userDataService = Factory.getFactory().getInstance(UserDataService.class);

        List<Map<String, Object>> userDatas = userDataService.resultDataForTime(nameId, 7);


        System.out.println(userDatas);

        Map<String, Object> sendMap = new HashMap<String, Object>();

        if (userDatas != null) {
//            System.out.println(userDatas.toString());
            sendMap.put("response", "userdatalist");
            sendMap.put("resultUserdataList", userDatas);
//            System.out.println("xxx  "+sendMap.toString());
        } else {
            sendMap.put("response", "userdatalist");
            sendMap.put("resultUserdataList", "noDate");
        }

        /*
        * {"resultUserdataList":
        * [{"datetime":"20160728","dataNumber":0,"surplusNumber":6},
            * {"datetime":"20160727","dataNumber":0,"surplusNumber":6},
            * {"datetime":"20160726","dataNumber":0,"surplusNumber":10},
            * {"datetime":"20160726","dataNumber":0,"surplusNumber":10},
            * {"datetime":"20160726","dataNumber":0,"surplusNumber":10},
            * {"datetime":"20160725","dataNumber":0,"surplusNumber":6},
            * {"datetime":"20160725","dataNumber":0,"surplusNumber":6}]
        * ,"response":"userdatalist"}*/

        CommonUtil.renderJson(response, sendMap);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

}
