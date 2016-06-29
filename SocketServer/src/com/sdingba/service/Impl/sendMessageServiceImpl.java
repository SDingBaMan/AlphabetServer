package com.sdingba.service.Impl;

import com.sdingba.bean.Sendqq;
import com.sdingba.dao.sendMessageDao;
import com.sdingba.factory.Factory;
import com.sdingba.service.sendMessageService;

import java.util.List;

/**
 * Created by su on 16-6-7.
 */
public class sendMessageServiceImpl implements sendMessageService {


    @Override
    public String MessageHistoryString(String sendid, String revicesId) {
        sendMessageDao dao = Factory.getFactory().getInstance(sendMessageDao.class);
        List<Sendqq> aa = dao.MessageHistory(sendid,revicesId,1);

        StringBuffer str = new StringBuffer();
        for (Sendqq send : aa) {
            //id:message;====> send:message;send:message;
            str.append(send.getSendId()).append(":").append(send.getTitle()).append(";");
        }

        dao.updateMEssageRW(sendid,revicesId);
        int strLong = str.length();
        if (strLong == 0) {
            return "";
        }

        return str.delete(strLong - 1, strLong).toString();
    }

    @Override
    public void addMessageSendqq(String sendId, String RevicesId, String message) {
        sendMessageDao dao = Factory.getFactory().getInstance(sendMessageDao.class);
        dao.addMessageSendqq(sendId,RevicesId,message);
    }
}
