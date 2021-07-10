package com.atguigu.filter; /**
 * @author woyaoqifeQvQ
 * @create 2021-07-04 16:41
 */

import com.atguigu.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ManagerFilter implements Filter
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
        //需要登录的用户id 为1 的才会拥有管理员权限
        else if(user.getId() == 1)
        {
            chain.doFilter(request, response);
        }
        else
        {
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
    }
}
