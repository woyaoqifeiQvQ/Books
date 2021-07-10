package com.atguigu.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**

   @Description 
   @author woyaoqifeiQvQ
   @create 2021-06-06-12:56
*/
public abstract class WebUtils
{
    public static <T> T copyParamToBean(Map map, T bean) throws InvocationTargetException, IllegalAccessException
    {
        BeanUtils.populate(bean, map);
        return bean;
    }
}
