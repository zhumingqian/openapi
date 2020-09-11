package com.qianfeng.openapi.web.master.mapper;

import com.qianfeng.openapi.web.master.pojo.RouteInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author ZMQ
 * @Date 2020/9/9
 * @since 1.8
 */
public interface RouteMapper {
    /**
     * 查询所有路由信息
     * @return
     */
    List<RouteInfo> queryAllRouteInfo();

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
     * 删除选中路由信息
     * @param ids
     * @return
     */
    int deleteRouteInfoByIds(Long[] ids);

    /**
     * 根据条件查询路由信息
     * @param gatewayApiName
     * @param state
     * @return
     */
    List<RouteInfo> queryRouteInfoByCondition(@Param("gatewayApiName") String gatewayApiName,
                                              @Param("state") Integer state);
}
