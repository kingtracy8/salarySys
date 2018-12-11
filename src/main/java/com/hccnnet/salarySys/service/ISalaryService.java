package com.hccnnet.salarySys.service;

import com.hccnnet.salarySys.domain.Salary;

import java.util.List;

/**
 * Created by trcay on 2018/12/7.
 */
public interface ISalaryService {

    int insertSelective(Salary record);
    List<Salary> selectByEpId(Integer epId,Integer limit,Integer offset);
    Integer selectCountByEpId(Integer epId);
    List<Salary> selectAll(Integer limit,Integer offset);
    List<Salary> selectAllBySub(String subjection,Integer limit,Integer offset);
    Integer selectAllCount();
    Integer selectAllCountBySub(String subjection);
}
