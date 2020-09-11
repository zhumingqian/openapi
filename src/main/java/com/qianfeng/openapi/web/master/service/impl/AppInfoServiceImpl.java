package com.qianfeng.openapi.web.master.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianfeng.openapi.web.master.mapper.AppInfoMapper;
import com.qianfeng.openapi.web.master.mapper.CustomerMapper;
import com.qianfeng.openapi.web.master.pojo.AppInfo;
import com.qianfeng.openapi.web.master.pojo.Customer;
import com.qianfeng.openapi.web.master.service.AppInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ZMQ
 * @Date 2020/9/8
 * @since 1.8
 */
@Service
public class AppInfoServiceImpl implements AppInfoService {
    @Autowired
    private AppInfoMapper appInfoMapper;
    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 查询所有应用信息
     *
     * @param page
     * @param limit
     * @return
     */
    @Override
    public PageInfo<AppInfo> queryAllAppInfo(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<AppInfo> appInfoList = appInfoMapper.queryAllAppInfo();
        return new PageInfo<>(appInfoList);
    }

    /**
     * 查询所有客户信息
     * @return
     */
    @Override
    public List<Customer> queryCustomer() {
        return customerMapper.queryAllCustomer();
    }

    /**
     * 添加应用信息
     * @param appInfo
     * @return
     */
    @Override
    public int addAppInfo(AppInfo appInfo) {
        Customer customer = customerMapper.queryCustomerById(appInfo.getCusId());
        appInfo.setCorpName(customer.getNickName());
        return appInfoMapper.addAppInfo(appInfo);
    }

    /**
     * 修改应用信息
     * @param appInfo
     * @return
     */
    @Override
    public int updateAppInfo(AppInfo appInfo) {
        Customer customer = customerMapper.queryCustomerById(appInfo.getCusId());
        appInfo.setCorpName(customer.getNickName());
        return appInfoMapper.updateAppInfo(appInfo);
    }

    /**
     * 删除应用信息
     * @param ids
     * @return
     */
    @Override
    public int deleteAppInfoByIds(Long[] ids) {
        return appInfoMapper.deleteAppInfoByIds(ids);
    }

    /**
     * 根据条件查询应用信息
     * @param page
     * @param limit
     * @param appName
     * @param state
     * @return
     */
    @Override
    public PageInfo<AppInfo> queryAppInfoByCondition(Integer page, Integer limit, String appName, Integer state) {
        PageHelper.startPage(page , limit);
        List<AppInfo> appInfoList = appInfoMapper.queryAppInfoByCondition(appName , state);
        return new PageInfo<>(appInfoList);
    }
}
