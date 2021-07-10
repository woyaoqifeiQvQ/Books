package com.atguigu.test;

import com.atguigu.dao.UserDAO;
import com.atguigu.dao.impl.UserDAOImpl;
import com.atguigu.pojo.User;
import com.atguigu.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class UserDAOTest
{
    private UserDAO userDAO = new UserDAOImpl();

    @Test
    public void queryUserByUsername()
    {
        Connection connection = null;
        try
        {
            connection = JDBCUtils.getConnection();
            System.out.println(userDAO.queryUserByUsername("woyaoqifeQvQ"));
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        finally
        {
//            JDBCUtils.closeResource();
        }
    }

    @Test
    public void saveUser()
    {
        Connection connection = null;
        try
        {
            connection = JDBCUtils.getConnection();
            System.out.println(userDAO.saveUser( new User(2, "woyaoqifeiQvQ", "100101", "1033932518@qq.com")));
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        finally
        {
//            JDBCUtils.closeResource();
        }
    }

    @Test
    public void queryUserByUsernameAndPassword()
    {
        Connection connection = null;
        try
        {
            connection = JDBCUtils.getConnection();
            if(userDAO.queryUserByUsernameAndPassword("woyaoqifeiQvQ","1001011") == null)
            {
                System.out.println("用户名或者密码错误");
            }
            else
            {
                System.out.println("登录成功");
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        finally
        {
//            JDBCUtils.closeResource();
        }
    }
}