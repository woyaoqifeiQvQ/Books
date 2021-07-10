package com.atguigu.test;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import com.atguigu.utils.JDBCUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * @author woyaoqifeQvQ
 * @create 2021-07-03 13:24
 */
public class OrderServiceTest
{
    OrderService orderService = new OrderServiceImpl();
    @Test
    public void createOrder() throws SQLException
    {
        Connection connection = JDBCUtils.getConnection();

        Cart cart = new Cart();
        cart.addItem(new CartItem(3,"海底两万里",2,new BigDecimal(100),new BigDecimal(200)));
        cart.addItem(new CartItem(4,"海底两万里2",2,new BigDecimal(100),new BigDecimal(200)));
        cart.addItem(new CartItem(5,"海底两万里3",2,new BigDecimal(100),new BigDecimal(200)));
        cart.addItem(new CartItem(6,"海底两万里4",2,new BigDecimal(100),new BigDecimal(200)));

//        System.out.println(cart);

//        String order = orderService.createOrder(connection, cart, 2);
    }

    @Test
    public void showAllOrders()
    {
    }

    @Test
    public void sendOrder()
    {
    }

    @Test
    public void showOrderDetail()
    {
    }

    @Test
    public void showMyOrders()
    {
    }

    @Test
    public void receiverOrder()
    {
    }
}