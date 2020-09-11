package com.qianfeng.openapi.web.master.controller;

import com.github.pagehelper.PageInfo;
import com.qianfeng.openapi.web.master.bean.AjaxResponse;
import com.qianfeng.openapi.web.master.bean.TableData;
import com.qianfeng.openapi.web.master.pojo.Customer;
import com.qianfeng.openapi.web.master.service.CustomerService;
import com.qianfeng.openapi.web.master.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author ZMQ
 * @Date 2020/9/7
 * @since 1.8
 * 客户管理Controller
 */
@RestController
@RequestMapping("/sys/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * 查询所有客户信息
     *
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/queryAllCustomer")
    public TableData queryAllCustomer(@RequestParam(defaultValue = "1") Integer page,
                                      @RequestParam(defaultValue = "5") Integer limit) {
        //分页查询数据
        PageInfo<Customer> pageInfo = customerService.queryAllCustomer(page, limit);
        //创建对象
        TableData<Customer> customerTableData = new TableData<>();
        //赋值
        customerTableData.setCount(pageInfo.getTotal());
        customerTableData.setData(pageInfo.getList());
        //返回json
        return customerTableData;
    }

    /**
     * 添加客户信息
     *
     * @param customer
     * @return
     */
    @PostMapping("/add")
    public AjaxResponse addCustomer(Customer customer) {
        int result = customerService.addCustomer(customer);
        return result > Constant.UPDATE_ADD_DELETE_FAILED_RESULT ? new AjaxResponse(true,"success"):new AjaxResponse(false , "failed");
    }

    /**
     * 通过客户id更新信息
     *
     * @param customer
     * @return
     */
    @PostMapping("/update")
    public AjaxResponse updateCustomerInfo(Customer customer) {
        int result = customerService.updateCustomerInfo(customer);
        return result > Constant.UPDATE_ADD_DELETE_FAILED_RESULT ? new AjaxResponse(true,"success"):new AjaxResponse(false , "failed");
    }

    /**
     * 删除选中的客户信息
     *
     * @param ids
     * @return
     */
    @PostMapping("/deleteCustomer")
    public AjaxResponse deleteCustomersById(Long[] ids) {
        int result = customerService.deleteCustomersByIds(ids);
        return result > Constant.UPDATE_ADD_DELETE_FAILED_RESULT ? new AjaxResponse(true,"success"):new AjaxResponse(false , "failed");
    }

    /**
     * 根据条件查询客户信息
     * @param page
     * @param limit
     * @param userName
     * @param state
     * @return
     */
    @GetMapping("/queryCustomerByCondition")
    public TableData queryCustomerByCondition(@RequestParam(defaultValue = "1") Integer page
                                                , @RequestParam(defaultValue = "5") Integer limit
                                                , String userName
                                                , Integer state) {
        PageInfo<Customer> pageInfo = customerService.queryCustomerByCondition(page, limit, userName, state);
        TableData<Customer> tableData = new TableData<>();
        tableData.setData(pageInfo.getList());
        tableData.setCount(pageInfo.getTotal());
        return tableData;
    }


}
