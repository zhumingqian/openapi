package com.qianfeng.openapi.web.master.mapper;

import com.qianfeng.openapi.web.master.pojo.RechargeInfo;

import java.util.List;

/**
 * @Author ZMQ
 * @Date 2020/9/10
 * @since 1.8
 */
public interface RechargeMapper {
    /**
     * 查询所有客户充值信息
     * @return
     */
    List<RechargeInfo> queryAllRechargeInfo();

    /**
     * 添加订单信息
     * @param rechargeInfo
     * @return
     */
    int addRecharge(RechargeInfo rechargeInfo);

    /**
     * 通过id 更新充值信息
     * @param rechargeInfo
     * @return
     */
    int updateRechargeById(RechargeInfo rechargeInfo);

    /**
     * 通过id删除选中的充值信息
     * @param ids
     * @return
     */
    int deleteRechargeInfoByIds(Long[] ids);

}
