package com.athena.springcloud.controller;

import com.athena.springcloud.entity.Dept;
import com.athena.springcloud.service.DeptSerivce;
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

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        boolean result = deptSerivce.add(dept);
        return result;
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long deptNo) {
        return deptSerivce.get(deptNo);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Dept> listAll() {
        return deptSerivce.listAll();
    }

    @RequestMapping(value = "/discovery", method = RequestMethod.GET)
    public Object discovery() {
        List<String> services = client.getServices();
        System.out.println("******" + services);
        List<ServiceInstance> instances = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.client;
    }
}
