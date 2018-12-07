package com.hccnnet.salarySys.service.impl;

import com.hccnnet.salarySys.IDao.SalaryMapper;
import com.hccnnet.salarySys.domain.Salary;
import com.hccnnet.salarySys.service.ISalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by trcay on 2018/12/7.
 */
@Service
public class SalaryServiceImpl implements ISalaryService{

    @Autowired
    SalaryMapper salaryMapper;

    @Override
    public int insertSelective(Salary record) {
        return salaryMapper.insertSelective(record);
    }
}
