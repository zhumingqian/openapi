package com.qianfeng.openapi.web.master.service;

import com.github.pagehelper.PageInfo;
import com.qianfeng.openapi.web.master.pojo.SystemParamInfo;

/**
 * @Author ZMQ
 * @Date 2020/9/10
 * @since 1.8
 */
public interface SystemParamInfoService {
    /**
     * 查询所有的系统参数信息
     * @param page
     * @param limit
     * @return
     */
    PageInfo<SystemParamInfo> queryAllSysParamsInfo(Integer page, Integer limit);

    /**
     * 添加系统参数信息
     * @param systemParamInfo
     * @return
     */
    int addSysParam(SystemParamInfo systemParamInfo);

    /**
     * 通过id需改系统参数信息
     * @param systemParamInfo
     * @return
     */
    int updateSysParamById(SystemParamInfo systemParamInfo);

    /**
     * 通过id删除选中的系统参数信息
     * @param ids
     * @return
     */
    int deleteSysParamsByIds(Long[] ids);

    /**
     * 根据条件查询系统参数信息
     * @param page
     * @param limit
     * @param name
     * @param state
     * @return
     */
    PageInfo<SystemParamInfo> querySysParamsInfoByCondition(Integer page, Integer limit, String name, Integer state);
}
