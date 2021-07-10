package com.atguigu.service;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;

import java.sql.SQLException;
import java.util.List;

/**
 * @author woyaoqifeQvQ
 * @create 2021-07-01 17:11
 */
public interface OrderService
{
    String createOrder(Cart cart, Integer userId) throws Exception;

    List<Order> showAllOrders() throws SQLException;

    void sendOrder(String orderId) throws SQLException;

    List<OrderItem> showOrderDetail(String orderId) throws SQLException;

    List<Order> showMyOrders(Integer userId) throws SQLException;

    void receiverOrder(String orderId) throws SQLException;
}
