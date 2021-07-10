package com.atguigu.test;

import com.atguigu.dao.OrderItemDAO;
import com.atguigu.dao.impl.OrderItemDAOImpl;
import com.atguigu.pojo.OrderItem;
import com.atguigu.utils.JDBCUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * @author woyaoqifeQvQ
 * @create 2021-07-03 12:55
 */
public class OrderItemDAOTest
{
    OrderItemDAO orderItemDAO = new OrderItemDAOImpl();
    @Test
    public void saveOrderItem() throws SQLException
    {
        Connection connection = JDBCUtils.getConnection();
        orderItemDAO.saveOrderItem(new OrderItem(null,"Man Vs Wild",2,new BigDecimal(100),new BigDecimal(200),"123214"));
    }

    @Test
    public void queryOrderItemByOrderId()
    {
    }
}