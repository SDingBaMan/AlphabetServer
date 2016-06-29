package com.sdingba.dao.daoImpl;

import com.sdingba.bean.Sendqq;
import com.sdingba.dao.sendMessageDao;
import com.sdingba.factory.DaoUtils;
import com.sdingba.utils.TimeUtiles;
import com.sun.xml.internal.ws.resources.SenderMessages;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by su on 16-6-7.
 * Message
 */
public class sendMessageDaoImpl implements sendMessageDao {


    @Override
    public List<Sendqq> MessageHistory(String sendid, String revicesId,int readIs) {

        String sql = "select * from Sendqq where ReciveId = ? and SendId = ? and readIs = ?";

        QueryRunner runner = new QueryRunner(DaoUtils.getSource());
        try {
            return runner.query(sql, new BeanListHandler<Sendqq>(Sendqq.class), revicesId, sendid,readIs);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public void addMessageSendqq(String sendId, String RevicesId, String message) {
        String sql = "insert into Sendqq values(null,?,?,?,?,?)";

        QueryRunner runner = new QueryRunner(DaoUtils.getSource());
        try {
            runner.update(sql, RevicesId, sendId, message, TimeUtiles.getDataTime(), 1);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public void updateMEssageRW(String sendid, String revicesId) {
        String sql = "update Sendqq set readIs = 0 where SendId=? and ReciveId=?";
        QueryRunner runner = new QueryRunner(DaoUtils.getSource());
        try {
            runner.update(sql, sendid, revicesId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
