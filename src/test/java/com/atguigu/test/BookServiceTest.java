package com.atguigu.test;

import com.atguigu.pojo.Book;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.JDBCUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class BookServiceTest
{
//    private BookService bookService = new BookServiceImpl();
//    private static Connection connection;
//    static
//    {
//        try
//        {
//            connection = JDBCUtils.getConnection();
//        } catch (SQLException throwables)
//        {
//            throwables.printStackTrace();
//        }
//    }
//    @Test
//    public void addBook()
//    {
//        try
//        {
//            bookService.addBook(connection,new Book(null,"法伦大法好",new BigDecimal(991),"好家伙",10,9980,null));
//        } catch (SQLException throwables)
//        {
//            throwables.printStackTrace();
//        }
//        JDBCUtils.closeResource(connection);
//    }
//
//    @Test
//    public void deleteBook()
//    {
//        try
//        {
//            bookService.deleteBook(connection,21);
//        } catch (SQLException throwables)
//        {
//            throwables.printStackTrace();
//        }
//        JDBCUtils.closeResource(connection);
//    }
//
//    @Test
//    public void update()
//    {
//        try
//        {
//            bookService.update(connection,new Book(null,"除了好家伙还会啥",new BigDecimal(991),"好家伙",10,9980,null));
//        } catch (SQLException throwables)
//        {
//            throwables.printStackTrace();
//        }
//        JDBCUtils.closeResource(connection);
//    }
//
//    @Test
//    public void queryBookById() throws SQLException
//    {
//        System.out.println(bookService.queryBookById(connection, 22));
//        JDBCUtils.closeResource(connection);
//    }
//
//    @Test
//    public void queryBooks() throws SQLException
//    {
//        List<Book> books = bookService.queryBooks(connection);
//        books.forEach(System.out::println);
//        JDBCUtils.closeResource(connection);
//    }
}