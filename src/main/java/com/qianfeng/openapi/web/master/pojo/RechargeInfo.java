package com.qianfeng.openapi.web.master.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
/**
 * @Author ZMQ
 * @Date 2020/9/7
 * @since 1.8
 * 充值实体类
 */
@Data
public class RechargeInfo {
  /**
   * 主键ID
   */
  private Long id;
  /**
   * 关联客户ID
   */
  private Long cusId;
  /**
   * 创建订单时间
   * //@JsonFormat(pattern = "yyyy-MM-dd" , timezone = "GMT+8")
   */
  private Date createTime;
  /**
   * 更新时间
   //  @JsonFormat(pattern = "yyyy-MM-dd" , timezone = "GMT+8")
   */
  private Date updateTime;
  /**
   * 金额 (分)
   */
  private Integer money;
  /**
   * 状态 0 未支付,1 已支付,2 已取消
   */
  private Integer state;
  /**
   * 付款方式 0 银联,1 微信,2 支付宝
   */
  private Integer paymentType;

  private RechargeInfo(){}

  private static class GetRechargeInstant{
    public static final RechargeInfo RECHARGE_INFO = new RechargeInfo();
  }

  public static RechargeInfo rechargeInstant(){
      return GetRechargeInstant.RECHARGE_INFO;
  }

}
