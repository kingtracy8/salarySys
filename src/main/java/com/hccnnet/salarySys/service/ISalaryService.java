package com.hccnnet.salarySys.service;

import com.hccnnet.salarySys.domain.Salary;

/**
 * Created by trcay on 2018/12/7.
 */
public interface ISalaryService {

    int insertSelective(Salary record);
}
