package com.tracy.test;


import com.alibaba.fastjson.JSON;
import com.hccnnet.salarySys.domain.Employees;
import com.hccnnet.salarySys.domain.Salary;
import com.hccnnet.salarySys.service.IEmployeesService;
import com.hccnnet.salarySys.service.ISalaryService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by trcay on 2018/9/6.
 */


@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class TestMb {

    private static Logger logger = Logger.getLogger(TestMb.class);

    @Autowired
    IEmployeesService iEmployeesService;
    @Autowired
    ISalaryService iSalaryService;

    @Test
    public void test(){
//        logger.info(JSON.toJSONString(iEmployeesService.selectByPrimaryKey(11)));
//        List<Employees> Employees = iEmployeesService.selectByUserName("yg1");
        List<Salary> salaryList = iSalaryService.selectByEpId(45120939,0,10);
        logger.info(JSON.toJSONString(salaryList.get(0)));

//        Integer i = iSalaryService.selectCountByEpId(45120939);
//        logger.info(JSON.toJSONString(i));
    }


}
