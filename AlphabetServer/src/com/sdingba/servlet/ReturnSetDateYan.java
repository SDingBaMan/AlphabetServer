package com.sdingba.servlet;

import com.sdingba.Service.SettingsService;
import com.sdingba.domain.javabean.setDataYan;
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
 * Created by su on 16-6-25.
 * 客户端 获取 服务器 的 最后一次的数据；
 * （  设置吸烟计划的数据  ）
 * <p>
 * http://localhost:8080/alphabetService/ReturnSetDateYan?username=sdingba
 * <p>
 * //{
 * // "result":{
 * // "dataJiHua":"6:6,6:6,6:6,6:12,6:12,7:12",
 * // "startTime":"20160808"
 * // },
 * // "response":"getSetDataYan"
 * // }
 */
@WebServlet(name = "ReturnSetDateYan", urlPatterns = "/ReturnSetDateYan")
public class ReturnSetDateYan extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        excetue(request, response);
    }

    private void excetue(HttpServletRequest request, HttpServletResponse response) {
        String userId = request.getParameter("username");

        //登陆完后才有的操作；不需要在判断是否要登陆了。

        SettingsService service = Factory.getFactory().getInstance(SettingsService.class);

        setDataYan setData = service.getSchelloTable(userId);

        Map<String, Object> map = new HashMap<String, Object>();
        if (setData == null) {

            map.put("response", "getSetDataYan");
            map.put("resultSetdata", "noDate");

//          返回错误的 error

        } else {

            map.put("response", "getSetDataYan");
            map.put("resultSetdata", setData);
            //返回 map 的数值
        }
        CommonUtil.renderJson(response, map);

        //{
        // "resultSetdata":{
        //     "dataJiHua":"6:6,6:6,6:6,6:12,6:12,7:12",
        //     "startTime":"20160808"
        //  },
        // "response":"getSetDataYan"
        // }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        excetue(request, response);
    }
}
