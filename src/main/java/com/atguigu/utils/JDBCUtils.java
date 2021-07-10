package com.atguigu.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.util.JdbcUtils;
import org.apache.commons.dbutils.DbUtils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**

   @Description druid数据库连接池技术
   @author woyaoqifeiQvQ
   @create 2021-06-02-21:29
*/
public abstract class JDBCUtils
{
    private static DataSource source;
    private static final ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    static
    {
        Properties prop = new Properties();
        InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");
//        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
        try
        {
            prop.load(is);
            source = DruidDataSourceFactory.createDataSource(prop);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException
    {
        Connection connection = threadLocal.get();
        if(connection == null)
        {
            connection = source.getConnection();
            connection.setAutoCommit(false);
            threadLocal.set(connection);
        }
        return connection;
    }

    public static void rollback()
    {
        Connection connection = threadLocal.get();
        if(connection != null)
        {
            try
            {
                connection.rollback();
            } catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }
        }
    }

    public static void commit()
    {
        Connection connection = threadLocal.get();
        if(connection != null)
        {
            try
            {
                connection.commit();
            } catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }
        }
    }

    public static void closeResource()
    {
        Connection connection = threadLocal.get();

        if(connection != null)
        {
            try
            {
                connection.setAutoCommit(true);
            } catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }
            DbUtils.closeQuietly(connection);
        }

        //  这里通过改connection holder is null 这个bug  对 Tomcat底层是线程池技术有一个小小的理解 详情请见笔记
        threadLocal.remove(); //我操了 服了
    }

    public static Connection getConn()
    {
        Connection connection = null;
        try
        {
            connection = source.getConnection();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return connection;
    }
}
