package com.sdingba.domain.daoBean;

import java.sql.Date;

/**
 * Created by su on 16-6-2.
 *
 * 发送 好友消息 表
 *
 */
public class Sendqq extends daoDataAbs implements  SendandReviceInterface{

    /**
     * SQId 是 auto
     */
    private int sqId;

    private String reciveId;

    private String sendId;

    private String title;

    private Date datetime;

    public int getReadIs() {
        return readIs;
    }

    public void setReadIs(int readIs) {
        this.readIs = readIs;
    }

    private int readIs;


    public int getSqId() {
        return sqId;
    }

    public void setSqId(int sqId) {
        this.sqId = sqId;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        sql.append(getReciveId() + ":");
        sql.append(getSendId() + ":");
        sql.append(getTitle() + ":");
        sql.append(getDatetime() + ":");
        sql.append(getReadIs() + ":");
        return sql.toString();
    }

    @Override
    public String SQLTableId() {
        return "sqId";
    }


    @Override
    public String SQLTableRecevierIdToData() {
        return "reciveId";
    }

    @Override
    public String SQLTableSendIdToData() {
        return "sendId";
    }
}
