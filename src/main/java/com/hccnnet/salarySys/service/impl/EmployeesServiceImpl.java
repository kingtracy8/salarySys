package com.hccnnet.salarySys.service.impl;

import com.hccnnet.salarySys.IDao.EmployeesMapper;
import com.hccnnet.salarySys.domain.Employees;
import com.hccnnet.salarySys.service.IEmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by trcay on 2018/12/5.
 */
@Service
public class EmployeesServiceImpl implements IEmployeesService{

    @Autowired
    EmployeesMapper employeesMapper;

    @Override
    public Employees selectByPrimaryKey(Integer epId) {
        return employeesMapper.selectByPrimaryKey(epId);
    }

    @Override
    public List<Employees> selectByUserName(String userName) {
        return employeesMapper.selectByUserName(userName);
    }
}
