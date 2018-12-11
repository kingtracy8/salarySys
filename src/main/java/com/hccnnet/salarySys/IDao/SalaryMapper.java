package com.hccnnet.salarySys.IDao;

import com.hccnnet.salarySys.domain.Salary;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryMapper {
    int deleteByPrimaryKey(Integer saId);

    int insert(Salary record);

    int insertSelective(Salary record);

    Salary selectByPrimaryKey(Integer saId);

    int updateByPrimaryKeySelective(Salary record);

    int updateByPrimaryKey(Salary record);

    List<Salary> selectByEpId(@Param("epId") Integer epId, @Param("limit") Integer limit, @Param("offset") Integer offset);

    Integer selectCountByEpId(@Param("epId") Integer epId);

    List<Salary> selectAll(@Param("limit") Integer limit, @Param("offset") Integer offset);

    List<Salary> selectAllBySub(@Param("subjection") String subjection,@Param("limit") Integer limit, @Param("offset") Integer offset);

    Integer selectAllCount();

    Integer selectAllCountBySub(@Param("subjection") String subjection);
}