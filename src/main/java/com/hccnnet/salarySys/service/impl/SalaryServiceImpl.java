package com.hccnnet.salarySys.service.impl;

import com.hccnnet.salarySys.IDao.SalaryMapper;
import com.hccnnet.salarySys.domain.Salary;
import com.hccnnet.salarySys.service.ISalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Salary> selectByEpId(Integer epId, Integer limit, Integer offset) {
        return salaryMapper.selectByEpId(epId,limit,offset);
    }

    @Override
    public Integer selectCountByEpId(Integer epId) {
        return salaryMapper.selectCountByEpId(epId);
    }

    @Override
    public List<Salary> selectAll(Integer limit, Integer offset) {
        return salaryMapper.selectAll(limit,offset);
    }

    @Override
    public List<Salary> selectAllBySub(String subjection, Integer limit, Integer offset) {
        return salaryMapper.selectAllBySub(subjection,limit,offset);
    }

    @Override
    public Integer selectAllCount() {
        return salaryMapper.selectAllCount();
    }

    @Override
    public Integer selectAllCountBySub(String subjection) {
        return salaryMapper.selectAllCountBySub(subjection);
    }
}
