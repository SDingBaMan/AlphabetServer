package com.sdingba.Service;

import com.sdingba.domain.daoBean.sendNumber;

import java.util.List;
import java.util.Map;

/**
 * Created by su on 16-7-23.
 */
public interface sendNumberService {

    /**
     * 返回今天 可以增加的 烟数
     * @param reviceId
     * @return
     */
    public String getsendNumberYan(String reviceId);


    public int setsendNumberYan(sendNumber sum);

}
