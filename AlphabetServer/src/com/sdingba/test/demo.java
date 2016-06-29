package com.sdingba.test;

import com.sdingba.Dao.SettingsDao;
import com.sdingba.Dao.UUIDSetDateDao;
import com.sdingba.Service.SettingsService;
import com.sdingba.domain.daoBean.Settings;
import com.sdingba.domain.daoBean.UUIDSetDate;
import com.sdingba.factory.Factory;
import com.sdingba.utils.TimeUtils;
import org.junit.Test;

import java.util.List;

/**
 * Created by su on 16-6-25.
 */
public class demo {
    public static void main(String[] args) {

    }

    /**
     *
     */
    @Test
    public void dddd() {
        SettingsDao dao = Factory.getFactory().getInstance(SettingsDao.class);
        Settings aa = dao.getLastTimeSetTimeSetNum("sdingba");
        String ss = dao.getMaxTimeTbale("sdingba").toString();
        System.out.println("     ====    "+ss);
        if (aa == null) {
            System.out.println("cccccc");
        }else{
            System.out.println("f");

            System.out.println(aa.getBeginDatetime().toString().replace("-",""));

        }
    }


    @Test
    public void xxxx(){
//        UUIDSetDateDao dao = Factory.getFactory().getInstance(UUIDSetDateDao.class);
////        List<UUIDSetDate> daolist = dao.getListClassUUIDSETDate("1", "sdingba");
//        dao.getMaxTimeTbale
//        System.out.println(daolist.toString());
//        //
//        SettingsService service = Factory.getFactory().getInstance(SettingsService.class);
//        service.getSchelloTable("sdingba");
        //

        String ss = TimeUtils.getEndDateTime("30");
        System.out.println(ss);
    }
}
