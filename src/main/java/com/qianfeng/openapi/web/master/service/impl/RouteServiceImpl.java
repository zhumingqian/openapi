package com.qianfeng.openapi.web.master.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianfeng.openapi.web.master.mapper.RouteMapper;
import com.qianfeng.openapi.web.master.pojo.RouteInfo;
import com.qianfeng.openapi.web.master.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ZMQ
 * @Date 2020/9/9
 * @since 1.8
 */
@Service
public class RouteServiceImpl implements RouteService {
    @Autowired
    private RouteMapper routeMapper;

    /**
     * 查询所有路由信息
     * @param page
     * @param limit
     * @return
     */
    @Override
    public PageInfo<RouteInfo> queryAllRouteInfo(Integer page, Integer limit) {
        PageHelper.startPage(page , limit );
        List<RouteInfo> routeInfos = routeMapper.queryAllRouteInfo();
        return new PageInfo<>(routeInfos);
    }

    /**
     * 添加路由信息
     * @param routeInfo
     * @return
     */
    @Override
    public int addRouteInfo(RouteInfo routeInfo) {
        return routeMapper.addRouteInfo(routeInfo);
    }

    /**
     * 修改路由信息
     * @param routeInfo
     * @return
     */
    @Override
    public int updateRouteInfo(RouteInfo routeInfo) {
        return routeMapper.updateRouteInfo(routeInfo);
    }

    /**
     * 删除选中的路由信息
     * @param ids
     * @return
     */
    @Override
    public int deleteRouteInfoByIds(Long[] ids) {
        return routeMapper.deleteRouteInfoByIds(ids);
    }

    /**
     * 根据条件查询路由信息
     * @param page
     * @param limit
     * @param gatewayApiName
     * @param state
     * @return
     */
    @Override
    public PageInfo<RouteInfo> queryRouteInfoByCondition(Integer page, Integer limit, String gatewayApiName, Integer state) {
        PageHelper.startPage(page , limit );
        List<RouteInfo> routeInfos = routeMapper.queryRouteInfoByCondition(gatewayApiName , state);
        return new PageInfo<>(routeInfos);
    }
}
