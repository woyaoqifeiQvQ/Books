package com.atguigu.web; /**
 * @author woyaoqifeQvQ
 * @create 2021-07-08 14:48
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
import java.sql.SQLException;
import java.util.List;

public class ClientOrderServlet extends BaseServlet
{
    private final OrderService orderService = new OrderServiceImpl();
    private final OrderItemService orderItemService = new OrderItemServiceImpl();

    //生成订单
    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        HttpSession session = request.getSession();

        //从session域中获取 cart  和 user的信息
        Cart cart = (Cart) session.getAttribute("cart");
        User user = (User) session.getAttribute("user");

        //因为这个里面 涉及到两个sql语句  所以要加入事务吧
        String orderId = orderService.createOrder(cart, user.getId());

        session.setAttribute("orderId", orderId);
        response.sendRedirect(request.getContextPath() + "/pages/cart/checkout.jsp");
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

    //查看我的订单（用户）
    protected void showOMyOrders(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        User user = (User) request.getSession().getAttribute("user");

        int userId = user.getId();
        List<Order> orders = orderService.showMyOrders(userId);
        request.setAttribute("orders",orders);
        request.getRequestDispatcher("/pages/order/order.jsp").forward(request,response);
    }

    //签收（用户）
    protected void receiverOrder(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        User user = (User) request.getSession().getAttribute("user");
        int userId = user.getId();

        String orderId = request.getParameter("orderId");
        orderService.receiverOrder(orderId);

        List<Order> orders = orderService.showMyOrders(userId);
        request.setAttribute("orders",orders);
        request.getRequestDispatcher("/pages/order/order.jsp").forward(request,response);
    }
}
