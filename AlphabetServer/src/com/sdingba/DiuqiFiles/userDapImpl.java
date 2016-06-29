/*
package com.sdingba.Dao.Impl;

import com.sdingba.Dao.userDap;
import com.sdingba.domain.testdomain;
import com.sdingba.utils.DaoUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

*/
/**
 * Created by su on 16-6-1.
 *//*

public class userDapImpl extends baseDaoImpl implements userDap  {

    @Override
    public testdomain findCustById(String id) {
        String sql = "select * from aaa where aaa = ?";
        try{
            System.out.println("sssss");
            QueryRunner runner = new QueryRunner(DaoUtils.getSource());

            return runner.query(
                    sql,new BeanHandler<testdomain>(testdomain.class), id);

//            return runner.query(sql,
//                    new BeanHandler<testdomain>(testdomain.class), id);

        }catch (Exception e) {

            e.printStackTrace();
            throw new RuntimeException();
        }
//        RuntimeExceptioneturn null;
    }


}
*/
