package com.atguigu.dao.impl;

import com.atguigu.dao.BookDAO;
import com.atguigu.pojo.Book;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**

   @Description 
   @author woyaoqifeiQvQ
   @create 2021-06-07-14:53
*/
public class BookDAOImpl extends BaseDAO<Book> implements BookDAO
{
    @Override
    public int addBook(Book book) throws SQLException
    {
        String sql = "insert into book (name,price,author,sales,stock,img_path)values(?,?,?,?,?,?)";
        return update(sql,book.getName(),book.getPrice(),book.getAuthor(),book.getSales(),book.getStock(),book.getImg_path());
    }

    @Override
    public int deleteBook(Integer id) throws SQLException
    {
        String sql = "delete from book where id = ?";
        return update(sql,id);
    }

    @Override
    public int updateBook(Book book) throws SQLException
    {
        String sql = "update book set `name`=?,price=?,author=?,sales=?,stock=?,img_path=? where id = ?";
        return update(sql,book.getName(),book.getPrice(),book.getAuthor(),book.getSales(),book.getStock(),book.getImg_path(),book.getId());
    }

    @Override
    public Book queryBookById(Integer id) throws SQLException
    {
        String sql = "select id,name,price,author,sales,stock,img_path from book where id = ?";
        return getInstance(sql,id);
    }

    @Override
    public List<Book> queryBooks() throws SQLException
    {
        String sql = "select id,name,price,author,sales,stock,img_path from book";
        return getList(sql);
    }

    @Override
    public Long getValue() throws SQLException
    {
        String sql = "select count(*) from book";
        return getValue(sql);
    }

    @Override
    public List<Book> getItems(Integer pageNo, Integer pageSize) throws SQLException
    {
        String sql = "select id,name,price,author,sales,stock,img_path from book limit ?,?";
        return getList(sql,(pageNo - 1) * pageSize,pageSize);
    }

    @Override
    public Long getValueByPrice(Integer min, Integer max) throws SQLException
    {
        String sql = "select count(*) from book where price between ? and ?";
        return getValue(sql,min,max);
    }

    @Override
    public List<Book> getItemsByPrice(Integer min, Integer max, Integer pageNo, Integer pageSize) throws SQLException
    {
        String sql = "select id,name,price,author,sales,stock,img_path from book where price between ? and ? order by price limit ?,?";
        return getList(sql,min,max,(pageNo - 1) * pageSize,pageSize);
    }
}
