package com.qianfeng.openapi.web.master.service;

import com.github.pagehelper.PageInfo;
import com.qianfeng.openapi.web.master.pojo.RouteInfo;

/**
 * @Author ZMQ
 * @Date 2020/9/9
 * @since 1.8
 */
public interface RouteService {
    /**
     * 查询所有路由信息
     * @param page
     * @param limit
     * @return
     */
    PageInfo<RouteInfo> queryAllRouteInfo(Integer page, Integer limit);

    /**
     * 添加路由信息
     * @param routeInfo
     * @return
     */
    int addRouteInfo(RouteInfo routeInfo);

    /**
     * 修改路由信息
     * @param routeInfo
     * @return
     */
    int updateRouteInfo(RouteInfo routeInfo);

    /**
     * 删除选中的路由信息
     * @param ids
     * @return
     */
    int deleteRouteInfoByIds(Long[] ids);

    /**
     * 根据条件查询路由信息
     * @param page
     * @param limit
     * @param gatewayApiName
     * @param state
     * @return
     */
    PageInfo<RouteInfo> queryRouteInfoByCondition(Integer page, Integer limit, String gatewayApiName, Integer state);
}
