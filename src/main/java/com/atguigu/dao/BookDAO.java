package com.atguigu.dao;

import com.atguigu.pojo.Book;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface BookDAO
{
    /**
     *  添加一条图书记录
     * @param book
     * @return 返回0则操作失败 其余则是操作成功的数据条数
     * @throws SQLException
     */
    int addBook(Book book) throws SQLException;

    /**
     *  根据id删除一条图书记录
     * @param id
     * @return 返回0则操作失败 其余则是操作成功的数据条数
     * @throws SQLException
     */
    int deleteBook(Integer id) throws SQLException;

    /**
     *  修改一条记录
     * @param book
     * @return
     * @throws SQLException
     */
    int updateBook(Book book) throws SQLException;

    /**
     *  根据ID查询图书
     * @param id
     * @return
     * @throws SQLException
     */
    Book queryBookById(Integer id) throws SQLException;

    /**
     *  查询所有图书
     * @return
     * @throws SQLException
     */
    List<Book> queryBooks() throws SQLException;

    /**
     * 查询所有记录
     * @return
     */
    Long getValue() throws SQLException;

    /**
     * 查询每页的记录
     * @param pageNo
     * @param pageSize
     * @return
     * @throws SQLException
     */
    List<Book> getItems(Integer pageNo, Integer pageSize) throws SQLException;

    Long getValueByPrice(Integer min, Integer max) throws SQLException;

    List<Book> getItemsByPrice(Integer min, Integer max, Integer pageNo, Integer pageSize) throws SQLException;
}
