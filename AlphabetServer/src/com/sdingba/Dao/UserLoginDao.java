package com.sdingba.Dao;

import com.sdingba.domain.daoBean.UserLogin;

/**
 * Created by su on 16-6-5.
 */
public interface UserLoginDao extends daobase<UserLogin>  {

    /**
     * 判断 密码 和 账号是否正确，如果正确返回数据UserMan，否则nul
     * @param zh
     * @param pass
     * @return
     */
    UserLogin findPassword(String zh, String pass);


}
