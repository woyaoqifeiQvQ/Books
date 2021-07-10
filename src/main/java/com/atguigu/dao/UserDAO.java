package com.atguigu.dao;

import com.atguigu.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserDAO
{
    /**
     * 根据用户名查询一条数据
     * @param username
     * @return 返回null 则表示用户名可用 反之，则用户名已重复
     * @throws SQLException
     */
    User queryUserByUsername(String username) throws SQLException;

    /**
     * 将一条数据保存到数据库中
     * @param user
     * @return 返回0则操作失败 其余则是操作成功的数据条数
     * @throws SQLException
     */
    int saveUser(User user) throws SQLException;

    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return 返回null则用户名或者密码错误
     * @throws SQLException
     */
    User queryUserByUsernameAndPassword(String username, String password) throws SQLException;

}
