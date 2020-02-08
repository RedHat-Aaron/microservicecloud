package com.athena.springcloud.dao;

import com.athena.springcloud.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: xiaoxiang.zhang
 * @Description:部门数据访问层
 * @Date: Create in 8:54 PM 2020/1/31
 */
@Mapper
public interface DeptMapper {
    int addDept(Dept dept);

    Dept findById(@Param("deptNo") Long deptNo);

    List<Dept> findAll();
}
