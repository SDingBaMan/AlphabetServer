package com.sdingba.Service.Impl;

import com.sdingba.Dao.UserManDao;
import com.sdingba.Dao.userDaoT;
//import com.sdingba.Dao.userDap;
import com.sdingba.Service.UserServer;
import com.sdingba.domain.daoBean.UserMan;
import com.sdingba.domain.testdomain;
import com.sdingba.factory.Factory;

/**
 * Created by su on 16-6-1.
 */
public class UserServerImpl implements UserServer {
//    @Override
//    public testdomain findCustById(String id) {
//        userDap dao = Factory.getFactory().getInstance(userDap.class);
////        return dao.findCustById(id);
//        return dao.findClassByID(testdomain.class, "aaa" , id);
//    }
//
//
//    @Override
//    public testdomain findCustById2(String id) {
//        userDap dao = Factory.getFactory().getInstance(userDap.class);
//        return dao.findCustById(id);
////        return dao.findClassByID(testdomain.class,"aaa", id);
//    }

    @Override
    public testdomain findCustById3(String id) {
        userDaoT dao = Factory.getFactory().getInstance(userDaoT.class);
        testdomain aa = new testdomain();
        aa.setAaa(30044);


        dao.InsertDataToDao(aa);
        return null;

//        return dao.findClassByID(testdomain.class,"aaa", id);
    }

    @Override
    public void UserMan() {
        UserManDao dao = Factory.getFactory().getInstance(UserManDao.class);
//
//        UserMan aa = new UserMan();
//        aa.setUMId("admdds深行行行sssssin");
//        aa.setUsername("ccc");
//        aa.setNickName("xx");
//        aa.setFifter(1);
//        aa.setAge("21");
//        aa.setMail("ss");
//        aa.setPhone("110");
//        aa.setSex(1);
//        aa.setState(1);
//
//        dao.InsertDataToDao(aa);

        //select
        UserMan aaa = new UserMan();
        aaa = dao.findTableById("sdingba");
        System.out.println(aaa.sqlStringInsert());

        //detele :
//        int i = dao.deleteDataById("admddin");
//        System.out.println(i);
//        System.out.println("delete...");

//        List<UserMan> aaaa = new ArrayList<>();
//
//        aaaa = dao.findListDataBySendId("ccc");
//
//        for (UserMan aa : aaaa) {
//            System.out.println(aa.returnSQLTableListId());
//            System.out.println("=========");
//        }
//        System.out.println(aaaa==null);

    }




}
