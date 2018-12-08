package com.hccnnet.salarySys.interceptor;

import com.hccnnet.salarySys.domain.Employees;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by trcay on 2018/12/8.
 * 拦截非人事部门上传Excel表的请求
 */
public class UploadInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

       Employees employees = (Employees) request.getSession().getAttribute("user");
      if(!"人力资源部".equals(employees.getDepartment())){
          //如果不是人力资源部的人
          request.getRequestDispatcher("/error.jsp").forward(request, response);
          return false;
      }

        return true;
    }
}
