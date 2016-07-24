package com.sdingba.Dao.Impl;

import com.sdingba.Dao.UserDataDao;
import com.sdingba.domain.daoBean.UserData;
import com.sdingba.domain.javabean.avgUserData;
import com.sdingba.utils.DaoUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by su on 16-6-5.
 */
public class UserDataDaoImpl extends daobaseImpl<UserData> implements UserDataDao {

    @Override
    public UserData findByLastTime(String userId) {
        QueryRunner runner = new QueryRunner(DaoUtils.getSource());
        String sql = "select * from UserData where userId = ? " +
                "and datetime=(select max(datetime) from UserData where userId = ?)";
        try {
            return runner.query(sql, new BeanHandler<UserData>(UserData.class), userId, userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Map<String,Object>> findByLimitTime(String userId, int timeNum) {
        QueryRunner runner = new QueryRunner(DaoUtils.getSource());

        String sql = "select datetime,dataNumber,surplusNumber from UserData where userId=? order by datetime desc limit ?";

        try {
            return runner.query(sql, new MapListHandler(), userId, timeNum);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Map<String, Object> avgForUserIdUserData(String userId) {
        QueryRunner runner = new QueryRunner(DaoUtils.getSource());
        String sql = "select avg(dataNumber),avg(surplusNumber) from UserData where userId=?";

        try {

            return runner.query(sql, new MapHandler(), userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public avgUserData avgForUserIdUserDataObject(String userId) {
        QueryRunner runner = new QueryRunner(DaoUtils.getSource());
        String sql = "select avg(dataNumber) dataNumber,avg(surplusNumber) surplusNumber from UserData where userId=?";

        try {

            return runner.query(sql, new BeanHandler<avgUserData>(avgUserData.class), userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public avgUserData avgForAllUserDataObject() {
        QueryRunner runner = new QueryRunner(DaoUtils.getSource());
        String sql = "select avg(dataNumber) dataNumber,avg(surplusNumber) surplusNumber from UserData";
        try {
            return runner.query(sql, new BeanHandler<avgUserData>(avgUserData.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<UserData> findUserIdREsultList(String userId) {
        QueryRunner runner = new QueryRunner(DaoUtils.getSource());
        String sql = "select * from UserData where userId=?";

        try {
            return runner.query(sql, new BeanListHandler<UserData>(UserData.class), userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


}
