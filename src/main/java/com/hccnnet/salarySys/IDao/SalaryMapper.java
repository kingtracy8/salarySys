package com.hccnnet.salarySys.IDao;

import com.hccnnet.salarySys.domain.Salary;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryMapper {
    int deleteByPrimaryKey(Integer saId);

    int insert(Salary record);

    int insertSelective(Salary record);

    Salary selectByPrimaryKey(Integer saId);

    int updateByPrimaryKeySelective(Salary record);

    int updateByPrimaryKey(Salary record);
}