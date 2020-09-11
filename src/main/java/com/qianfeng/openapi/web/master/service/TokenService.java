package com.qianfeng.openapi.web.master.service;

import com.github.pagehelper.PageInfo;
import com.qianfeng.openapi.web.master.pojo.Token;

/**
 * @Author ZMQ
 * @Date 2020/9/10
 * @since 1.8
 */
public interface TokenService {
    /**
     * 查询所有token信息
     * @param page
     * @param limit
     * @return
     */
    PageInfo<Token> queryAllTokenInfo(Integer page, Integer limit);

    /**
     * 添加token信息
     * @param userId
     * @param accessToken
     * @param startTime
     * @param expireTime
     * @return
     */
    int addTokenInfo(Long userId,String accessToken,String startTime,String expireTime);

    /**
     * 更新token信息
     * @param id
     * @param userId
     * @param accessToken
     * @param startTime
     * @param expireTime
     * @return
     */
    int updateTokenInfo(Long id,Long userId,String accessToken,String startTime,String expireTime);

    /**
     * 删除选中token信息
     * @param ids
     * @return
     */
    int deleteTokenInfoByIds(Long[] ids);

    /**
     * 根据条件查询token信息
     * @param page
     * @param limit
     * @param accessToken
     * @return
     */
    PageInfo<Token> queryTokenByCondition(Integer page, Integer limit, String accessToken);
}
