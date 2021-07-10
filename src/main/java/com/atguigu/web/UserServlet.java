package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.utils.JDBCUtils;
import com.atguigu.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet
{
    protected UserService userService = new UserServiceImpl();

    //用户注册
    public void register(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        //1. 获取表单提交上来的验证吗
        String codes = request.getParameter("codes");

        //获取谷歌生成的验证码
        HttpSession code_Session = request.getSession();
        String token = (String) code_Session.getAttribute(KAPTCHA_SESSION_KEY);
        code_Session.removeAttribute(KAPTCHA_SESSION_KEY);

        User user = WebUtils.copyParamToBean(request.getParameterMap(), new User());
        //2. 验证码是否正确
        if(token != null && token.equalsIgnoreCase(codes))
        {
            //3. 用户是否已经存在
            if(userService.existsUser(user.getUsername()))
            {
                request.setAttribute("msg","用户已存在");
                request.setAttribute("password",user.getPassword());
                request.setAttribute("email",user.getEmail());
                request.getRequestDispatcher("/pages/user/register.jsp").forward(request,response);
//                        user = null; 要不要加呢？
            }
            else
            {
                //4. 将用户信息存入数据库 并跳转到注册成功页面
                userService.registerUser(user);
                request.getRequestDispatcher("/pages/user/register_success.jsp").forward(request,response);
            }
        }
        else if(token == null)
        {
            request.setAttribute("msg","请勿重复提交！");
            request.getRequestDispatcher("/pages/user/register.jsp").forward(request,response);
        }
        else
        {
            //验证码不对 回传用户名 密码 以及邮箱 并提示用户 验证码输入错误
            request.setAttribute("username",user.getUsername());
            request.setAttribute("password",user.getPassword());
            request.setAttribute("email",user.getEmail());
            request.setAttribute("msg","验证码错误！");
            request.getRequestDispatcher("/pages/user/register.jsp").forward(request,response);
        }
    }


    //用户登录
    public void login(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        //1. 获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //2. 查询用户名或密码是否正确
        User loginUser = userService.loginUser(new User(null, username, password, null));
        if(loginUser == null)
        {
            request.setAttribute("msg","用户名或密码错误");
            request.setAttribute("username",username);
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        }
        else
        {
            //保存登录之后的信息
            request.getSession().setAttribute("user",loginUser);
            //如果是管理员则直接跳到管理页面
            if(loginUser.getId() == 1)
            {
                request.getRequestDispatcher("/pages/manager/manager.jsp").forward(request,response);
            }
            else
            {
                request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request,response);
            }
        }
    }

    //用户注销
    public void unLogin(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        HttpSession session = request.getSession();
        session.invalidate();

        response.sendRedirect(request.getContextPath());
    }

    //
    public void ajaxExistsUsername(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        System.out.println("我执行了");
        String username = request.getParameter("username");
        boolean existsUser = userService.existsUser(username);

        Map<String,Boolean> existsUsername = new HashMap<>();

        existsUsername.put("existsUser",existsUser);

        Gson gson = new Gson();

        String json = gson.toJson(existsUsername);

        response.getWriter().write(json);
    }
}























