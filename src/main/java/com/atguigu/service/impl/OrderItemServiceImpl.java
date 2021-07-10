package com.atguigu.service.impl;/**
    @author woyaoqifeQvQ
    
    @create 2021-07-03 22:57
*/

import com.atguigu.dao.OrderItemDAO;
import com.atguigu.dao.impl.OrderItemDAOImpl;
import com.atguigu.pojo.OrderItem;
import com.atguigu.service.OrderItemService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**

   @Description 
   @author woyaoqifeiQvQ
   @create 2021-07-03-22:57
*/
public class OrderItemServiceImpl implements OrderItemService
{
    OrderItemDAO orderItemDAO = new OrderItemDAOImpl();
    @Override
    public List<OrderItem> showOrderDetail(String orderId) throws SQLException
    {
        return orderItemDAO.queryOrderItemByOrderId(orderId);
    }
}
