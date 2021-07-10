package com.atguigu.dao;

import com.atguigu.pojo.OrderItem;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author woyaoqifeQvQ
 * @create 2021-07-01 19:45
 */
public interface OrderItemDAO
{
    int saveOrderItem(OrderItem orderItem) throws SQLException;

    List<OrderItem> queryOrderItemByOrderId(String orderId)throws SQLException;
}
