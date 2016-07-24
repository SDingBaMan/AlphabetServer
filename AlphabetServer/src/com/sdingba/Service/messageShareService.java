package com.sdingba.Service;

import com.sdingba.domain.daoBean.messageShare;

import java.util.List;
import java.util.Map;

/**
 * Created by su on 16-7-22.
 */
public interface messageShareService {
    public int InsertData(messageShare messageshare);

    public List<Map<String,Object>> returnMessageShare();

}
