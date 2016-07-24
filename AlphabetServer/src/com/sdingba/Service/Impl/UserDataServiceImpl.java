package com.sdingba.Service.Impl;

import com.sdingba.Dao.UserDataDao;
import com.sdingba.Dao.UserManDao;
import com.sdingba.Service.UserDataService;
import com.sdingba.domain.daoBean.UserData;
import com.sdingba.domain.daoBean.UserMan;
import com.sdingba.domain.javabean.avgUserData;
import com.sdingba.factory.Factory;
import com.sun.corba.se.spi.ior.ObjectKey;

import java.util.List;
import java.util.Map;

/**
 * Created by su on 16-6-24.
 */
public class UserDataServiceImpl implements UserDataService {
    UserDataDao dao = Factory.getFactory().getInstance(UserDataDao.class);

    @Override
    public String CurdUserDataDay(UserData userData) {
        UserManDao daoMan = Factory.getFactory().getInstance(UserManDao.class);
        //是否有这个用户
        UserMan userDaoMan = daoMan.findTableById(userData.getUserId());
        if (userDaoMan != null) {
            int i = dao.InsertDataToDao(userData);
            if (i == 1) {
                return "ok";
            }
        } else {
            return "error";
        }

        return "error";
    }

    @Override
    public List<Map<String,Object>> resultDataForTime(String userId, int timeNum) {

        List<Map<String, Object>> map = dao.findByLimitTime(userId, timeNum);
        for (Map<String, Object> xx : map) {
            java.sql.Date str = (java.sql.Date) xx.get("datetime");
            String datastr = str.toString();
            xx.put("datetime", datastr.replaceAll("-", ""));
        }
        return map;
    }

    @Override
    public avgUserData avgForUserIdUserDataObject(String userId) {
        return dao.avgForUserIdUserDataObject(userId);
    }

    @Override
    public avgUserData avgForAllUserDataObject() {
        return dao.avgForAllUserDataObject();
    }

    @Override
    public String maxAllXiyan(String userId) {
        List<UserData> datas = dao.findUserIdREsultList(userId);
        if (datas != null) {
            int allNum=0;
            for (UserData data : datas) {
                int  num = data.getDataNumber();
                allNum += num;
            }
            return allNum+"";
        }
        return null;
    }


}
