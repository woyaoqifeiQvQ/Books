package com.atguigu.test;

import com.atguigu.dao.impl.BookDAOImpl;
import com.atguigu.pojo.CartItem;
import com.atguigu.pojo.Status;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**

   @Description 
   @author woyaoqifeiQvQ
   @create 2021-06-02-22:19
*/
public class JDBCUtilsTest
{
    @Test
    public void test()
    {
        Connection connection = null;
        try
        {
            connection = JDBCUtils.getConnection();

            System.out.println(connection);
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        finally
        {
//            JDBCUtils.closeResource(connection,null,null);
        }
    }

    @Test
    public void test1()
    {
        ArrayList objects = new ArrayList();
        objects.add(1);
        objects.add(2);
        objects.add(3);

        up(objects);

        objects.forEach(System.out::println);
    }

    public void up(List list)
    {
        list.remove(Integer.valueOf(2));
    }

    @Test
    public void test2()
    {
        List<CartItem> objects = new ArrayList();
        objects.add(new CartItem());

        for(CartItem cartItem : objects)
        {
            cartItem.setCount(1);
        }

        CartItem cartItem = objects.get(0);
        cartItem.setId(1);
        System.out.println(cartItem);
    }

    @Test
    public void test3() throws SQLException
    {
        Connection connection = JDBCUtils.getConnection();
        BookDAOImpl bookDAO = new BookDAOImpl();
        String sql = "insert into test1 values(?)";
        bookDAO.update(sql,Status.Signed.name());
        System.out.println(Status.Delivered);
    }

    @Test
    public void test4()
    {
        ((Runnable) () -> {
            try
            {
                Connection connection = JDBCUtils.getConnection();
                Connection connection1 = JDBCUtils.getConnection();

                System.out.println(connection);
                System.out.println(connection1);
            } catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }

        }).run();
    }

    @Test
    public void test5()
    {
        Connection conn = JDBCUtils.getConn();
        try
        {
            conn.close();
            conn.rollback();
            conn.setAutoCommit(false);
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

}






























