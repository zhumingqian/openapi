package com.qianfeng.openapi.web.master.controller;

import com.github.pagehelper.PageInfo;
import com.qianfeng.openapi.web.master.bean.AjaxResponse;
import com.qianfeng.openapi.web.master.bean.TableData;
import com.qianfeng.openapi.web.master.pojo.SystemParamInfo;
import com.qianfeng.openapi.web.master.service.SystemParamInfoService;
import com.qianfeng.openapi.web.master.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author ZMQ
 * @Date 2020/9/10
 * @since 1.8
 * 系统参数Controller
 */
@RestController
@RequestMapping("/sys/sysParamsInfo")
public class SystemParamInfoController {
    @Autowired
    private SystemParamInfoService systemParamInfoService;

    /**
     * 查询所有系统参数信息
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/queryAllSysParamsInfo")
    public TableData queryAllSysParamsInfo(@RequestParam(defaultValue = "1") Integer page,
                                           @RequestParam(defaultValue = "5") Integer limit){
        TableData<SystemParamInfo> tableData = new TableData<>();
        PageInfo<SystemParamInfo> pageInfo = systemParamInfoService.queryAllSysParamsInfo(page , limit);
        tableData.setData(pageInfo.getList());
        tableData.setCount(pageInfo.getTotal());
        return tableData;
    }

    /**
     * 添加系统参数信息
     * @param systemParamInfo
     * @return
     */
    @PostMapping("/add")
    public AjaxResponse addSysParam(SystemParamInfo systemParamInfo){
        int result = systemParamInfoService.addSysParam(systemParamInfo);
        return result > Constant.UPDATE_ADD_DELETE_FAILED_RESULT ? new AjaxResponse(true,"success"):new AjaxResponse(false , "failed");
    }

    /**
     * 通过id修改系统参数信息
     * @param systemParamInfo
     * @return
     */
    @PostMapping("/update")
    public AjaxResponse updateSysParamById(SystemParamInfo systemParamInfo){
        int result = systemParamInfoService.updateSysParamById(systemParamInfo);
        return result > Constant.UPDATE_ADD_DELETE_FAILED_RESULT ? new AjaxResponse(true , "success") : new AjaxResponse(false , "failed");
    }

    /**
     * 通过id删除选中的系统参数信息
     * @param ids
     * @return
     */
    @PostMapping("/deleteSysParamsInfo")
    public AjaxResponse deleteSysParamsByIds(Long[] ids){
        int result = systemParamInfoService.deleteSysParamsByIds(ids);
        return result > Constant.UPDATE_ADD_DELETE_FAILED_RESULT ? new AjaxResponse(true , "success") :
                new AjaxResponse(false , "failed");
    }

    /**
     * 根据条件查询系统参数信息
     * @param page
     * @param limit
     * @param name
     * @param state
     * @return
     */
    @GetMapping("/querySysParamsInfoByCondition")
    public TableData querySysParamsInfoByCondition(@RequestParam(defaultValue = "1") Integer page
                                                    , @RequestParam(defaultValue = "5") Integer limit
                                                    , String name
                                                    , Integer state){
        TableData<SystemParamInfo> tableData = new TableData<>();
        PageInfo<SystemParamInfo> pageInfo = systemParamInfoService.querySysParamsInfoByCondition(page , limit ,
                name , state);
        tableData.setCount(pageInfo.getTotal());
        tableData.setData(pageInfo.getList());
        return tableData;
    }

}
