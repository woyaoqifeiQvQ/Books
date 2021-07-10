package com.atguigu.pojo;/**
    @author woyaoqifeQvQ
    
    @create 2021-07-01 16:30
*/

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**

   @Description 
   @author woyaoqifeiQvQ
   @create 2021-07-01-16:30
*/
public class Order
{
    private String orderId;
    private Timestamp createTime;
    private BigDecimal price;
    //只能赋值 Undelivered，Delivered 和 Signed
    private String status = "Undelivered";
    private Integer userId;

    public Order()
    {

    }

    public Order(String orderId, Timestamp createTime, BigDecimal price, String status, Integer userId)
    {
        this.orderId = orderId;
        this.createTime = createTime;
        this.price = price;
        this.status = status;
        this.userId = userId;
    }

    public String getOrderId()
    {
        return orderId;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    public Timestamp getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime)
    {
        this.createTime = createTime;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    @Override
    public String toString()
    {
        return "Order{" +
                "orderId=" + orderId +
                ", createTime=" + createTime +
                ", price=" + price +
                ", status=" + status +
                ", userId='" + userId + '\'' +
                '}';
    }


}










































