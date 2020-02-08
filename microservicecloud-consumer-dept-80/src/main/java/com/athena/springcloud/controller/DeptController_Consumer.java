package com.athena.springcloud.controller;

import com.athena.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author: xiaoxiang.zhang
 * @Description:部门控制器消费者
 * @Date: Create in 12:36 AM 2020/2/1
 */
@RestController
@RequestMapping(value = "/consumer/dept")
public class DeptController_Consumer {

    //private static final String REST_URL_PREFIX = "http://localhost:8001/dept";

    //Ribbon和Eureka整合以后，可以直接调用服务而不用再关心地址和端口号
    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT/dept";
    /**
     * 这里就使用RestTemplate来进行调用
     */
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/add")
    public boolean add(Dept dept) {
        //参数：请求地址，请求参数，返回对象类型
        Boolean result = restTemplate.postForObject(REST_URL_PREFIX + "/add", dept, Boolean.class);
        return result;
    }

    @RequestMapping("/get/{id}")
    public Dept add(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/get/" + id, Dept.class);
    }

    @RequestMapping("/list")
    public List<Dept> listAll() {
        //参数：请求地址，请求参数，返回对象类型
        return restTemplate.getForObject(REST_URL_PREFIX + "/list", List.class);
    }

    @RequestMapping("/discovery")
    public Object discovery(){
        return restTemplate.getForObject(REST_URL_PREFIX + "/discovery", Object.class);
    }
}
