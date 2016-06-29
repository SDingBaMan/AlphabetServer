package com.sdingba.Dao.Impl;

import com.sdingba.Dao.UserLoginDao;


import com.sdingba.domain.daoBean.UserLogin;
import com.sdingba.utils.DaoUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * Created by su on 16-6-5.
 */
public class UserLoginDaoImpl extends daobaseImpl<UserLogin> implements UserLoginDao {
    QueryRunner runner = new QueryRunner(DaoUtils
            .getSource());
    @Override
    public UserLogin findPassword(String zh, String pass) {
        String sql = "select * from UserLogin where ulId=? and ulpassword=?";

        try {
            return runner.query(sql,new BeanHandler<UserLogin>(UserLogin.class), zh, pass);

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }
}
