package com.sdingba.domain.daoBean;

/**
 * Created by su on 16-6-2.
 */
public class UserLogin extends daoDataAbs {

    private String ulId;

    private String ulpassword;

    public String getUlId() {
        return ulId;
    }

    public void setUlId(String ulId) {
        this.ulId = ulId;
    }

    public String getUlpassword() {
        return ulpassword;
    }

    public void setUlpassword(String ulpassword) {
        this.ulpassword = ulpassword;
    }

    @Override
    public String returnSQLTableListId() {



        return null;
    }

    @Override
    public String sqlStringInsert() {
        StringBuffer sql = new StringBuffer();
        sql.append(getUlId() + ":");
        sql.append(getUlpassword() + ":");
        return sql.toString();
    }


    @Override
    public String SQLTableId() {
        return "ulId";
    }
}
