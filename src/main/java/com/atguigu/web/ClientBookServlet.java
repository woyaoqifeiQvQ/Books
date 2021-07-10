package com.atguigu.web; /**
 * @author woyaoqifeQvQ
 * @create 2021-06-18 17:10
 */

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.JDBCUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class ClientBookServlet extends BaseServlet
{
    private BookService bookService = new BookServiceImpl();

    public void page(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        //获取请求参数 pageNo 与 pageSize
        Integer pageNo = request.getParameter("pageNo") == null ? Page.PAGE_INIT : Integer.valueOf(request.getParameter("pageNo"));
        Integer pageSize = request.getParameter("pageSize") == null ? Page.PAGE_SIZE : Integer.valueOf(request.getParameter("pageSize"));

        //通过Service层 调用DAO层的方法 与数据库进行交互 通过分页查询获取每页的数据
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("client/bookServlet?action=page");
        request.setAttribute("page",page);
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);
    }

    public void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        //获取请求参数 pageNo 与 pageSize
        Integer pageNo = request.getParameter("pageNo") == null ? Page.PAGE_INIT : Integer.valueOf(request.getParameter("pageNo"));
        Integer pageSize = request.getParameter("pageSize") == null ? Page.PAGE_SIZE : Integer.valueOf(request.getParameter("pageSize"));
        Integer min = request.getParameter("min") == null || request.getParameter("min").equals("") ? 0 : Integer.parseInt(request.getParameter("min"));
        Integer max = request.getParameter("min") == null || request.getParameter("max").equals("") ? Integer.MAX_VALUE : Integer.parseInt(request.getParameter("max"));

        //通过Service层 调用DAO层的方法 与数据库进行交互 通过分页查询获取每页的数据
        Page<Book> page = bookService.pageByPrice(pageNo, pageSize, min, max);

        //这里用于在分页的时候 回不回显数据的问题 如果用户没有输入最大值和最小值 则不回显数据
        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");
        if(request.getParameter("min") != null && !request.getParameter("min").equals(""))
        {
            sb.append("&min=").append(request.getParameter("min"));
        }
        if(request.getParameter("max") != null && !request.getParameter("max").equals(""))
        {
            sb.append("&max=").append(request.getParameter("max"));
        }
        page.setUrl(sb.toString());
        //如果直接在Url 这里加的话  则不管用户输入还是不输入都会回显数据
//            page.setUrl("client/bookServlet?action=pageByPrice&min=" + min + "&max=" + max);
        request.setAttribute("page",page);
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);
    }

}
