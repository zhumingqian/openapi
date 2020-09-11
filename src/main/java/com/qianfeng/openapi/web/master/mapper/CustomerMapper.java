package com.qianfeng.openapi.web.master.mapper;

import com.qianfeng.openapi.web.master.pojo.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author ZMQ
 * @Date 2020/9/7
 * @since 1.8
 */
public interface CustomerMapper {
    /**
     * 添加客户信息
     * @param customer
     * @return
     */
    int addCustomer(Customer customer);

    /**
     * 查询所有客户信息
     * @return
     */
    List<Customer> queryAllCustomer();

    /**
     * 修改客户信息
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
     * 根据条件模糊查询客户信息
     * @param userName
     * @param state
     * @return
     */
    List<Customer> queryCustomerByCondition(@Param("userName") String userName, @Param("state") Integer state);

    /**
     * 根据客户id查询客户信息
     * @param cusId
     * @return
     */
    Customer queryCustomerById(Integer cusId);
}
