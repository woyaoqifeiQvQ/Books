package com.atguigu.service.impl;/**
    @author woyaoqifeQvQ
    
    @create 2021-07-01 17:34
*/

import com.atguigu.dao.BookDAO;
import com.atguigu.dao.OrderDAO;
import com.atguigu.dao.OrderItemDAO;
import com.atguigu.dao.impl.BookDAOImpl;
import com.atguigu.dao.impl.OrderDAOImpl;
import com.atguigu.dao.impl.OrderItemDAOImpl;
import com.atguigu.pojo.*;
import com.atguigu.service.OrderService;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**

   @Description 
   @author woyaoqifeiQvQ
   @create 2021-07-01-17:34
*/
public class OrderServiceImpl implements OrderService
{
    OrderDAO orderDAO = new OrderDAOImpl();
    OrderItemDAO orderItemDAO = new OrderItemDAOImpl();
    BookDAO bookDAO = new BookDAOImpl();
    /**
     *  生成订单
     * @param cart 获取到的购物车信息
     * @param userId 用户Id
     * @throws SQLException
     */
    @Override
    public String createOrder(Cart cart, Integer userId) throws Exception
    {
        //生成订单号 时间戳 + 用户Id
        String orderId = System.currentTimeMillis() + "" + userId;
        //保存订单
        orderDAO.saveOrder(new Order(orderId,new Timestamp(new Date().getTime()),cart.getTotalPrice(),"Undelivered",userId));

        //同时保存订单项
        Map<Integer, CartItem> items = cart.getItems();
        for(CartItem entry : items.values())
        {
            orderItemDAO.saveOrderItem(new OrderItem(null,entry.getName(),entry.getCount(),entry.getPrice(),entry.getTotalPrice(),orderId));
            Book book = bookDAO.queryBookById(entry.getId());

            if(book.getStock() > entry.getCount())
            {
                //修改销量
                book.setSales( book.getSales() + entry.getCount());

                //修改库存
                book.setStock( book.getStock() - entry.getCount());

                bookDAO.updateBook(book);
            }
            else
            {
                throw new RuntimeException("库存不足，购买失败");
            }
        }

        cart.clear();

        return orderId;
    }

    @Override
    public List<Order> showAllOrders() throws SQLException
    {
        return orderDAO.queryOrders();
    }

    @Override
    public void sendOrder(String orderId) throws SQLException
    {
        orderDAO.changeOrderStatus(orderId,"Delivered");
    }

    @Override
    public List<OrderItem> showOrderDetail(String orderId) throws SQLException
    {
        return orderItemDAO.queryOrderItemByOrderId(orderId);
    }

    @Override
    public List<Order> showMyOrders(Integer userId) throws SQLException
    {
        return orderDAO.queryOrdersByUser(userId);
    }

    @Override
    public void receiverOrder(String orderId) throws SQLException
    {
        orderDAO.changeOrderStatus(orderId,"Signed");
    }
}
