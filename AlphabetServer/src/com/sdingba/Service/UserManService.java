package com.sdingba.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by su on 16-6-21.
 */
public interface UserManService {
    Map<String, Object> UserIdFromUserMan(String username, String password);

    List<Map<String, Object>> UserManFormIDByFriendList(String username);
}
