package com.qianfeng.openapi.web.master.service.impl;
import java.text.ParseException;
import java.util.Date;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianfeng.openapi.web.master.mapper.RechargeMapper;
import com.qianfeng.openapi.web.master.pojo.RechargeInfo;
import com.qianfeng.openapi.web.master.service.RechargeService;
import com.qianfeng.openapi.web.master.utils.DateExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ZMQ
 * @Date 2020/9/10
 * @since 1.8
 * 充值业务层
 */
@Service
public class RechargeServiceImpl implements RechargeService {
    @Autowired
    private RechargeMapper rechargeMapper;

    /**
     * 查询所有客户的充值信息
     * @param page
     * @param limit
     * @return
     */
    @Override
    public PageInfo<RechargeInfo> queryAllRechargeInfo(Integer page, Integer limit) {
        PageHelper.startPage(page , limit);
        List<RechargeInfo> rechargeInfos = rechargeMapper.queryAllRechargeInfo();
        return new PageInfo<>(rechargeInfos);
    }

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
    @Override
    public int addRecharge(Long cusId,String createTime,String updateTime,Integer money,Integer state,
                           Integer paymentType) {
        RechargeInfo rechargeInfo = RechargeInfo.rechargeInstant();
        rechargeInfo.setCusId(cusId);
        try {
            rechargeInfo.setCreateTime(DateExchange.strToUtilDate(createTime));
            rechargeInfo.setUpdateTime(DateExchange.strToUtilDate(updateTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        rechargeInfo.setMoney(money);
        rechargeInfo.setState(state);
        rechargeInfo.setPaymentType(paymentType);

        return rechargeMapper.addRecharge(rechargeInfo);
    }

    /**
     * 通过id 修改充值信息
     * @param id
     * @param cusId
     * @param createTime
     * @param updateTime
     * @param money
     * @param state
     * @param paymentType
     * @return
     */
    @Override
    public int updateRecharge(Long id, Long cusId, String createTime, String updateTime, Integer money, Integer state, Integer paymentType) {
        RechargeInfo rechargeInfo = RechargeInfo.rechargeInstant();
        rechargeInfo.setId(id);
        rechargeInfo.setCusId(cusId);
        try {
            rechargeInfo.setCreateTime(DateExchange.strToUtilDate(createTime));
            rechargeInfo.setUpdateTime(DateExchange.strToUtilDate(updateTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        rechargeInfo.setMoney(money);
        rechargeInfo.setState(state);
        rechargeInfo.setPaymentType(paymentType);
        return rechargeMapper.updateRechargeById(rechargeInfo);
    }

    /**
     * 通过id删除选中的充值信息
     * @param ids
     * @return
     */
    @Override
    public int deleteRechargeInfoByIds(Long[] ids) {
        return rechargeMapper.deleteRechargeInfoByIds(ids);
    }
}
