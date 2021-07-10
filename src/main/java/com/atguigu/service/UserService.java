package com.atguigu.service;

import com.atguigu.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserService
{
    //用户注册
    void registerUser(User user) throws SQLException;

    //用户登录
    User loginUser(User user) throws SQLException;

    //用户是否存在
    boolean existsUser(String username) throws SQLException;
}
