package com.qianfeng.openapi.web.master.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianfeng.openapi.web.master.mapper.SystemParamInfoMapper;
import com.qianfeng.openapi.web.master.pojo.SystemParamInfo;
import com.qianfeng.openapi.web.master.service.SystemParamInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ZMQ
 * @Date 2020/9/10
 * @since 1.8
 */
@Service
public class SystemParamInfoServiceImpl implements SystemParamInfoService {
    @Autowired
    private SystemParamInfoMapper systemParamInfoMapper;

    /**
     * 查询所有的系统参数信息
     * @param page
     * @param limit
     * @return
     */
    @Override
    public PageInfo<SystemParamInfo> queryAllSysParamsInfo(Integer page, Integer limit) {
        PageHelper.startPage(page , limit);
        List<SystemParamInfo> systemParamInfos = systemParamInfoMapper.queryAllSysParamsInfo();
        return new PageInfo<>(systemParamInfos);
    }

    /**
     * 添加系统参数信息
     * @param systemParamInfo
     * @return
     */
    @Override
    public int addSysParam(SystemParamInfo systemParamInfo) {
        return systemParamInfoMapper.addSysParam(systemParamInfo);
    }

    /**
     * 通过id修改信息参数信息
     * @param systemParamInfo
     * @return
     */
    @Override
    public int updateSysParamById(SystemParamInfo systemParamInfo) {
        return systemParamInfoMapper.updateSysParamById(systemParamInfo);
    }

    /**
     * 通过id删除选中的系统参数信息
     * @param ids
     * @return
     */
    @Override
    public int deleteSysParamsByIds(Long[] ids) {
        return systemParamInfoMapper.deleteSysParamsByIds(ids);
    }

    /**
     * 根据条件查询系统参数信息
     * @param page
     * @param limit
     * @param name
     * @param state
     * @return
     */
    @Override
    public PageInfo<SystemParamInfo> querySysParamsInfoByCondition(Integer page, Integer limit, String name, Integer state) {
        PageHelper.startPage(page , limit);
        List<SystemParamInfo> paramInfos = systemParamInfoMapper.querySysParamsInfoByCondition(name , state);
        return new PageInfo<>(paramInfos);
    }
}
