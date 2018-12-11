package com.hccnnet.salarySys.interceptor;

import com.hccnnet.salarySys.domain.Employees;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by trcay on 2018/12/11.
 * 登录拦截器，一切操作必须登录才能进行
 */
public class LoginInterceptor extends HandlerInterceptorAdapter{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

       String uri = request.getRequestURI();
        if(uri.contains("/login")){
            return true;
        }
        Object employees = request.getSession().getAttribute("user");
        if (employees==null){
            request.getSession().setAttribute("msg","对不起，您还没有登录，请先登录！");
            request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
            return false;
        }
        return true;
    }
}
