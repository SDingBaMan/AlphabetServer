package com.sdingba.domain.daoBean;

import java.sql.Date;

/**
 * Created by su on 16-6-2.
 * <p>
 * 好友留言 表
 */
public class SendMessage extends daoDataAbs implements SendandReviceInterface{


    /**
     * SMId : auto
     */
    private int smId;

    private String reciveId;

    private String sendId;

    private String title;

    private String content;

    /**
     * tinyint 类型长度为 3
     */
    private int state;

    private Date datetime;


    public int getSmId() {
        return smId;
    }

    public void setSmId(int smId) {
        this.smId = smId;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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
    public String SQLTableId() {
        return "smId";
    }

    @Override
    public String sqlStringInsert() {
        StringBuffer sql = new StringBuffer();
        sql.append(":");
        sql.append(getReciveId() + ":");
        sql.append(getSendId() + ":");
        sql.append(getTitle() + ":");
        sql.append(getContent() + ":");
        sql.append(getState() + ":");
        sql.append(getDatetime() + ":");
        return sql.toString();
    }

    @Override
    public String toString() {
        return "SendMessageDao{" +
                "SMId=" + smId +
                ", ReciveId='" + reciveId + '\'' +
                ", SendId='" + sendId + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", state=" + state +
                ", datetime=" + datetime +
                '}';
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
