package com.sdingba.Service;

import com.sdingba.domain.daoBean.UserData;
import com.sdingba.domain.javabean.avgUserData;

import java.util.List;
import java.util.Map;

/**
 * Created by su on 16-6-24.
 */
public interface UserDataService {
    /**
     * 增加 用户 的 一条数据
     * @param userData
     * @return
     */
    public String CurdUserDataDay(UserData userData);


    /**
     *  更具时间获取数据
     * *******************
     *  常用 函数
     *  limit 时间 查询  返回最后 时间 的数据
     * *******************
     *
     *  @param userId
     *  @param timeNum 返回 数量 的 时间
     *  @return
     *
     */
    public List<Map<String,Object>> resultDataForTime(String userId, int timeNum);

    /**
     * 返回某用户的平均值( 所有时间 )
     *
     * @param userId
     * @return
     */
    public avgUserData avgForUserIdUserDataObject(String userId);


    /**
     * 返回全部数据的 平均值(所有用户，所有时间)
     *
     * @return
     */
    public avgUserData avgForAllUserDataObject();

    public String maxAllXiyan(String userId);


}
