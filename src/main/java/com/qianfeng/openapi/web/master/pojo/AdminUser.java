package com.qianfeng.openapi.web.master.pojo;

import lombok.Data;
/**
 * @Author ZMQ
 * @Date 2020/9/9
 * @since 1.8
 * 用户实体类
 */
@Data
public class AdminUser {
  /**
   * 用户主键ID
   */
  private Integer id;
  /**
   * 用户密码
   */
  private String password;
  /**
   * 邮箱
   */
  private String email;
  /**
   * 真实姓名
   */
  private String realName;
  /**
   * 状态
   */
  private Integer status;
  /**
   * 用户身份
   */
  private Integer role;

}
