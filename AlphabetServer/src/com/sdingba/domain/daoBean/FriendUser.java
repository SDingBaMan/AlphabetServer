package com.sdingba.domain.daoBean;

/**
 * Created by su on 16-6-2.
 */
public class FriendUser extends daoDataAbs implements SendandReviceInterface{

    /**
     * FId ： 自增长；不需要理会；
     */
    private int fid;

    private String userId;

    private String friendId;


    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }

    @Override
    public String returnSQLTableListId() {



        return null;
    }

    @Override
    public String sqlStringInsert() {
        StringBuffer sql = new StringBuffer();
        sql.append(":");
        sql.append(getUserId()+":");
        sql.append(getFriendId()+":");
        return sql.toString();
    }

    @Override
    public String SQLTableId() {
        return "fid";
    }



    @Override
    public String SQLTableRecevierIdToData() {
        return "userId";
    }

    @Override
    public String SQLTableSendIdToData() {
        return "friendId";
    }
}
