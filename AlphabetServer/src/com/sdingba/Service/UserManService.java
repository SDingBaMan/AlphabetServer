package com.sdingba.Service;

import com.sdingba.domain.daoBean.UserMan;

import java.util.List;
import java.util.Map;

/**
 * Created by su on 16-6-21.
 */
public interface UserManService {
    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    Map<String, Object> UserIdFromUserMan(String username, String password);

    /**
     * 好友
     * @param username
     * @return
     */
    List<Map<String, Object>> UserManFormIDByFriendList(String username);

    Map<String,Object> findUser(String name);
}
