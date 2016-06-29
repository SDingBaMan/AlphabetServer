/*
package com.sdingba.Dao.Impl;

import com.sdingba.Dao.baseDao;
import com.sdingba.domain.testdomain;
import com.sdingba.utils.DaoUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

*/
/**
 * Created by su on 16-6-1.
 *//*

public class baseDaoImpl<T> implements baseDao {

    public <T> T findClassByID(Class<T> clazz, String table, String id) {

        QueryRunner runner = new QueryRunner(DaoUtils.getSource());
        System.out.println(clazz.getSimpleName()+"xxx");
        String sql = "select * from " + table + " where aaa = ?";
        try {

            return runner.query(sql,
                    new BeanHandler<T>((Class<T>) clazz), id);

        } catch (Exception e) {

            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
*/
