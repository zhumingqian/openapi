package com.qianfeng.openapi.web.master.controller;

import com.github.pagehelper.PageInfo;
import com.qianfeng.openapi.web.master.bean.AjaxResponse;
import com.qianfeng.openapi.web.master.bean.TableData;
import com.qianfeng.openapi.web.master.pojo.AppInfo;
import com.qianfeng.openapi.web.master.pojo.Customer;
import com.qianfeng.openapi.web.master.service.AppInfoService;
import com.qianfeng.openapi.web.master.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author ZMQ
 * @Date 2020/9/8
 * @since 1.8
 * 应用管理Controller
 */
@RestController
@RequestMapping("/sys/appInfo")
public class AppInfoController {
    @Autowired
    private AppInfoService appInfoService;

    /**
     * 查询所有应用信息
     *
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/queryAllAppInfo")
    public TableData queryAllAppInfo(@RequestParam(defaultValue = "1") Integer page
                                    , @RequestParam(defaultValue = "5") Integer limit) {
        PageInfo<AppInfo> pageInfo = appInfoService.queryAllAppInfo(page, limit);
        TableData<AppInfo> tableData = new TableData<>();
        tableData.setCount(pageInfo.getTotal());
        tableData.setData(pageInfo.getList());
        return tableData;
    }

    /**
     * 查询所有客户信息
     * @return
     */
    @GetMapping("/queryCustomer")
    public List<Customer> queryCustomer(){
        List<Customer> customerList = appInfoService.queryCustomer();
        return customerList;
    }

    /**
     * 添加应用信息
     * @param appInfo
     * @return
     */
    @PostMapping("/add")
    public AjaxResponse addAppInfo(AppInfo appInfo){
        int result = appInfoService.addAppInfo(appInfo);

        return result > Constant.UPDATE_ADD_DELETE_FAILED_RESULT ? new AjaxResponse(true,"success"):new AjaxResponse(false , "failed");
    }

    /**
     * 更新应用信息
     * @param appInfo
     * @return
     */
    @PostMapping("/update")
    public AjaxResponse updateAppInfo(AppInfo appInfo){
        int result = appInfoService.updateAppInfo(appInfo);
        return result > Constant.UPDATE_ADD_DELETE_FAILED_RESULT ? new AjaxResponse(true,"success"):new AjaxResponse(false , "failed");
    }

    /**
     * 删除应用信息
     * @param ids
     * @return
     */
    @PostMapping("/deleteAppInfo")
    public AjaxResponse deleteAppInfoByIds(Long[] ids){
        int result = appInfoService.deleteAppInfoByIds(ids);
        return result > Constant.UPDATE_ADD_DELETE_FAILED_RESULT ? new AjaxResponse(true,"success"):new AjaxResponse(false , "failed");
    }

    @GetMapping("/queryAppInfoByCondition")
    public TableData queryAppInfoByCondition(@RequestParam(defaultValue = "1") Integer page
                                            , @RequestParam(defaultValue = "5") Integer limit
                                            ,String appName
                                            ,Integer state){
        PageInfo<AppInfo> pageInfo = appInfoService.queryAppInfoByCondition(page , limit , appName , state);
        TableData<AppInfo> tableData = new TableData<>();
        tableData.setData(pageInfo.getList());
        tableData.setCount(pageInfo.getTotal());
        return tableData;
    }
}
