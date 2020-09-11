package com.qianfeng.openapi.web.master.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianfeng.openapi.web.master.mapper.CustomerMapper;
import com.qianfeng.openapi.web.master.pojo.Customer;
import com.qianfeng.openapi.web.master.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ZMQ
 * @Date 2020/9/7
 * @since 1.8
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 添加客户信息
     * @param customer
     * @return
     */
    @Override
    public int addCustomer(Customer customer) {
        return customerMapper.addCustomer(customer);
    }

    /**
     * 查询所有客户信息
     * @param page
     * @param limit
     * @return
     */
    @Override
    public PageInfo<Customer> queryAllCustomer(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<Customer> customerList = customerMapper.queryAllCustomer();
        return new PageInfo<>(customerList);
    }

    /**
     * 更新客户信息
     * @param customer
     * @return
     */
    @Override
    public int updateCustomerInfo(Customer customer) {
        return customerMapper.updateCustomerInfo(customer);
    }

    /**
     * 删除选中的客户信息
     * @param ids
     * @return
     */
    @Override
    public int deleteCustomersByIds(Long[] ids) {
        return customerMapper.deleteCustomersByIds(ids);
    }

    /**
     * 按条件模糊查询客户信息
     *
     * @param page
     * @param limit
     * @param userName
     * @param state
     * @return
     */
    @Override
    public PageInfo<Customer> queryCustomerByCondition(Integer page, Integer limit, String userName, Integer state) {
        PageHelper.startPage(page,limit);
        List<Customer> customerList = customerMapper.queryCustomerByCondition(userName , state);
        return new PageInfo<>(customerList);
    }
}
