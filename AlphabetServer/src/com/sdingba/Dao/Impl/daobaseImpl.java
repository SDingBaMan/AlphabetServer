package com.sdingba.Dao.Impl;

import com.sdingba.Dao.daobase;
import com.sdingba.domain.testdomain;
import com.sdingba.utils.DaoUtils;
import com.sun.xml.internal.bind.v2.TODO;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.After;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by su on 16-6-1.
 */
public class daobaseImpl<T> implements daobase<T> {
    QueryRunner runner = new QueryRunner(DaoUtils
            .getSource());

    /**
     * 传进来的 对象 实例
     */
    protected Class<T> clazz = null; // 这是一个问题！!!!!

    /**
     * 传进来的  表 名（数据库 表名）
     */
    private String clazzDaoName;

    daobaseImpl() {

        // 通过反射获取T的真是类型
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.clazz = (Class<T>) pt.getActualTypeArguments()[0];

        clazzDaoName = clazz.getSimpleName();

        System.out.println("---> clazz = " + clazz);
    }

    @Override
    public T findTableById(String Id) {
        QueryRunner runner = new QueryRunner(DaoUtils.getSource());
        String sql = "select * from " + clazzDaoName + " where TableId = ?";
        try {
            sql = getTableSQL(sql);
            System.out.println(sql);
            return runner.query(sql,
                    new BeanHandler<T>(clazz), Id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }


    //
    @Override
    public int InsertDataToDao(T domain) {
        QueryRunner runner = new QueryRunner(DaoUtils.getSource());
        try {

            Method method = clazz.getDeclaredMethod("sqlStringInsert");
//            T a = (T) clazz;
            String dataString = (String) method.invoke(domain);

            Object[] params = PullMaohaoDatatoString(dataString);// TODO: 16-6-1  对集合进行 组装；
            int sqlParmer = params.length;
            String sql = SqlStringInsertMethod(sqlParmer);
            return runner.update(sql, params);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public int deleteDataById(String id) {
        QueryRunner runner = new QueryRunner(DaoUtils.getSource());
        String sql = "delete from " + clazzDaoName + " where TableId = ?";
        try {
            sql = getTableSQL(sql);
            return runner.update(sql,id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public List<T> findListDataBySendId(String Sendid) {
        QueryRunner runner = new QueryRunner(DaoUtils.getSource());
        String sql = "select * from "+clazzDaoName+" where TableSendId = ?";
        try {

            Method method =  clazz.getDeclaredMethod("SQLTableSendIdToData");

            String sqlString = (String) method.invoke(clazz.newInstance());
            sql = sql.replace("TableSendId", sqlString);
            return runner.query(sql, new BeanListHandler<T>(clazz), Sendid);
        } catch (NoSuchMethodException ee) {
            System.out.println("没找到函数-->该方法里面 没有 send或者 recever的属性");
            System.out.println("-------查看是否 添加 这个方法，在bean类里面");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    @Override
    public List<T> findListDataByReciverId(String Recevierid) {
        QueryRunner runner = new QueryRunner(DaoUtils.getSource());
        String sql = "select * from "+clazzDaoName+" where TableRecevier = ?";
        try {
            Method method =  clazz.getDeclaredMethod("SQLTableRecevierIdToData");
            String sqlString = (String) method.invoke(clazz.newInstance());
            sql = sql.replace("TableRecevier", sqlString);
            return runner.query(sql, new BeanListHandler<T>(clazz), Recevierid);
        } catch (NoSuchMethodException ee) {
            System.out.println("没找到函数-->该方法里面 没有 send或者 recever的属性");
            System.out.println("-------查看是否 添加 这个方法，在bean类里面");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public List<T> ListDataFromByBeanMyId(String xxxid) {
        QueryRunner runner = new QueryRunner(DaoUtils.getSource());
        String sql = "select * from "+clazzDaoName+" where xxxId = ?";
        try {
            Method method =  clazz.getDeclaredMethod("returnSQLTableListId");

            String sqlString = (String) method.invoke(clazz.newInstance());
            if (sqlString == null) {
                return null;
            }
            sql = sql.replace("xxxId", sqlString);
            return runner.query(sql, new BeanListHandler<T>(clazz), xxxid);
        } catch (NoSuchMethodException ee) {
            System.out.println("没找到函数-->该方法里面 没有returnSQLTableListId的方法");
            System.out.println("-------查看是否 添加 这个方法，在bean类里面");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////

    /**
     * 生成 Insert （所有属性的） sql string
     *
     * @param sqlParmer --》 参数的个数
     * @return
     */
    private String SqlStringInsertMethod(int sqlParmer) {
        StringBuffer sqlstring = new StringBuffer("insert into tableMysql values(");
        for (int i = 0; i < sqlParmer; i++) {
            sqlstring = i == sqlParmer - 1 ? sqlstring.append("?)") : sqlstring.append("?,");
        }
        return sqlstring.toString().replace("tableMysql", clazzDaoName);
//        return  sqlstring.toString().replace("tableMysql","aaa");
    }

    /**
     * 解析 ： 的字符串生成  Object[]
     *
     * @param dataString
     * @return Object[]
     */
    private Object[] PullMaohaoDatatoString(String dataString) {
        String[] stringNum = dataString.split("\\:");
        int dataStringNum = stringNum.length;
        Object[] parmer = new Object[dataStringNum];
        for (int i = 0; i < dataStringNum; i++) {
            //TODO  java.lang.NullPointerException
            if (stringNum[0].equals("") && i == 0) {
                parmer[i] = null;
                System.out.println("xxxx");
            } else {
                parmer[i] = stringNum[i];
            }
        }
        return parmer;
    }


    /**
     * 置换 sql 语句的 ID 名称
     *
     * @return 处理好的 sql 语句
     */
    private String getTableSQL(String sql) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Method method = clazz.getDeclaredMethod("SQLTableId");
        String sqlString =  (String) method.invoke(clazz.newInstance());
        String sqlok = sql.replace("TableId", sqlString);
        return sqlok;
    }






    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////





    @Override
    public T finfUId(T aa) {  //testdomain
        QueryRunner runner = new QueryRunner(DaoUtils.getSource());
//        System.out.println(clazz.getSimpleName()+"xxx");
        String sql = "insert into aaa values(?)";

        try {
            Class c = aa.getClass();
//            Method[] bb = c.getDeclaredMethods();
            Method method = c.getDeclaredMethod("toString");

//            for (Method method : bb) {
//                System.out.println(method.getName());
//                method.invoke(aa, null);
//                if (method.getName().contains("toString")) {
            System.out.println(method.getName());
//////                    StringBuilder aaa = new StringBuilder(method.getName());
//////                    System.out.println(aaa.replace(0, 3, "set").toString());
            System.out.println(method.invoke(aa));
//                }
//            }
            //// TODO: 16-6-1  这儿是一个问题，不能 直接保存对象。
//
//                Class c = aa.getClass();
////                (testdomain)c.getName();
//                System.out.println("xxxx");
//
//                Method method = c.getMethod("getAaa", null);
//                Integer s = (Integer) method.invoke(aa, null);
//                System.out.println(s);
            Object[] params = {1333};
            runner.update(sql, params);

            return null;
        } catch (Exception e) {

            e.printStackTrace();
            throw new RuntimeException();
        }
//        System.out.println(aa.hashCode());

//        return null;
    }


}
