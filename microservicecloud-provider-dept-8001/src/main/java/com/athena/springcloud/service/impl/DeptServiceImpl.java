package com.athena.springcloud.service.impl;

import com.athena.springcloud.dao.DeptMapper;
import com.athena.springcloud.entity.Dept;
import com.athena.springcloud.service.DeptSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xiaoxiang.zhang
 * @Description:
 * @Date: Create in 9:15 PM 2020/1/31
 */
@Service
public class DeptServiceImpl implements DeptSerivce {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public boolean add(Dept dept) {
        int num = deptMapper.addDept(dept);
        if (num > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Dept get(Long deptNo) {
        return deptMapper.findById(deptNo);
    }

    @Override
    public List<Dept> listAll() {
        return deptMapper.findAll();
    }
}
