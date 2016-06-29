package com.sdingba.domain.daoBean;

import java.sql.Date;

/**
 * Created by su on 16-6-2.
 * <p>
 * 分享 的
 */
public class messageShare extends daoDataAbs {

    /**
     * auto
     */
    private int msId;

    private String userId;

    private String title;

    private String content;

    private Date datetime;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getMsId() {
        return msId;
    }

    public void setMsId(int msId) {
        this.msId = msId;
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
        sql.append(getTitle() + ":");
        sql.append(getContent() + ":");
        sql.append(getDatetime() + ":");
        return sql.toString();
    }

    @Override
    public String SQLTableId() {
        return "msId";
    }
}
