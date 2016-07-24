package com.sdingba.Dao.Impl;

import com.sdingba.Dao.AllDataAgeDao;
import com.sdingba.Dao.messageShareDao;
import com.sdingba.domain.daoBean.AllDataAge;
import com.sdingba.domain.daoBean.messageShare;
import com.sdingba.utils.DaoUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by su on 16-6-5.
 */
public class messageShareDaoImpl extends daobaseImpl<messageShare> implements messageShareDao {
    QueryRunner runner = new QueryRunner(DaoUtils.getSource());

    @Override
    public List<Map<String, Object>> returnMessageShareMap() {
        String sql = "select * from messageShare order by msId desc";
        try {
            return runner.query(sql, new MapListHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
