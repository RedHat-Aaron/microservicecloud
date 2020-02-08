package com.athena.springcloud.interfaces;

import com.athena.springcloud.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: xiaoxiang.zhang
 * @Description:
 * @Date: Create in 10:00 PM 2020/2/7
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            public boolean add(Dept dept) {
                return false;
            }

            public Dept get(Long deptNo) {
                return new Dept().setDeptNo(deptNo).setDName("该ID"+deptNo+"没有对应的信息，Consumer客户端提供的降级信息，此刻provider服务yijingguanbi ")
                        .setDbSource("no this database inMySQL!!");
            }

            public List<Dept> listAll() {
                return null;
            }
        };
    }
}
