package com.sdingba.domain.daoBean;

/**
 * Created by su on 16-6-2.
 * 数据库  通过 抽象接口
 */

public abstract class daoDataAbs {

    /**
     * 以 字符串 形式 返回  字符串集合
     * 对 任意的ID返回 可以实现
     * @return
     */
    public abstract String returnSQLTableListId();


    /**
     * Insert 添加 对象数据。
     * SQL 语句。
     * 目的：主要用来存储到数据库的时候，给c3p0数据。
     * @return
     */
    public abstract String sqlStringInsert();

    /**
     * 用户的 ID 表名
     * @return
     */
    public abstract String SQLTableId();
}
