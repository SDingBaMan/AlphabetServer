package com.sdingba.Service.Impl;

import com.sdingba.Dao.SettingsDao;
import com.sdingba.Dao.UUIDSetDateDao;
import com.sdingba.Service.SettingsService;
import com.sdingba.domain.daoBean.Settings;
import com.sdingba.domain.daoBean.UUIDSetDate;
import com.sdingba.domain.javabean.setDataYan;
import com.sdingba.factory.Factory;
import com.sdingba.utils.TimeUtils;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by su on 16-6-25.
 */
public class SettingsServiceImpl implements SettingsService {

    SettingsDao daoU = Factory.getFactory().getInstance(SettingsDao.class);

    @Override
    public setDataYan getSchelloTable(String userId) {
        UUIDSetDateDao dao = Factory.getFactory().getInstance(UUIDSetDateDao.class);

        Settings setdata = daoU.getLastTimeSetTimeSetNum(userId);

        if (setdata != null) {
            StringBuffer result = new StringBuffer();
            Date startTime = setdata.getBeginDatetime();
            Date endTime = setdata.getEndDatetime();

            String startTimeStr = startTime.toString().replace("-", "");

            String endTimeStr = endTime.toString().replace("-", "");

            String MaxNumberset = setdata.getTimeSetNum();

            String newDayTime = TimeUtils.getNewDay();

            if (Integer.parseInt(newDayTime) > Integer.parseInt(endTimeStr)) {
                return null;
            }

            ////  16-6-25 根据MaxNumberSet的值去 UserSet表中获取数据。。
            List<UUIDSetDate> daolist = dao.getListClassUUIDSETDate(MaxNumberset, userId);

            for (UUIDSetDate uuid : daolist) {
                result.append(uuid.getTimeCyc() + ":" + uuid.getYanNumber() + ",");
            }
            int leng = result.length();
            result.delete(leng - 1, leng);
            System.out.println(result);

            setDataYan dataYan = new setDataYan();
            dataYan.setStartTime(startTimeStr);
            dataYan.setDataJiHua(result.toString());
//            SimpleDateFormat sdm = new SimpleDateFormat("yyyy-MM-dd");
//            sdm.format()

//            SimpleDateFormat sdm = new SimpleDateFormat("yyyyMMdd").parse();

            return dataYan;
        } else {
            return null;
        }

    }

    @Override
    public Settings getMaxTimeTbale(String userId) {
        Settings set = daoU.getLastTimeSetTimeSetNum(userId);
        return set;
    }

    @Override
    public String getEndTimeTbale(String userId) {



        return null;
    }

    @Override
    public int insertSetDataservice(Settings settings) {
        int a = daoU.InsertDataToDao(settings);
        return a;
    }
}
