package com.atguigu.dao.impl;/**
    @author woyaoqifeQvQ
    
    @create 2021-07-01 19:55
*/

import com.atguigu.dao.OrderDAO;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.Status;
import com.atguigu.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**

   @Description 
   @author woyaoqifeiQvQ
   @create 2021-07-01-19:55
*/
public class OrderDAOImpl extends BaseDAO<Order> implements OrderDAO
{
    @Override
    public int saveOrder(Order order) throws SQLException
    {
        String sql = "insert into `order` values(?,?,?,?,?)";
        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),"Undelivered",order.getUserId());
    }

    @Override
    public List<Order> queryOrders() throws SQLException
    {
        String sql = "select createTime,price,status,orderId from `order`";
        return getList(sql);
    }

    @Override
    public void changeOrderStatus(String orderId, String status) throws SQLException
    {
        String sql = "update `order` set status = ? where orderId = ?";
        update(sql,status,orderId);
    }

    @Override
    public List<Order> queryOrdersByUser(Integer userId) throws SQLException
    {
        String sql = "select createTime,price,status,orderId from `order` where userId = ?";
        return getList(sql, userId);
    }
}
