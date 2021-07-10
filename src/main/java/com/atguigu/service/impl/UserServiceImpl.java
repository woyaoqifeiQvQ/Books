package com.atguigu.service.impl;

import com.atguigu.dao.UserDAO;
import com.atguigu.dao.impl.UserDAOImpl;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;

import java.sql.Connection;
import java.sql.SQLException;

/**

   @Description 
   @author woyaoqifeiQvQ
   @create 2021-06-03-14:55
*/
public class UserServiceImpl implements UserService
{
    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public void registerUser(User user) throws SQLException
    {
        userDAO.saveUser(user);
    }

    @Override
    public User loginUser(User user) throws SQLException
    {
        return userDAO.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUser(String username) throws SQLException
    {
        return userDAO.queryUserByUsername(username) != null;
    }
}
