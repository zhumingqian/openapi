package com.qianfeng.openapi.web.master.mapper;

import com.qianfeng.openapi.web.master.pojo.SystemParamInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author ZMQ
 * @Date 2020/9/10
 * @since 1.8
 */
public interface SystemParamInfoMapper {
    /**
     * 查询所有系统参数信息
     * @return
     */
    List<SystemParamInfo> queryAllSysParamsInfo();

    /**
     * 添加系统参数信息
     * @param systemParamInfo
     * @return
     */
    int addSysParam(SystemParamInfo systemParamInfo);

    /**
     * 通过id修改系统参数信息
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
     *      通过参数名模糊查询 或 通过是否禁用状态查询
     *       也可同时满足两个条件查询
     * @param name
     * @param state
     * @return
     */
    List<SystemParamInfo> querySysParamsInfoByCondition(@Param("name") String name,@Param("state") Integer state);
}
