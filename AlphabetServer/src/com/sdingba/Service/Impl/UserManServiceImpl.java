package com.sdingba.Service.Impl;

import com.sdingba.Dao.UserLoginDao;
import com.sdingba.Dao.UserManDao;
import com.sdingba.Service.UserManService;
import com.sdingba.domain.daoBean.UserLogin;
import com.sdingba.factory.Factory;

import java.util.List;
import java.util.Map;

/**
 * Created by su on 16-6-21.
 */
public class UserManServiceImpl implements UserManService{

    @Override
    public Map<String, Object> UserIdFromUserMan(String username, String password) {
        UserLoginDao daoLogin = Factory.getFactory().getInstance(UserLoginDao.class);
        UserManDao dao = Factory.getFactory().getInstance(UserManDao.class);

        UserLogin a = daoLogin.findPassword(username, password);
        if (a == null) {
            return null;
        }


        Map<String,Object> map = dao.UserIdFromUserMan(username);

        return map;
    }

    @Override
    public List<Map<String, Object>> UserManFormIDByFriendList(String username) {
        UserManDao dao = Factory.getFactory().getInstance(UserManDao.class);

        return dao.returnFriendList(username);
    }
}
