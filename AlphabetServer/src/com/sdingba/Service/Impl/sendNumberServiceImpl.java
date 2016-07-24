package com.sdingba.Service.Impl;

import com.sdingba.Dao.sendNumberDao;
import com.sdingba.Service.sendNumberService;
import com.sdingba.domain.daoBean.sendNumber;
import com.sdingba.factory.Factory;
import com.sdingba.utils.TimeUtils;

/**
 * Created by su on 16-7-23.
 */
public class sendNumberServiceImpl implements sendNumberService {
    sendNumberDao dao = Factory.getFactory().getInstance(sendNumberDao.class);

    @Override
    public String getsendNumberYan(String reviceId) {
        //   reciveId
        java.sql.Date time = TimeUtils.getesqlNewDayF();
        sendNumber number = dao.getSendNumberYan(reviceId,time);

        System.out.println(number);

        System.out.println(number.getUumber());

        if (number.getUumber() > 4) {
            return "3";
        }
        return number.getUumber()+"";

//        return number.getUumber();
    }

    @Override
    public int setsendNumberYan(sendNumber sum) {

        return dao.InsertDataToDao(sum);

    }
}
