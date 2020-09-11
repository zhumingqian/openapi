package com.qianfeng.openapi.web.master.mapper;

import com.qianfeng.openapi.web.master.pojo.AppInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author ZMQ
 * @Date 2020/9/8
 * @since 1.8
 */
public interface AppInfoMapper {
    /**
     * 查询所有应用信息
     *
     * @return
     */
    List<AppInfo> queryAllAppInfo();

    /**
     * 添加应用信息
     * @param appInfo
     * @return
     */
    int addAppInfo(AppInfo appInfo);

    /**
     * 更新应用信息
     * @param appInfo
     * @return
     */
    int updateAppInfo(AppInfo appInfo);

    /**
     * 删除应用信息
     * @param ids
     * @return
     */
    int deleteAppInfoByIds(Long[] ids);

    /**
     * 根据条件查询应用信息
     * @param appName
     * @param state
     * @return
     */
    List<AppInfo> queryAppInfoByCondition(@Param("appName") String appName,@Param("state") Integer state);
}
