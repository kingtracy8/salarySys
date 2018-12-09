package com.hccnnet.salarySys.controller;

import com.hccnnet.salarySys.domain.Employees;
import com.hccnnet.salarySys.domain.Salary;
import com.hccnnet.salarySys.service.ISalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

}
