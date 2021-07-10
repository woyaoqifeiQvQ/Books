package com.atguigu.service.impl;

import com.atguigu.dao.BookDAO;
import com.atguigu.dao.impl.BookDAOImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**

   @Description 
   @author woyaoqifeiQvQ
   @create 2021-06-07-15:16
*/
public class BookServiceImpl implements BookService
{
    private BookDAO bookDAO = new BookDAOImpl();

    @Override
    public void addBook(Book book) throws SQLException
    {
        bookDAO.addBook(book);
    }

    @Override
    public void deleteBook(Integer id) throws SQLException
    {
        bookDAO.deleteBook(id);
    }

    @Override
    public void update(Book book) throws SQLException
    {
        bookDAO.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) throws SQLException
    {
        return bookDAO.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() throws SQLException
    {
        return bookDAO.queryBooks();
    }

    @Override
    public Page<Book> page(Integer pageNo, Integer pageSize) throws SQLException
    {
        Page<Book> bookPage = new Page<>();
        bookPage.setPageSize(pageSize);
        Long pageTotalCount = bookDAO.getValue();
        bookPage.setPageTotalCount(pageTotalCount);
        bookPage.setPageTotal();
        bookPage.setPageNo(pageNo);
        List<Book> items = bookDAO.getItems(bookPage.getPageNo(), pageSize);
        bookPage.setItems(items);
        return bookPage;
    }

    @Override
    public Page<Book> pageByPrice(Integer pageNo, Integer pageSize, Integer min, Integer max) throws SQLException
    {
        Page<Book> bookPage = new Page<>();
        bookPage.setPageSize(pageSize);
        Long pageTotalCount = bookDAO.getValueByPrice(min,max);
        bookPage.setPageTotalCount(pageTotalCount);
        bookPage.setPageTotal();
        bookPage.setPageNo(pageNo);
        List<Book> items = bookDAO.getItemsByPrice(min, max, bookPage.getPageNo(), pageSize);
        bookPage.setItems(items);
        return bookPage;

    }
}
