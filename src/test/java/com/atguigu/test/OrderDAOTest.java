package com.atguigu.test;

import com.atguigu.dao.OrderDAO;
import com.atguigu.dao.impl.OrderDAOImpl;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.Status;
import com.atguigu.utils.JDBCUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author woyaoqifeQvQ
 * @create 2021-07-03 12:47
 */
public class OrderDAOTest
{
    private OrderDAO orderDAO = new OrderDAOImpl();
    @Test
    public void saveOrder() throws SQLException
    {
        Connection connection = JDBCUtils.getConnection();
        orderDAO.saveOrder(new Order("123214",new Timestamp(new Date().getTime()),new BigDecimal(1000), "Undelivered",1));
    }


    @Test
    public void queryOrders() throws SQLException
    {
        Connection connection = JDBCUtils.getConnection();
        List<Order> orders = orderDAO.queryOrders();
        orders.forEach(System.out::println);
    }

    @Test
    public void changeOrderStatus()
    {
    }

    @Test
    public void queryOrdersByUser()
    {
    }
}