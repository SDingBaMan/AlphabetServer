package com.sdingba.Service.Impl;

import com.sdingba.Dao.UUIDSetDateDao;
import com.sdingba.Service.UUIDSetDateService;
import com.sdingba.domain.daoBean.UUIDSetDate;
import com.sdingba.factory.Factory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by su on 16-6-26.
 */
public class UUIDSetDateServiceImpl implements UUIDSetDateService {

    UUIDSetDateDao dao = Factory.getFactory().getInstance(UUIDSetDateDao.class);

    @Override
    public int InsertDataUUIDSetDate(String datastr, String Id, String setNum) {
        //6:6,6:6,6:6,6:12,6:12,7:12
        String str = datastr;
        int i = 1;
        List<UUIDSetDate> listSetData = new ArrayList<UUIDSetDate>();
        String[] stringDataList = str.split("\\,");
        for (String strObject : stringDataList) {
            UUIDSetDate uuidSetDate = new UUIDSetDate();
            String[] objectOne = strObject.split("\\:");

            uuidSetDate.setTimeCyc(objectOne[0]);
            uuidSetDate.setYanNumber(objectOne[1]);
            uuidSetDate.setSetId(Id);
            uuidSetDate.setSetNum(setNum);
            uuidSetDate.setTimeOrder(i++);

            listSetData.add(uuidSetDate);
        }
        int result = dao.InsertListUUIDSetData(listSetData);

        return result;
    }
}
