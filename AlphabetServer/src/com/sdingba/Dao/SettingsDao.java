package com.sdingba.Dao;

import com.sdingba.domain.daoBean.Settings;

/**
 * Created by su on 16-6-5.
 */
public interface SettingsDao extends daobase<Settings> {

    /**
     * 根据userId查询，返回 是否 有 这 个  类
     * @param userId
     * @return
     */
    public Settings getLastTimeSetTimeSetNum(String userId);


    /**
     * 获取 最后一次的 是第几次的设置
     * @param userId
     * @return
     */
    public String getMaxTimeTbale(String userId);
}
