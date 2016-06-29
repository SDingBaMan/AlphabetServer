package com.sdingba.domain.daoBean;

/**
 * Created by su on 16-6-2.
 */
public class UUIDSetDate extends daoDataAbs {


    /**
     *  UUIDId 是 auto
     */
    private int uuIDId;

    /**
     *  外键，指向 Settings的SId
     */
    private String setId;

    /**
     *  设置的次数。对应 settings（SetNum）;
     */
    private String setNum;

    /**
     *  次数 下 的时间；；所有的TimeCyc和 等于 SettingsDao(TimeNum);
     */
    private String timeCyc;

    /**
     *  吸烟 设置 的 顺序
     */
    private int timeOrder;

    /**
     *  设置吸烟次数(每天 根数)
     */
    private String yanNumber;


    public int getUuIDId() {
        return uuIDId;
    }

    public void setUuIDId(int uuIDId) {
        this.uuIDId = uuIDId;
    }

    public String getSetId() {

        return setId;
    }

    public void setSetId(String setId) {
        this.setId = setId;
    }

    public String getSetNum() {
        return setNum;
    }

    public void setSetNum(String setNum) {
        this.setNum = setNum;
    }

    public String getTimeCyc() {
        return timeCyc;
    }

    public void setTimeCyc(String timeCyc) {
        this.timeCyc = timeCyc;
    }

    public int getTimeOrder() {
        return timeOrder;
    }

    public void setTimeOrder(int timeOrder) {
        this.timeOrder = timeOrder;
    }

    public String getYanNumber() {
        return yanNumber;
    }

    public void setYanNumber(String yanNumber) {
        this.yanNumber = yanNumber;
    }

    @Override
    public String returnSQLTableListId() {

        return null;
    }

    @Override
    public String sqlStringInsert() {
        StringBuffer sql = new StringBuffer();
        sql.append(":");
        sql.append(getSetId()+":");
        sql.append(getSetNum()+":");
        sql.append(getTimeCyc()+":");
        sql.append(getTimeOrder()+":");
        sql.append(getYanNumber()+":");
        return sql.toString();
    }

    @Override
    public String SQLTableId() {
        return "uuIDId";
    }
}
