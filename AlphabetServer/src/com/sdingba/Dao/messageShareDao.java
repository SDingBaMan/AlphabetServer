package com.sdingba.Dao;

import com.sdingba.domain.daoBean.messageShare;

import java.util.List;
import java.util.Map;

/**
 * Created by su on 16-6-5.
 */
public interface messageShareDao extends daobase<messageShare>  {
    List<Map<String, Object>> returnMessageShareMap();
}
