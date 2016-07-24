package com.sdingba.Dao;

import com.sdingba.domain.daoBean.UserData;
import com.sdingba.domain.javabean.avgUserData;

import java.util.List;
import java.util.Map;

/**
 * Created by su on 16-6-5.
 */
public interface UserDataDao extends daobase<UserData> {

    /**
     * 获取最后一天的数据
     *
     * @param userId
     * @return
     */
    public UserData findByLastTime(String userId);


    /**
     *
     * *******************
     *  常用 函数
     *  limit 时间 查询
     * *******************
     *
     *  @param userId
     *  @param timeNum 返回 数量 的 时间
     *  @return
     *
     */
    public List<Map<String,Object>> findByLimitTime(String userId, int timeNum);


    /**
     * 返回某用户的平均值
     * map形式返回，不推荐使用
     * get("avg(surplusNumber)");使用
     *
     * @param userId
     * @return
     */
    public Map<String, Object> avgForUserIdUserData(String userId);


    /**
     * 返回某用户的平均值
     *
     * @param userId
     * @return
     */
    public avgUserData avgForUserIdUserDataObject(String userId);


    /**
     * 返回全部数据的 平均值
     *
     * @return
     */
    public avgUserData avgForAllUserDataObject();


    public List<UserData> findUserIdREsultList(String userId);
}
