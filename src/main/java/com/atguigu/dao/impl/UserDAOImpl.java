package com.atguigu.dao.impl;

import com.atguigu.dao.UserDAO;
import com.atguigu.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;

/**

   @Description 
   @author woyaoqifeiQvQ
   @create 2021-06-03-14:22
*/
public class UserDAOImpl extends BaseDAO<User> implements UserDAO
{

    @Override
    public User queryUserByUsername(String username) throws SQLException
    {
        String sql = "select id,username,`password`,email from user where username = ?";
        return getInstance(sql,username);
    }

    @Override
    public int saveUser(User user) throws SQLException
    {
        String sql = "insert into user (username,`password`,email)values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) throws SQLException
    {
        String sql = "select id,username,`password`,email from user where username = ? and `password` = ?";
        return getInstance(sql,username,password);
    }
}
