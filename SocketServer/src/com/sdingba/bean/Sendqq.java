package com.sdingba.bean;

import java.sql.Date;

/**
 * Created by su on 16-6-2.
 *
 * 发送 好友消息 表
 *
 */
public class Sendqq {

    /**
     * SQId 是 auto
     */
    private int SQId;

    private String ReciveId;

    private String SendId;

    private String title;

    private Date datetime;

    private int readIs;

    public int getReadIs() {
        return readIs;
    }

    public void setReadIs(int readIs) {
        this.readIs = readIs;
    }




    public int getSQId() {
        return SQId;
    }

    public void setSQId(int SQId) {
        this.SQId = SQId;
    }

    public String getReciveId() {
        return ReciveId;
    }

    public void setReciveId(String reciveId) {
        ReciveId = reciveId;
    }

    public String getSendId() {
        return SendId;
    }

    public void setSendId(String sendId) {
        SendId = sendId;
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
    
}
