package com.qianfeng.openapi.web.master.pojo;


import lombok.Data;

import java.util.Date;

/**
 * @Author ZMQ
 * @Date 2020/9/7
 * @since 1.8
 * token实体类
 */
@Data
public class Token {
  /**
   *主键ID
   */
  private Long id;
  /**
   *客户ID
   */
  private Long userId;
  /**
   *token内容
   */
  private String accessToken;
  /**
   *开始时间
   */
  private Date startTime;
  /**
   *结束时间
   */
  private Date expireTime;


  /**
   * 私有化构造方法
   */
  private Token(){}

  /**
   * 内部类
   */
  private static class TokenObj{
    private static final Token TOKEN_INSTANT = new Token();
  }

  /**
   * 向外提供实例对象
   * @return Token
   */
  public static Token getToken(){
    return TokenObj.TOKEN_INSTANT;
  }
}
