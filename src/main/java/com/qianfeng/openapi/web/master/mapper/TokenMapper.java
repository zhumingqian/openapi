package com.qianfeng.openapi.web.master.mapper;

import com.qianfeng.openapi.web.master.pojo.Token;

import java.util.List;

/**
 * @Author ZMQ
 * @Date 2020/9/10
 * @since 1.8
 */
public interface TokenMapper {
    /**
     * 查询所有token信息
     * @return
     */
    List<Token> queryAllTokenInfo();

    /**
     * 添加token信息
     * @param token
     * @return
     */
    int addTokenInfo(Token token);

    /**
     * 更新token信息  根据ID
     * @param token
     * @return
     */
    int updateTokenInfoById(Token token);

    /**
     * 删除选中的token
     * @param ids
     * @return
     */
    int deleteTokenInfoByIds(Long[] ids);

    /**
     * 根据条件查询token信息
     * @param accessToken
     * @return
     */
    List<Token> queryTokenByCondition(String accessToken);
}
