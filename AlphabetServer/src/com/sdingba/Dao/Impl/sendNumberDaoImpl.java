package com.sdingba.Dao.Impl;

import com.sdingba.Dao.sendNumberDao;
import com.sdingba.domain.daoBean.SendMessage;
import com.sdingba.domain.daoBean.sendNumber;
import com.sdingba.utils.DaoUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Date;
import java.sql.SQLException;

/**
 * Created by su on 16-7-23.
 */
public class sendNumberDaoImpl extends daobaseImpl<sendNumber> implements sendNumberDao {
    QueryRunner runner = new QueryRunner(DaoUtils.getSource());



    @Override
    public sendNumber getSendNumberYan(String reviceId, Date time) {
        String sql = "select sum(uumber) uumber from sendNumber where reciveId=? and datetime=?";
        try {
            return  runner.query(sql, new BeanHandler<sendNumber>(sendNumber.class), reviceId, time);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
