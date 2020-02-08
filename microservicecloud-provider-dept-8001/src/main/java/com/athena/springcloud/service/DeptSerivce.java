package com.athena.springcloud.service;

import com.athena.springcloud.entity.Dept;

import java.util.List;

/**
 * @Author: xiaoxiang.zhang
 * @Description:
 * @Date: Create in 9:14 PM 2020/1/31
 */
public interface DeptSerivce {
    boolean add(Dept dept);

    Dept get(Long deptNo);

    List<Dept> listAll();
}
