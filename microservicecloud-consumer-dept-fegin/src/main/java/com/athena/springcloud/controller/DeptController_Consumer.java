package com.athena.springcloud.controller;

import com.athena.springcloud.entity.Dept;
import com.athena.springcloud.interfaces.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: xiaoxiang.zhang
 * @Description:部门控制器消费者
 * @Date: Create in 12:36 AM 2020/2/1
 */
@RestController
@RequestMapping(value = "/consumer/dept")
public class DeptController_Consumer {

    @Autowired
    private DeptClientService deptClientService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean add(Dept dept) {
        //参数：请求地址，请求参数，返回对象类型
        Boolean result = deptClientService.add(dept);
        return result;
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id) {
        return deptClientService.get(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Dept> listAll() {
        //参数：请求地址，请求参数，返回对象类型
        return deptClientService.listAll();
    }
}
