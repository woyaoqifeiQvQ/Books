package com.atguigu.dao;

import com.atguigu.pojo.Order;
import com.atguigu.pojo.Status;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author woyaoqifeQvQ
 * @create 2021-07-01 19:44
 */
public interface OrderDAO
{
    int saveOrder(Order order) throws SQLException;

    List<Order> queryOrders() throws SQLException;

    void changeOrderStatus(String orderId, String status) throws SQLException;

    List<Order> queryOrdersByUser(Integer userId) throws SQLException;
}
