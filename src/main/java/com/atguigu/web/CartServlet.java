package com.atguigu.web; /**
 * @author woyaoqifeQvQ
 * @create 2021-06-27 15:22
 */

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.JDBCUtils;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CartServlet extends BaseServlet
{
    private BookService bookService = new BookServiceImpl();

    //添加商品到购物车ajax发起请求
    protected void ajaxAddItem(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        //1. 获取id值
        String id_str = request.getParameter("id");
        Integer id = Integer.valueOf(id_str);
        //2. 调用bookService 查找book信息
        Book book = bookService.queryBookById(id);
        //3. 添加到购物车
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if(cart == null)
        {
            cart = new Cart();
            session.setAttribute("cart",cart);
        }
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        cart.addItem(cartItem);

        //设置最后一个添加到购物车的商品的名称到session域中 ： 为了在首页显示信息
        session.setAttribute("lastName",cartItem.getName());

        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("count",cart.getTotalCount());
        resultMap.put("lastName", cartItem.getName());

        Gson gson = new Gson();

        String json = gson.toJson(resultMap);

        response.getWriter().write(json);
    }

    protected void updateItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Integer count =Integer.valueOf(request.getParameter("count"));
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.updateCount(id,count);

        response.sendRedirect(request.getHeader("Referer"));
    }

    protected void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String id_str = request.getParameter("id");
        Integer id = Integer.valueOf(id_str);
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.deleteItem(id);
        System.out.println("删除成功");
        response.sendRedirect(request.getContextPath() + "/pages/cart/cart.jsp");
    }

    protected void clearItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.clear();
        System.out.println("清空成功");
        response.sendRedirect(request.getContextPath() + "/pages/cart/cart.jsp");
    }
}
