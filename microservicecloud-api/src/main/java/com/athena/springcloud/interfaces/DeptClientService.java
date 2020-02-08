package com.athena.springcloud.interfaces;

import com.athena.springcloud.entity.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Author: xiaoxiang.zhang
 * @Description:部门远程调用接口
 * @Date: Create in 10:07 AM 2020/2/7
 */
//@FeignClient(serviceId = "MICROSERVICECLOUD-DEPT")
@FeignClient(serviceId = "MICROSERVICECLOUD-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

    @RequestMapping(value="/dept/add",method = RequestMethod.POST)
    boolean add(Dept dept);

    @RequestMapping(value="/dept/get/{id}",method = RequestMethod.GET)
    Dept get(@PathVariable("id") Long deptNo);

    @RequestMapping(value="/dept/list",method = RequestMethod.GET)
    List<Dept> listAll();
}
