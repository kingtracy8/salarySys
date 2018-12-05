package com.hccnnet.salarySys.service;

import com.hccnnet.salarySys.domain.Employees;

import java.util.List;

/**
 * Created by trcay on 2018/12/5.
 */
public interface IEmployeesService {

    public Employees selectByPrimaryKey(Integer epId);

    List<Employees> selectByUserName(String userName);

}
