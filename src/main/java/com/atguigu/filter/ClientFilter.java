package com.atguigu.filter; /**
 * @author woyaoqifeQvQ
 * @create 2021-07-08 15:11
 */

import com.atguigu.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ClientFilter implements Filter
{
    public void init(FilterConfig config) throws ServletException
    {
    }

    public void destroy()
    {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException
    {
        HttpServletRequest req = (HttpServletRequest) request;
        User user = (User) req.getSession().getAttribute("user");

        if(user == null)
        {
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        }
        else
        {
            chain.doFilter(request, response);
        }
    }
}
