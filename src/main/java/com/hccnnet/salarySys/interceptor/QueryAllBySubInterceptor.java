package com.hccnnet.salarySys.interceptor;

import com.hccnnet.salarySys.domain.Employees;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by trcay on 2018/12/11.
 * 查询县份所有员工资接口拦截器
 */
public class QueryAllBySubInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        只要是人力部就可以进入访问通过隶属接口的URL

        Employees employees = (Employees) request.getSession().getAttribute("user");
        if (!"人力资源部".equals(employees.getDepartment())) {
            //如果不是 人力资源部的人
            request.getRequestDispatcher("/NoAuthority.jsp").forward(request, response);
            return false;
        }
        return true;
    }

}
