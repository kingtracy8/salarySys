package com.hccnnet.salarySys.controller;

import com.hccnnet.salarySys.domain.Employees;
import com.hccnnet.salarySys.domain.Salary;
import com.hccnnet.salarySys.service.ISalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by trcay on 2018/12/9.
 */
@Controller
@RequestMapping(value = "/salarysys")
public class SalaryController {

    @Autowired
    ISalaryService salaryService;

    @RequestMapping(value = "/getSelfSalary")
    public @ResponseBody
    HashMap doExpenseMangerTIFilter(HttpServletRequest request, HttpServletResponse response,
                                    @RequestParam("limit") String limit, @RequestParam("offset") String offset){

        HashMap map = new HashMap();

        Employees employees = (Employees) request.getSession().getAttribute("user");
        Integer EpId = employees.getEpId();
        List<Salary> salaryList = salaryService.selectByEpId(EpId,0,10);
        Integer count = salaryService.selectCountByEpId(EpId);
        map.put("rows",salaryList);
        map.put("total",count);
        return map;
    }


    @RequestMapping(value = "/getSelfSalaryPage")
    public String getSelfSalaryPage(HttpServletRequest request, HttpServletResponse response){
        return "SelfSalaryInfo";
    }

    @RequestMapping(value = "/getAllSalary")
    public @ResponseBody
    HashMap GetAllEPSalary(HttpServletRequest request, HttpServletResponse response,
                                    @RequestParam("limit") String limit, @RequestParam("offset") String offset){

        HashMap map = new HashMap();

        List<Salary> salaryList = salaryService.selectAll(0,10);
        Integer count = salaryService.selectAllCount();
        map.put("rows",salaryList);
        map.put("total",count);
        return map;
    }

    @RequestMapping(value = "/getAllSalaryPage")
    public String getAllSalaryPage(HttpServletRequest request, HttpServletResponse response){
        return "AllSalaryInfo";
    }

    @RequestMapping(value = "/getAllSalaryBySub")
    public @ResponseBody
    HashMap GetAllEPSalaryBySub(HttpServletRequest request, HttpServletResponse response,
                           @RequestParam("limit") String limit, @RequestParam("offset") String offset){

        HashMap map = new HashMap();

        Employees employees = (Employees) request.getSession().getAttribute("user");

        String subjection = employees.getSubjection();

        List<Salary> salaryList = salaryService.selectAllBySub(subjection,0,10);

        Integer count = salaryService.selectAllCountBySub(subjection);
        map.put("rows",salaryList);
        map.put("total",count);
        return map;
    }

    @RequestMapping(value = "/getAllSalaryPageBySub")
    public String getAllSalaryPageBySub(HttpServletRequest request, HttpServletResponse response){
        return "AllSalaryInfoBySub";
    }

    /**
     * 判断是本部的人力还是县份的人力
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/IsHostOrSub")
    public String IsHostOrSub(HttpServletRequest request, HttpServletResponse response){

        Employees employees = (Employees) request.getSession().getAttribute("user");
        String department = employees.getDepartment();
        String subjection = employees.getSubjection();
        //如果是本部的人力资源部
        if("人力资源部".equals(department)){

            //如果是本部的人力部
            if ("本部".equals(subjection)){
//                return "/salarysys/getAllSalaryPage";
                try {
                    request.getRequestDispatcher("/salarysys/getAllSalaryPage").forward(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                try {
                    request.getRequestDispatcher("/salarysys/getAllSalaryPageBySub").forward(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
//                return "/salarysys/getAllSalaryPageBySub";
            }


        }

        return "NoAuthority";
    }

}
