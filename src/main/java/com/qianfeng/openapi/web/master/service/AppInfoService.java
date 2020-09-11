package com.qianfeng.openapi.web.master.service;

import com.github.pagehelper.PageInfo;
import com.qianfeng.openapi.web.master.pojo.AppInfo;
import com.qianfeng.openapi.web.master.pojo.Customer;

import java.util.List;

/**
 * @Author ZMQ
 * @Date 2020/9/8
 * @since 1.8
 */
public interface AppInfoService {
    /**
     * 查询所有应用信息
     *
     * @param page
     * @param limit
     * @return
     */
    PageInfo<AppInfo> queryAllAppInfo(Integer page, Integer limit);

    /**
     * 查询所有客户信息
     * @return
     */
    List<Customer> queryCustomer();

    /**
     * 添加应用信息
     * @param appInfo
     * @return
     */
    int addAppInfo(AppInfo appInfo);

    /**
     * 更新应用信息
     * @param appInfo
     * @return
     */
    int updateAppInfo(AppInfo appInfo);

    /**
     * 删除app信息
     * @param ids
     * @return
     */
    int deleteAppInfoByIds(Long[] ids);

    /**
     * 根据条件查询应用信息
     * @param page
     * @param limit
     * @param appName
     * @param state
     * @return
     */
    PageInfo<AppInfo> queryAppInfoByCondition(Integer page, Integer limit, String appName, Integer state);
}
