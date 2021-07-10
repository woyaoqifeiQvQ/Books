package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.JDBCUtils;
import com.atguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**

   @Description 
   @author woyaoqifeiQvQ
   @create 2021-06-07-16:26
*/
public class BookServlet extends BaseServlet
{
    private BookService bookService = new BookServiceImpl();

    public void addBook(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String str_PageNo = request.getParameter("pageNo");
        Integer pageNo = Integer.valueOf(str_PageNo);
        pageNo +=1;
        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
        bookService.addBook(book);
        //请求重定向 代替请求转发
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);
    }

    public void deleteBook(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        //获取每个图书信息的id 通过传参数
        String id = request.getParameter("id");
        bookService.deleteBook(Integer.valueOf(id));
        //请求重定向到list
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + request.getParameter("pageNo"));
    }

    public void getBook(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        //1. 回显要修改的信息
        String id = request.getParameter("id");
        Book book = bookService.queryBookById(Integer.valueOf(id));
        // 将数据设置到request域
        request.setAttribute("book", book);
        //进行请求转发
        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
    }

    public void updateBook(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        // 将修改之后的数据提交到数据库
        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
        bookService.update(book);
        // 重定向回主页
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + request.getParameter("pageNo"));
    }

    public void list(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        // Web层 通过service层 然后通过DAO 获取数据库的数据
        List<Book> books = bookService.queryBooks();
        // 将数据设置到request域
        request.setAttribute("books", books);
        //进行请求转发
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }

    public void page(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        //获取请求参数 pageNo 与 pageSize
        Integer pageNo = request.getParameter("pageNo") == null ? Page.PAGE_INIT : Integer.valueOf(request.getParameter("pageNo"));
        Integer pageSize = request.getParameter("pageSize") == null ? Page.PAGE_SIZE : Integer.valueOf(request.getParameter("pageSize"));

        //通过Service层 调用DAO层的方法 与数据库进行交互 通过分页查询获取每页的数据
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("manager/bookServlet?action=page");
        request.setAttribute("page",page);
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }

}
