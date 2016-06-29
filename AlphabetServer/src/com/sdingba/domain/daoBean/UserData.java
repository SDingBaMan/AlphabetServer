package com.sdingba.domain.daoBean;

import java.sql.Date;

/**
 * Created by su on 16-6-2.
 */
public class UserData extends daoDataAbs {

    /**
     * auto
     */
    private int udId;

    private String userId;

    /**
     * 可以吸烟次数
     */
    private int dataNumber;

    /**
     * 剩余
     */
    private int surplusNumber;

    private Date datetime;


    public int getUdId() {
        return udId;
    }

    public void setUdId(int udId) {
        this.udId = udId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getDataNumber() {
        return dataNumber;
    }

    public void setDataNumber(int dataNumber) {
        this.dataNumber = dataNumber;
    }

    public int getSurplusNumber() {
        return surplusNumber;
    }

    public void setSurplusNumber(int surplusNumber) {
        this.surplusNumber = surplusNumber;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }


    @Override
    public String returnSQLTableListId() {


        return null;
    }

    @Override
    public String sqlStringInsert() {
        StringBuffer sql = new StringBuffer();
        sql.append(":");
        sql.append(getUserId() + ":");
        sql.append(getDataNumber() + ":");
        sql.append(getSurplusNumber() + ":");
        sql.append(getDatetime());
        return sql.toString();
    }

    @Override
    public String SQLTableId() {
        return "udId";
    }
}
