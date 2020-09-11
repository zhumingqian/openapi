package com.qianfeng.openapi.web.master.pojo;

import lombok.Data;

/**
 * @Author ZMQ
 * @Date 2020/9/7
 * @since 1.8
 * 路由实体类
 */
@Data
public class RouteInfo {
  /**
   * 主键ID
   */
  private Long id;
  /**
   * 网关Api名称(路由名称标识)
   */
  private String gatewayApiName;
  /**
   * 服务接口地址
   */
  private String insideApiUrl;
  /**
   * 服务名称
   */
  private String serviceId;
  /**
   * 介绍信息
   */
  private String description;
  /**
   * 状态 1 有效,0 无效
   */
  private Long state;
  /**
   *幂等性 1 幂等 0 非幂等
   */
  private Long idempotents;
  /**
   * 是否收费 1 收费 0 免费
   */
  private Long needFee;

}
