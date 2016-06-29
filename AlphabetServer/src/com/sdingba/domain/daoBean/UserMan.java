package com.sdingba.domain.daoBean;

/**
 * Created by su on 16-6-2.
 */
public class UserMan extends daoDataAbs {

    /**
     * 最重要的主键
     */
    private String umId;

    private String username;

    private String nickName;

    private String phone;

    private String mail;

    private String age;

    private int sex;

    /**
     * 激活
     */
    private int state;

    /**
     * 管理员
     */
    private int fifter;

    public String getUmId() {
        return umId;
    }

    public void setUmId(String umId) {
        this.umId = umId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getFifter() {
        return fifter;
    }

    public void setFifter(int fifter) {
        this.fifter = fifter;
    }

    @Override
    public String returnSQLTableListId() {
        return null;
    }

    @Override
    public String sqlStringInsert() {
        StringBuffer sql = new StringBuffer();
        sql.append(getUmId()+":");
        sql.append(getUsername()+":");
        sql.append(getNickName()+":");
        sql.append(getPhone()+":");
        sql.append(getMail()+":");
        sql.append(getAge()+":");
        sql.append(getSex()+":");
        sql.append(getState()+":");
        sql.append(getFifter());
        return sql.toString();
    }

    @Override
    public String SQLTableId() {
        return "umId";
    }


    /**
     * 测试 用；
     * @return
     */
    public String SQLTableSendIdToData(){
        return "username";
    }
}
