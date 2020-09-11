package com.qianfeng.openapi.web.master.pojo;

import lombok.Data;

/**
 * @Author ZMQ
 * @Date 2020/9/7
 * @since 1.8
 * 客户实体类
 */
@Data
public class Customer {
    /**
     * 客户主键ID
     */
    private Long id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 公司名称
     */
    private String nickName;
    /**
     * 地址
     */
    private String address;
    /**
     * 余额
     */
    private Integer money;
    /**
     * 状态
     */
    private Integer state;
}
