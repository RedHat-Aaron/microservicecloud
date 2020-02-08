package com.athena.springcloud.controller;

import com.athena.springcloud.entity.Dept;
import com.athena.springcloud.service.DeptSerivce;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: xiaoxiang.zhang
 * @Description:部门微服务
 * @Date: Create in 9:22 PM 2020/1/31
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptSerivce deptSerivce;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        boolean result = deptSerivce.add(dept);
        return result;
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long deptNo) {
        Dept dept = deptSerivce.get(deptNo);
        if (null == dept) {
            throw new RuntimeException("该ID"+deptNo+"没有对应信息存在");
        }
        return dept;
    }

    private Dept processHystrix_Get(@PathVariable("id") Long deptNo){
        return new Dept().setDeptNo(deptNo).setDName("该查询对象不存在！！！").setDbSource("该查询信息不存在于数据库中！！！");
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Dept> listAll() {
        return deptSerivce.listAll();
    }

}
