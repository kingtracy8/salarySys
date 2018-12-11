package com.hccnnet.salarySys.interceptor;

import com.hccnnet.salarySys.domain.Employees;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by trcay on 2018/12/11.
 * 查询所有员工资接口拦截器
 */
public class QueryAllInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Employees employees = (Employees) request.getSession().getAttribute("user");
        if(!"人力资源部".equals(employees.getDepartment())){
            //如果不是 人力资源部的人
            request.getRequestDispatcher("/NoAuthority.jsp").forward(request, response);
            return false;
        }
        if(!"本部".equals(employees.getSubjection())){
            //如果不是 本部 人力资源部的人
            request.getRequestDispatcher("/NoAuthority.jsp").forward(request, response);
            return false;
        }

        return true;
    }

}
