package com.atguigu.service;

import com.atguigu.pojo.OrderItem;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author woyaoqifeQvQ
 * @create 2021-07-03 22:55
 */
public interface OrderItemService
{
    List<OrderItem> showOrderDetail(String orderId) throws SQLException;
}
