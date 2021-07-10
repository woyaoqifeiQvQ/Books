package com.atguigu.dao.impl;/**
    @author woyaoqifeQvQ
    
    @create 2021-07-01 20:26
*/

import com.atguigu.dao.OrderItemDAO;
import com.atguigu.pojo.OrderItem;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**

   @Description 
   @author woyaoqifeiQvQ
   @create 2021-07-01-20:26
*/
public class OrderItemDAOImpl extends BaseDAO<OrderItem> implements OrderItemDAO
{
    @Override
    public int saveOrderItem(OrderItem orderItem) throws SQLException
    {
        String sql = "insert into orderItem(name,count,price,totalPrice,orderId) values(?,?,?,?,?)";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }

    @Override
    public List<OrderItem> queryOrderItemByOrderId(String orderId) throws SQLException
    {
        String sql = "select name,count,price,totalPrice,orderId from orderItem where orderId = ?";
        return getList(sql,orderId);
    }
}
