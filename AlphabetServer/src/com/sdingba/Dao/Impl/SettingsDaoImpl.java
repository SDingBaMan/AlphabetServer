package com.sdingba.Dao.Impl;

import com.sdingba.Dao.SettingsDao;
import com.sdingba.domain.daoBean.Settings;
import com.sdingba.utils.DaoUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * Created by su on 16-6-5.
 */
public class SettingsDaoImpl extends daobaseImpl<Settings> implements SettingsDao {
    QueryRunner runner = new QueryRunner(DaoUtils
            .getSource());

    @Override
    public Settings getLastTimeSetTimeSetNum(String userId) {
//        String sql = "select * from Settings where userId=?";
        String sql = "select * from Settings where userId= ? and timeSetNum=(select max(timeSetNum) from Settings where userId = ?)";
        try {
            return runner.query(sql, new BeanHandler<Settings>(Settings.class),userId,userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    //// TODO: 16-6-25 有问题
    @Override
    public String getMaxTimeTbale(String userId) {

        String sql = "select max(timeSetNum) from Alphabet.Settings where userId = ?";
        try {
            return runner.query(sql, new BeanHandler<String>(String.class), userId);

        } catch (SQLException e) {

            e.printStackTrace();
        }
        System.out.println("");
        return null;
    }
}
