package com.sdingba.Service;

import com.sdingba.domain.daoBean.Settings;
import com.sdingba.domain.javabean.setDataYan;

/**
 * Created by su on 16-6-25.
 */
public interface SettingsService {

    /**
     * 根据 userId 返回是否 有计划表
     * @param userId
     * @return
     */
    public setDataYan getSchelloTable(String userId);


    /**
     * 获取 最大 那条 getMaxTimeTbale 的数据
     * @param userId
     * @return
     */
    public Settings getMaxTimeTbale(String userId);

    public String getEndTimeTbale(String userId);

    public int insertSetDataservice(Settings settings);


}
