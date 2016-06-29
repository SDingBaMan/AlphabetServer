package com.sdingba.Service.Impl;

import com.sdingba.Dao.UserDataDao;
import com.sdingba.Dao.UserManDao;
import com.sdingba.Service.UserDataService;
import com.sdingba.domain.daoBean.UserData;
import com.sdingba.domain.daoBean.UserMan;
import com.sdingba.factory.Factory;
import com.sun.corba.se.spi.ior.ObjectKey;

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
}
