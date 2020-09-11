package com.qianfeng.openapi.web.master.controller;

import com.github.pagehelper.PageInfo;
import com.qianfeng.openapi.web.master.bean.AjaxResponse;
import com.qianfeng.openapi.web.master.bean.TableData;
import com.qianfeng.openapi.web.master.pojo.Customer;
import com.qianfeng.openapi.web.master.pojo.RechargeInfo;
import com.qianfeng.openapi.web.master.service.AppInfoService;
import com.qianfeng.openapi.web.master.service.RechargeService;
import com.qianfeng.openapi.web.master.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author ZMQ
 * @Date 2020/9/10
 * @since 1.8
 */
@RestController
@RequestMapping("/sys/rechargeInfo")
public class RechargeController {
    @Autowired
    private RechargeService rechargeService;
    @Autowired
    private AppInfoService appInfoService;

    /**
     * 查询所有客户充值信息
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/queryAllRechargeInfo")
    public TableData queryAllRechargeInfo(@RequestParam(defaultValue = "1") Integer page ,
                                          @RequestParam(defaultValue = "5") Integer limit){
        TableData<RechargeInfo> tableData = new TableData<>();
        PageInfo<RechargeInfo> pageInfo = rechargeService.queryAllRechargeInfo(page , limit);
        tableData.setData(pageInfo.getList());
        tableData.setCount(pageInfo.getTotal());
        return tableData;
    }

    /**
     * 查询所有用户信息
     * @return
     */
    @GetMapping("/queryCustomer")
    public List<Customer> queryCustomer(){
        List<Customer> customerList = appInfoService.queryCustomer();
        return customerList;
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
    @PostMapping("/add")
    public AjaxResponse addRecharge(Long cusId,String createTime,String updateTime,Integer money,Integer state,Integer paymentType){
        int result = rechargeService.addRecharge(cusId,createTime,updateTime,money,state,paymentType);
        return result > Constant.UPDATE_ADD_DELETE_FAILED_RESULT ? new AjaxResponse(true , "success"):
                new AjaxResponse(false , "failed");
    }

    /**
     * 更新充值信息 通过ID
     * @param id
     * @param cusId
     * @param createTime
     * @param updateTime
     * @param money
     * @param state
     * @param paymentType
     * @return
     */
    @PostMapping("/update")
    public AjaxResponse updateRechargeInfoById(Long id,Long cusId,String createTime,String updateTime,Integer money,
                                               Integer state,Integer paymentType){
        int result = rechargeService.updateRecharge(id,cusId,createTime,updateTime,money,state,paymentType);
        return result > Constant.UPDATE_ADD_DELETE_FAILED_RESULT ? new AjaxResponse(true , "success"):
                new AjaxResponse(false , "failed");

    }

    /**
     * 通过id删除选中的充值信息
     * @param ids
     * @return
     */
    @PostMapping("/deleteRechargeInfo")
    public AjaxResponse deleteRechargeInfoByIds(Long[] ids){
        int result = rechargeService.deleteRechargeInfoByIds(ids);
        return result > Constant.UPDATE_ADD_DELETE_FAILED_RESULT ? new AjaxResponse(true , "success"):
                new AjaxResponse(false , "failed");
    }
}
