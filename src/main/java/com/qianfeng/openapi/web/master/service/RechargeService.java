package com.qianfeng.openapi.web.master.service;

import com.github.pagehelper.PageInfo;
import com.qianfeng.openapi.web.master.pojo.RechargeInfo;

/**
 * @Author ZMQ
 * @Date 2020/9/10
 * @since 1.8
 */
public interface RechargeService {
    /**
     * 查询所有客户的充值信息
     * @param page
     * @param limit
     * @return
     */
    PageInfo<RechargeInfo> queryAllRechargeInfo(Integer page, Integer limit);

    /**
     * 添加订单信息
     * @param cusId
     * @param createTime
     * @param updateTime
     * @param money
     * @param state
     * @param paymentType
     * @return
     */
    int addRecharge(Long cusId,String createTime,String updateTime,Integer money,Integer state,Integer paymentType);

    /**
     * 通过id更新订单信息
     * @param id
     * @param cusId
     * @param createTime
     * @param updateTime
     * @param money
     * @param state
     * @param paymentType
     * @return
     */
    int updateRecharge(Long id, Long cusId, String createTime, String updateTime, Integer money, Integer state, Integer paymentType);

    /**
     * 通过id删除选中的充值信息
     * @param ids
     * @return
     */
    int deleteRechargeInfoByIds(Long[] ids);
}
