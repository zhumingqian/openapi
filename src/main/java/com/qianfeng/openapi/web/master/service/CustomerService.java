package com.qianfeng.openapi.web.master.service;

import com.github.pagehelper.PageInfo;
import com.qianfeng.openapi.web.master.pojo.Customer;

import java.util.List;

/**
 * @Author ZMQ
 * @Date 2020/9/7
 * @since 1.8
 */
public interface CustomerService {
    /**
     * 添加客户
     * @param customer
     * @return
     */
    int addCustomer(Customer customer);

    /**
     * 查询所有客户信息
     * @param page
     * @param limit
     * @return
     */
    PageInfo<Customer> queryAllCustomer(Integer page, Integer limit);

    /**
     * 更新客户信息
     * @param customer
     * @return
     */
    int updateCustomerInfo(Customer customer);

    /**
     * 删除选中的客户信息
     * @param ids
     * @return
     */
    int deleteCustomersByIds(Long[] ids);

    /**
     * 按条件模糊查询客户信息
     *
     * @param page
     * @param limit
     * @param userName
     * @param state
     * @return
     */
    PageInfo<Customer> queryCustomerByCondition(Integer page, Integer limit, String userName, Integer state);
}
