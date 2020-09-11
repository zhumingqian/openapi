package com.qianfeng.openapi.web.master.pojo;

import lombok.Data;

/**
 * @Author ZMQ
 * @Date 2020/9/7
 * @since 1.8
 * 角色实体类
 */
@Data
public class Role {
  /**
   * 角色主键ID
   */
  private Long id;
  /**
   * 角色名
   */
  private String name;
  /**
   * 角色备注
   */
  private String remark;
  /**
   * 角色状态
   */
  private Long status;

}
