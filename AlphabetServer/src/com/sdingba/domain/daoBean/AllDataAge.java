package com.sdingba.domain.daoBean;

import java.lang.reflect.Field;

/**
 * Created by su on 16-6-2.
 *
 * 月 平均 数据
 */
public class AllDataAge extends daoDataAbs {

    /**
     * auto
     */
    private int adId;

    private String mouth;

//    private String Day;

    private String surplusNumber;


    public int getAdId() {
        return adId;
    }

    public void setAdId(int adId) {
        this.adId = adId;
    }

    public String getMouth() {
        return mouth;
    }

    public void setMouth(String mouth) {
        this.mouth = mouth;
    }

    public String getSurplusNumber() {
        return surplusNumber;
    }

    public void setSurplusNumber(String surplusNumber) {
        this.surplusNumber = surplusNumber;
    }

    @Override
    public String returnSQLTableListId() {

        return null;
    }


    @Override
    public String SQLTableId() {
        return "adId";
    }


    @Override
    public String sqlStringInsert() {
        StringBuffer sql = new StringBuffer();
        sql.append(":");
        sql.append(getMouth()+":");
        sql.append(getSurplusNumber()+":");
        return sql.toString();
    }
}
