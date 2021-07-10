package com.atguigu.pojo;/**
    @author woyaoqifeQvQ
    
    @create 2021-06-27 13:54
*/

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**

   @Description 购物车
   @author woyaoqifeiQvQ
   @create 2021-06-27-13:54
*/
public class Cart
{
    private Map<Integer,CartItem> items = new LinkedHashMap<>();

    public Integer getTotalCount()
    {
        Integer totalCount = 0;
        for(Map.Entry<Integer,CartItem> entry : items.entrySet())
        {
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }

    public BigDecimal getTotalPrice()
    {
        BigDecimal totalPrice = new BigDecimal(0);
        for(Map.Entry<Integer,CartItem> entry : items.entrySet())
        {
           totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }


    public Map<Integer,CartItem> getItems()
    {
        return items;
    }

    public void setItems(Map<Integer,CartItem> items)
    {
        this.items = items;
    }

    /**
     * 添加商品
     * @param cartItem
     */
    public void addItem(CartItem cartItem)
    {
        //先查看购物车中是否已添加此商品
        CartItem item = items.get(cartItem.getId());
        if(item == null)
        {
            items.put(cartItem.getId(),cartItem);
        }
        else
        {
            item.setCount(item.getCount() + cartItem.getCount());
            item.setTotalPrice( item.getPrice().multiply(new BigDecimal(item.getCount())) );
        }
    }

    /**
     * 修改商品数量
     * @param id
     * @param count
     */
    public void updateCount(Integer id, Integer count)
    {
        CartItem cartItem = items.get(id);
        if(cartItem != null)
        {
            cartItem.setCount(count);
            cartItem.setTotalPrice( cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
        }
    }
    /**
     * 删除商品
     * @param id
     */
    public void deleteItem(Integer id)
    {
        items.remove(id);
    }

    /**
     * 清空购物车
     */
    public void clear()
    {
        items.clear();
    }
    @Override
    public String toString()
    {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
