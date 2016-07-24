package com.sdingba.Dao;

import com.sdingba.domain.daoBean.SendMessage;
import com.sdingba.domain.daoBean.sendNumber;

/**
 * Created by su on 16-7-23.
 */
public interface sendNumberDao extends daobase<sendNumber> {

    sendNumber getSendNumberYan(String reviceId, java.sql.Date time);


}
