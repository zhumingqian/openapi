package com.qianfeng.openapi.web.master.pojo;

import lombok.Data;

/**
 * @Author ZMQ
 * @Date 2020/9/7
 * @since 1.8
 * 系统参数实体类
 */
@Data
public class SystemParamInfo {
  /**
   *主键ID
   */
  private Long id;
  /**
   *参数名
   */
  private String name;
  /**
   *参数介绍
   */
  private String description;
  /**
   *状态 1 启用,0 禁用
   */
  private Long state;

}
