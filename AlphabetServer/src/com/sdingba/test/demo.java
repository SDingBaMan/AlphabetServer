package com.sdingba.test;

import com.sdingba.Dao.SettingsDao;
import com.sdingba.Dao.UUIDSetDateDao;
import com.sdingba.Dao.UserDataDao;
import com.sdingba.Dao.UserManDao;
import com.sdingba.Service.SettingsService;
import com.sdingba.domain.daoBean.Settings;
import com.sdingba.domain.daoBean.UUIDSetDate;
import com.sdingba.domain.daoBean.UserMan;
import com.sdingba.domain.javabean.avgUserData;
import com.sdingba.factory.Factory;
import com.sdingba.utils.MD5Utils;
import com.sdingba.utils.TimeUtils;
import jdk.management.resource.ResourceType;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by su on 16-6-25.
 */
public class demo {
    public static void main(String[] args) {
//      UserManDao fao = Factory.getFactory().getInstance(UserManDao.class);
//
//      System.out.println(fao.UserIdFromUserMan(""));
        System.out.println(MD5Utils.md5("123456"));
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

    @Test
    public void vvv() {
        UserDataDao dao = Factory.getFactory().getInstance(UserDataDao.class);
//        Map aa = dao.avgForUserIdUserData("sdingba");
//        avgUserData bbb = dao.avgForUserIdUserDataObject("sdingba");
//
//        if (bbb == null) {
//            System.out.println("xxx");
//        } else {
//            System.out.println("vvvv");
//        }

//        System.out.println(aa.get("avg(surplusNumber)"));
//        if (aa == null) {
//            System.out.println("dddd");
//        }else{
//            System.out.println("dddddd");
//        }




    }
}
