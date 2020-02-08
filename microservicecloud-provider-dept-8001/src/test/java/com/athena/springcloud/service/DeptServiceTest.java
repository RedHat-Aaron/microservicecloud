package com.athena.springcloud.service;

import com.athena.springcloud.entity.Dept;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: xiaoxiang.zhang
 * @Description:
 * @Date: Create in 9:48 PM 2020/1/31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeptServiceTest {

    @Autowired
    private DeptSerivce deptSerivce;

    @Test
    public void testListAll(){
        List<Dept> depts = deptSerivce.listAll();
        System.out.println(depts);
    }
}
