package com.atguigu.test;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class UserServiceImplTest
{
//    private UserService userService = new UserServiceImpl();
//    private static Connection connection;
//    static
//    {
//        try
//        {
//            connection = JDBCUtils.getConnection();
//        }
//        catch (SQLException throwables)
//        {
//            throwables.printStackTrace();
//        }
//    }
//    @Test
//    public void registerUser()
//    {
//        try
//        {
//            userService.registerUser(connection,new User(null,"a1033932518","qianyishi","qwe123@qq.com"));
//        } catch (SQLException throwables)
//        {
//            throwables.printStackTrace();
//        }
//        finally
//        {
//            JDBCUtils.closeResource(connection);
//        }
//    }
//
//    @Test
//    public void loginUser()
//    {
//        try
//        {
//            User user = userService.loginUser(connection, new User(null, "a103393251", "qianyishi", null));
//            if(user == null)
//            {
//                System.out.println("用户名或者密码错误");
//            }
//            else
//            {
//                System.out.println("登录成功");
//            }
//        }
//        catch (SQLException throwables)
//        {
//            throwables.printStackTrace();
//        }
//        finally
//        {
//            JDBCUtils.closeResource(connection);
//        }
//    }
//
//    @Test
//    public void existsUser()
//    {
//        try
//        {
//            if(userService.existsUser(connection, "a1033932518"))
//            {
//                System.out.println("用户名已存在");
//            }
//            else
//            {
//                System.out.println("用户名可以使用");
//            }
//        } catch (SQLException throwables)
//        {
//            throwables.printStackTrace();
//        }
//        finally
//        {
//            JDBCUtils.closeResource(connection);
//        }
//    }
}