package com.hccnnet.salarySys.IDao;

import com.hccnnet.salarySys.domain.Employees;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesMapper {
    int deleteByPrimaryKey(Integer epId);

    int insert(Employees record);

    int insertSelective(Employees record);

    Employees selectByPrimaryKey(Integer epId);

    List<Employees> selectByUserName(@Param("userName") String userName);

    int updateByPrimaryKeySelective(Employees record);

    int updateByPrimaryKey(Employees record);
}