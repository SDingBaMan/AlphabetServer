package com.sdingba.domain.daoBean;

import java.sql.Date;

/**
 * Created by su on 16-7-23.
 */
public class sendNumber extends daoDataAbs{

    private String snId;

    private String reciveId;
    private String sendId;
    private int uumber;
    private Date datetime;

    public String getSnId() {
        return snId;
    }

    public void setSnId(String snId) {
        this.snId = snId;
    }

    public String getReciveId() {
        return reciveId;
    }

    public void setReciveId(String reciveId) {
        this.reciveId = reciveId;
    }

    public String getSendId() {
        return sendId;
    }

    public void setSendId(String sendId) {
        this.sendId = sendId;
    }

    public int getUumber() {
        return uumber;
    }

    public void setUumber(int uumber) {
        this.uumber = uumber;
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

        sql.append(getReciveId()+":");
        sql.append(getSendId()+":");
        sql.append(getUumber()+":");
        sql.append(getDatetime()+":");
        return sql.toString();
    }

    @Override
    public String SQLTableId() {
        return "snId";
    }
}
