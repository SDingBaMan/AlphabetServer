package com.sdingba.test;

import com.sdingba.Dao.UserManDao;
import com.sdingba.Service.UserManService;
import com.sdingba.Service.UserServer;
import com.sdingba.domain.daoBean.UserMan;
import com.sdingba.domain.testdomain;
import com.sdingba.factory.Factory;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by su on 16-6-1.
 */
public class c3p0test {
    public static void main(String[] args) {

    }

//    @Test
//    public void c3p0Test(){
//        UserServer server = Factory.getFactory().getInstance(UserServer.class);
//        testdomain cust = server.findCustById("2");
////		server.updataCustbyId("16");
//        System.out.println(cust.getAaa());
//        System.out.println("ok");
//    }
//
//    @Test
//    public void com.sdingba.utils() {
//        UserServer server = Factory.getFactory().getInstance(UserServer.class);
//        testdomain cust = server.findCustById2("2");
////		server.updataCustbyId("16");
//        System.out.println(cust.getAaa());
//        System.out.println("sssok");
//    }

    @Test
    public void test2(){
        UserServer server = Factory.getFactory().getInstance(UserServer.class);
//        testdomain cust = server.findCustById3("2");
        server.UserMan();
        //
//		server.updataCustbyId("16");
//        System.out.println(cust.getAaa());
        System.out.println("sssok");
    }



    @Test
    public void test3(){
        UserManService DAO = Factory.getFactory().getInstance(UserManService.class);
        List<Map<String, Object>> map = DAO.UserManFormIDByFriendList("sdingba");
        Map<String,Object> aa = DAO.UserIdFromUserMan("hhh", "sdingba");
//        List<UserMan> mapss = DAO.returnFriendListUserManDao("sdingba");
        System.out.println(aa);
        System.out.println("======");
        System.out.println(map.isEmpty());

//        System.out.println("sss");
//        System.out.println(mapss.toString());
//        System.out.println(mapss);


    }
}
