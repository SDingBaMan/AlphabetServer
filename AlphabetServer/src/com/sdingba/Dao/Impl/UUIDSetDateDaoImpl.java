package com.sdingba.Dao.Impl;

import com.sdingba.Dao.UUIDSetDateDao;
import com.sdingba.Dao.daobase;
import com.sdingba.domain.daoBean.UUIDSetDate;
import com.sdingba.utils.DaoUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by su on 16-6-5.
 */
public class UUIDSetDateDaoImpl extends daobaseImpl<UUIDSetDate> implements UUIDSetDateDao {

    QueryRunner runner = new QueryRunner(DaoUtils.getSource());

    @Override
    public List<UUIDSetDate> getListClassUUIDSETDate(String setNum, String userId) {
        String sql = "select * from Alphabet.UUIDSetDate where setNum = ? and setId=? order by timeOrder";
        try {
            return runner.query(sql, new BeanListHandler<UUIDSetDate>(UUIDSetDate.class), setNum, userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int InsertListUUIDSetData(List<UUIDSetDate> uuidSetDates) {

        int length = uuidSetDates.size();
        Object[] params = new Object[length * 6];

        StringBuffer sql = new StringBuffer();
        sql.append("insert into UUIDSetDate values ");
        for (int i = 0; i < length; i++) {

            sql.append("(?,?,?,?,?,?),");
            params[0 + i * 6] = null;
            params[1 + i * 6] = uuidSetDates.get(i).getSetId();
            params[2 + i * 6] = uuidSetDates.get(i).getSetNum();
            params[3 + i * 6] = uuidSetDates.get(i).getTimeCyc();
            params[4 + i * 6] = uuidSetDates.get(i).getTimeOrder();
            params[5 + i * 6] = uuidSetDates.get(i).getYanNumber();

        }
        int lenthSql = sql.length();
        sql.delete(lenthSql - 1, lenthSql);

        try {
            return runner.update(sql.toString(), params);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


}
