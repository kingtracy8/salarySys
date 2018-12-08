package com.hccnnet.salarySys.controller;

import com.hccnnet.salarySys.domain.Employees;
import com.hccnnet.salarySys.service.IEmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by trcay on 2018/12/5.
 * 登录控制器，接收用户登录请求
 */
@Controller
@RequestMapping(value = "/salarysys")
public class LoginController {

    @Autowired
    IEmployeesService employeesService;

    /**
     * 检查form表单提交的用户名和密码是否正确
     *
     * @param request
     * @param response
     * @return 登陆成功跳转到后台管理首页
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String
    doCheckFormLogin(HttpServletRequest request, HttpServletResponse response) {
        String Url = null;
        //当数据库没有数据的时候会抛出空指针异常

        String name = request.getParameter("username");
        String pass = request.getParameter("password");


        List<Employees> employeesList = employeesService.selectByUserName(name);

        if (employeesList.size() > 0) {
            for (int i = 0; i < employeesList.size(); i++) {
                String userName = employeesList.get(i).getUserName();
                String userPassword = employeesList.get(i).getPassword();
                if (name.equals(userName) && pass.equals(userPassword)) {
                    Url = "main";
/*                    request.getSession().setAttribute("userName", request.getParameter("userName"));
                    //如果验证成功 直接跳转 否则for循环会影响最终的结果
                    //把身份放入Session
                    String identity = String.valueOf(employeesList.get(i).getIdentity());
                    request.getSession().setAttribute("identity", identity);
                    request.getSession().setAttribute("employeeId", employeesList.get(i).getEpId());
                    //用employeeId去查部门id  update by linsong.wei 2018-09-23 18:53:09
                    int employeeId = employeesList.get(i).getEpId();
                    int deptId = employeesService.selectDeptIdById(employeeId);
                    request.getSession().setAttribute("deptId", deptId);*/

                //尝试直接将对象放入session

                    request.getSession().setAttribute("user",employeesList.get(i));


                return Url;
            } else {
                Url = "error";
                request.getSession().setAttribute("userName", request.getParameter("error"));
                }
            }
        } else {
            Url = "error";
        }
        return Url;
    }
}
