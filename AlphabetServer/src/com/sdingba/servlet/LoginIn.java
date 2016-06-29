package com.sdingba.servlet;

import com.sdingba.Dao.UserManDao;
import com.sdingba.Service.UserManService;
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
 * Created by su on 16-6-3.
 */
@WebServlet(name = "LoginIn",urlPatterns = "/LoginIn")
public class LoginIn extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("xcccxc");
        super.init();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("xxxxx");
        execpet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execpet(request,response);
    }

    private void execpet(HttpServletRequest request, HttpServletResponse response) {
        String zh = request.getParameter("username");
        String pw = request.getParameter("password");
        System.out.println(zh + "++++++" + pw);

        if ("".equals(zh) || "".equals(pw) || zh == null || pw == null) {
            return;
        }

        UserManService dao = Factory.getFactory().getInstance(UserManService.class);

        Map<String,Object> map = dao.UserIdFromUserMan(zh,pw);

        Map<String, Object> data = new HashMap<String, Object>();
        if (map != null) {


            data.put("response", "login");
            data.put("userinfo", map);
//        System.out.println("xxx : "+map.toString());
            System.out.println("xxxxxsss  "+data.toString());



        }else{
            Map<String, String> error = new HashMap<String, String>();
            error.put("text", "用户名或密码错误！");

            data.put("response", "error");
            data.put("error", error);
        }



        CommonUtil.renderJson(response, data);


    }
}
