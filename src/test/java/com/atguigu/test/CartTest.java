package com.atguigu.test;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author woyaoqifeQvQ
 * @create 2021-06-27 14:59
 */
public class CartTest
{
    private Cart cart = new Cart();
    @Test
    public void addItem()
    {
//        cart.addItem(new CartItem(1,"Java厉害啊",1,new BigDecimal(1000)));
//        cart.addItem(new CartItem(1,"Java厉害啊",2,new BigDecimal(1000)));
//        cart.addItem(new CartItem(2,"Java厉害啊2",2,new BigDecimal(100)));
        System.out.println(cart);
    }

    @Test
    public void updateCount()
    {
//        cart.addItem(new CartItem(1,"Java厉害啊",1,new BigDecimal(1000)));
//        cart.addItem(new CartItem(1,"Java厉害啊",2,new BigDecimal(1000)));
//        cart.addItem(new CartItem(2,"Java厉害啊2",2,new BigDecimal(100)));

        cart.updateCount(2,3);

        System.out.println(cart);
    }

    @Test
    public void deleteItem()
    {
//        cart.addItem(new CartItem(1,"Java厉害啊",1,new BigDecimal(1000)));
//        cart.addItem(new CartItem(1,"Java厉害啊",2,new BigDecimal(1000)));
//        cart.addItem(new CartItem(2,"Java厉害啊2",2,new BigDecimal(100)));

        cart.updateCount(2,3);

        cart.deleteItem(2);

        System.out.println(cart);
    }

    @Test
    public void clear()
    {
//        cart.addItem(new CartItem(1,"Java厉害啊",1,new BigDecimal(1000)));
//        cart.addItem(new CartItem(1,"Java厉害啊",2,new BigDecimal(1000)));
//        cart.addItem(new CartItem(2,"Java厉害啊2",2,new BigDecimal(100)));

        cart.updateCount(2,3);

        cart.deleteItem(2);

        cart.clear();

        System.out.println(cart);
    }
}