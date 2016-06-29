package com.sdingba.Dao;

import java.util.List;

/**
 * Created by su on 16-6-1.
 */
public interface daobase<T> {


    /**
     * 查询 ID 是否存在 该 对象
     * @param aa ID
     *
     * @return 返回 对象
     */
    T findTableById(String aa);


    /**
     * Insert 到数据库，全部属性；
     * @param domain
     * @return
     */
    int InsertDataToDao(T domain);


    /**
     * 通过id删除 对象
     * @param id ID
     * @return 删除 结果 成功码
     */
    int deleteDataById(String id);



    /**
     * 通过 SendId 获取 表数据集合
     * 该方法不是通用的了；
     * 只适合于，那些 有 sendId,和，ReciverId 属性的bean
     * @param
     * @return
     * （id,"xxx"）;
     */
    List<T> findListDataBySendId(String Sendid);


    /**
     * 通过 ReciverId 获取 表数据集合
     * 该方法不是通用的了；
     * 只适合于，那些 有 sendId,和，ReciverId 属性的bean
     * @param
     * @return
     * （id,"xxx"）;
     */
    List<T> findListDataByReciverId(String Recevierid);


    /**
     * 通过任意的 xxxid 属性
     * 查询返回lsit集合，
     * 注意： 查询的 id 必须 是 bean里面定义的数据表属性 returnSQLTableListId()。
     * 该方法也不是每一个都有的。
     * @param xxxid
     * @return
     */
    List<T> ListDataFromByBeanMyId(String xxxid);




///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////


    T finfUId(T aa);



//    T zzzz(T aa) throws IllegalAccessException, InstantiationException;



}
