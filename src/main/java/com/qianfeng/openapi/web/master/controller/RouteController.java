package com.qianfeng.openapi.web.master.controller;

import com.github.pagehelper.PageInfo;
import com.qianfeng.openapi.web.master.bean.AjaxResponse;
import com.qianfeng.openapi.web.master.bean.TableData;
import com.qianfeng.openapi.web.master.pojo.RouteInfo;
import com.qianfeng.openapi.web.master.service.RouteService;
import com.qianfeng.openapi.web.master.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author ZMQ
 * @Date 2020/9/9
 * @since 1.8
 * 路由管理Controller
 */
@RestController
@RequestMapping("/sys/routeInfo")
public class RouteController {
    @Autowired
    private RouteService routeService;

    /**
     * 查询所有路由信息
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/queryAllRouteInfo")
    public TableData queryAllRouteInfo(@RequestParam(defaultValue = "1")Integer page ,
                                       @RequestParam(defaultValue = "5")Integer limit){
        PageInfo<RouteInfo> pageInfo = routeService.queryAllRouteInfo(page , limit);
        TableData<RouteInfo> tableData = new TableData<>();
        tableData.setCount(pageInfo.getTotal());
        tableData.setData(pageInfo.getList());
        return tableData;
    }

    /**
     * 添加路由信息
     * @param routeInfo
     * @return
     */
    @PostMapping("/add")
    public AjaxResponse addRouteInfo(RouteInfo routeInfo){
        int result = routeService.addRouteInfo(routeInfo);
        return result > Constant.UPDATE_ADD_DELETE_FAILED_RESULT ? new AjaxResponse(true,"success"):new AjaxResponse(false , "failed");
    }

    /**
     * 修改路由信息
     * @param routeInfo
     * @return
     */
    @PostMapping("/update")
    public AjaxResponse updateRouteInfo(RouteInfo routeInfo){
        int result = routeService.updateRouteInfo(routeInfo);
        return result > Constant.UPDATE_ADD_DELETE_FAILED_RESULT ? new AjaxResponse(true,"success"):new AjaxResponse(false , "failed");
    }

    /**
     * 删除选中的路由信息
     * @param ids
     * @return
     */
    @PostMapping("/deleteRouteInfo")
    public AjaxResponse deleteRouteInfo(Long[] ids){
        int result = routeService.deleteRouteInfoByIds(ids);
        return result > Constant.UPDATE_ADD_DELETE_FAILED_RESULT ? new AjaxResponse(true,"success"):new AjaxResponse(false , "failed");
    }

    @GetMapping("/queryRouteInfoByCondition")
    public TableData queryRouteInfoByCondition(@RequestParam(defaultValue = "1")Integer page ,
                                               @RequestParam(defaultValue = "5")Integer limit
                                                ,String gatewayApiName
                                                ,Integer state){
        PageInfo<RouteInfo> pageInfo = routeService.queryRouteInfoByCondition(page , limit , gatewayApiName , state);
        TableData<RouteInfo> tableData = new TableData<>();
        tableData.setData(pageInfo.getList());
        tableData.setCount(pageInfo.getTotal());
        return tableData;
    }
}
