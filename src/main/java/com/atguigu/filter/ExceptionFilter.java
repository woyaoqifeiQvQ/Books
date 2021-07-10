package com.atguigu.filter; /**
 * @author woyaoqifeQvQ
 * @create 2021-07-08 16:34
 */

import com.atguigu.utils.JDBCUtils;

import javax.servlet.*;
import java.io.IOException;
import java.sql.SQLException;

public class ExceptionFilter implements Filter
{
    public void init(FilterConfig config) throws ServletException
    {
    }

    public void destroy()
    {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    {
        try
        {
            chain.doFilter(request, response);
            JDBCUtils.commit();
        }
        catch (Exception e)
        {
            JDBCUtils.rollback();
            throw new RuntimeException(e);
        }
        finally
        {
            JDBCUtils.closeResource();
        }
    }
}
