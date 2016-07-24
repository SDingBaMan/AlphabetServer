package com.sdingba.Service.Impl;

import com.sdingba.Dao.messageShareDao;
import com.sdingba.Service.messageShareService;
import com.sdingba.domain.daoBean.messageShare;
import com.sdingba.factory.Factory;
import com.sdingba.utils.DaoUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.util.List;
import java.util.Map;

/**
 * Created by su on 16-7-22.
 */
public class messageShareServiceImpl implements messageShareService {

    messageShareDao dao = Factory.getFactory().getInstance(messageShareDao.class);
    @Override
    public int InsertData(messageShare messageshare) {


        return dao.InsertDataToDao(messageshare);

    }

    @Override
    public List<Map<String, Object>> returnMessageShare() {
        List<Map<String, Object>> daos = dao.returnMessageShareMap();

        for (Map<String, Object> xx : daos) {
            java.sql.Date str = (java.sql.Date) xx.get("datetime");
            String datastr = str.toString();
            xx.put("datetime", datastr.replaceAll("-", ""));
        }

        return daos;
    }
}
