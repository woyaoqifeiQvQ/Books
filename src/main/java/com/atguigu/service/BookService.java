package com.atguigu.service;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface BookService
{
    void addBook(Book book) throws SQLException;

    void deleteBook(Integer id) throws SQLException;

    void update(Book book) throws SQLException;

    Book queryBookById(Integer id) throws SQLException;

    List<Book> queryBooks() throws SQLException;

    Page<Book> page(Integer pageNo, Integer pageSize) throws SQLException;

    Page<Book> pageByPrice(Integer pageNo, Integer pageSize, Integer min, Integer max) throws SQLException;
}
