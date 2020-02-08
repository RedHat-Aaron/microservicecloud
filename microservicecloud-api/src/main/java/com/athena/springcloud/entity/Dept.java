package com.athena.springcloud.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author: xiaoxiang.zhang
 * @Description:部门实体对象
 * @Date: Create in 5:17 PM 2020/1/31
 */
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Dept implements Serializable {

    /**
     * 主键
     */
    private Long deptNo;

    /**
     * 部门名称
     */
    private String dName;

    /**
     * 来源数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息可以被储存到不同的数据库
     */
    private String dbSource;

    public Dept(String dName) {
        this.dName = dName;
    }
}
