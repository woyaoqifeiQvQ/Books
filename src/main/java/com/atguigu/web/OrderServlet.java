package com.atguigu.web; /**
 * @author woyaoqifeQvQ
 * @create 2021-07-01 16:28
 */

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;
import com.atguigu.pojo.User;
import com.atguigu.service.OrderItemService;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderItemServiceImpl;
import com.atguigu.service.impl.OrderServiceImpl;
import com.atguigu.utils.JDBCUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class OrderServlet extends BaseServlet
{
    private final OrderService orderService = new OrderServiceImpl();
    private final OrderItemService orderItemService = new OrderItemServiceImpl();

    //查看所有订单（管理员权限）
    protected void showAllOrders(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        List<Order> orders = orderService.showAllOrders();
        request.setAttribute("orders",orders);
        request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request,response);
    }

    //发货（管理员权限）
    protected void sendOrder(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String orderId = request.getParameter("orderId");
        orderService.sendOrder(orderId);

        List<Order> orders = orderService.showAllOrders();
        request.setAttribute("orders",orders);
        request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request,response);
    }

    //查看订单详情
    protected void showOrderDetail(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        //获取订单号
        String orderId =  request.getParameter("orderId");
        List<OrderItem> orderItems = orderItemService.showOrderDetail(orderId);

        request.setAttribute("orderItems", orderItems);

        request.getRequestDispatcher("/pages/order/order_detail.jsp").forward(request,response);
    }
}









































