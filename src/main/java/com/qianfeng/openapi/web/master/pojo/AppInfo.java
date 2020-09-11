package com.qianfeng.openapi.web.master.pojo;

import lombok.Data;

/**
 * @Author ZMQ
 * @Date 2020/9/8
 * @since 1.8
 *
 * 应用实体类
 */
@Data
public class AppInfo {
    /**
     * 应用主键ID
     */
    private Long id;
    /**
     * 企业名称
     */
    private String corpName;
    /**
     * 应用名称
     */
    private String appName;
    /**
     * 应用唯一标识Key
     */
    private String appKey;
    /**
     * 应用签名秘钥
     */
    private String appSecret;
    /**
     * 应用回调URL
     */
    private String redirectUrl;
    /**
     * 免费接口日调用限制次数
     */
    private Integer limits;
    /**
     * 应用描述
     */
    private String description;
    /**
     * 关联客户id
     */
    private Integer cusId;
    /**
     * 状态
     */
    private Integer state;
}
