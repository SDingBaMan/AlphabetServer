package com.sdingba.Dao.Impl;

import com.sdingba.Dao.UserManDao;
import com.sdingba.domain.daoBean.UserMan;
import com.sdingba.utils.DaoUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by su on 16-6-2.
 */
public class UserManDaoimpl extends daobaseImpl<UserMan> implements UserManDao {

    @Override
    public Map<String, Object> UserIdFromUserMan(String username) {

        String sql = "select * from UserMan where UMId=?";
        Map<String, Object> map = null;
        try {
            System.out.println(sql.toString());

            map = runner.query(sql, new MapHandler(), username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public List<Map<String, Object>> returnFriendList(String username) {
        String sql="select umId,username from UserMan where umId in (select friendId from FriendUser where userId=?)";
        try {
            return runner.query(sql, new MapListHandler(), username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<UserMan> returnFriendListUserManDao(String username) {
        List<UserMan> maps = null;
        String sql="select * from UserMan where umId in (select friendId from FriendUser where userId=?)";
        try {
            maps = runner.query(sql, new BeanListHandler<UserMan>(UserMan.class), username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maps;
    }
}
