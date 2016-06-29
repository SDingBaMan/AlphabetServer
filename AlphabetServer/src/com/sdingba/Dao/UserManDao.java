package com.sdingba.Dao;

import com.sdingba.domain.daoBean.UserMan;

import java.util.List;
import java.util.Map;


/**
 * Created by su on 16-6-2.
 */
public interface UserManDao extends daobase<UserMan> {

    Map<String,Object> UserIdFromUserMan(String username);


    //下面2个效果一样。
    List<Map<String, Object>> returnFriendList(String username);

    List<UserMan> returnFriendListUserManDao(String username);

}
