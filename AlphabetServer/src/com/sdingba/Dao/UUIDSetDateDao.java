package com.sdingba.Dao;

import com.sdingba.domain.daoBean.UUIDSetDate;

import java.util.List;

/**
 * Created by su on 16-6-5.
 */
public interface UUIDSetDateDao extends daobase<UUIDSetDate> {

    /**
     * 根据 设置的次数 获取list集合
     *
     * @param setNum
     * @return
     */
    public List<UUIDSetDate> getListClassUUIDSETDate(String setNum, String userId);

    public int InsertListUUIDSetData(List<UUIDSetDate> uuidSetDates);

}
