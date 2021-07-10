package com.atguigu.dao.impl;

import com.atguigu.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**

   @Description 
   @author woyaoqifeiQvQ
   @create 2021-06-03-13:22
*/
public abstract class BaseDAO<T>
{
    private Class<T> clazz;
    private QueryRunner queryRunner = new QueryRunner();

    //获取到父类的泛型
    {
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        Type[] types = paramType.getActualTypeArguments();
        clazz = (Class<T>) types[0];
    }

    //通用的增删改操作
    public int update(String sql, Object...args) throws SQLException
    {
        Connection connection = JDBCUtils.getConnection();
        int update = queryRunner.update(connection, sql, args);
        return update;
    }

    //通用的查询一行操作
    public T getInstance(String sql, Object...args) throws SQLException
    {
        Connection connection = JDBCUtils.getConnection();
        BeanHandler<T> handler = new BeanHandler<T>(clazz);
        T instance = queryRunner.query(connection, sql, handler, args);
        return instance;
    }

    //通用的查询返回多条记录
    public List<T> getList(String sql, Object...args) throws SQLException
    {
        Connection connection = JDBCUtils.getConnection();
        BeanListHandler<T> listHandler = new BeanListHandler<>(clazz);
        return queryRunner.query(connection, sql, listHandler, args);
    }

    //通用的返回单个值的查询
    public <E> E getValue(String sql, Object...args) throws SQLException
    {
        Connection connection = JDBCUtils.getConnection();
        ScalarHandler handler = new ScalarHandler();
        return (E) queryRunner.query(connection, sql, handler, args);
    }
}
