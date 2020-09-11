package com.qianfeng.openapi.web.master.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianfeng.openapi.web.master.mapper.TokenMapper;
import com.qianfeng.openapi.web.master.pojo.Token;
import com.qianfeng.openapi.web.master.service.TokenService;
import com.qianfeng.openapi.web.master.utils.DateExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

/**
 * @Author ZMQ
 * @Date 2020/9/10
 * @since 1.8
 */
@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    private TokenMapper tokenMapper;

    /**
     * 查询所有token信息
     * @param page
     * @param limit
     * @return
     */
    @Override
    public PageInfo<Token> queryAllTokenInfo(Integer page, Integer limit) {
        PageHelper.startPage(page , limit);
        List<Token> tokenList = tokenMapper.queryAllTokenInfo();
        return new PageInfo<>(tokenList);
    }

    /**
     * 添加token信息
     * @param userId
     * @param accessToken
     * @param startTime
     * @param expireTime
     * @return
     */
    @Override
    public int addTokenInfo(Long userId, String accessToken, String startTime, String expireTime) {
        Token token = Token.getToken();
        token.setUserId(userId);
        token.setAccessToken(accessToken);
        try {
            token.setStartTime(DateExchange.strToUtilDate(startTime));
            token.setExpireTime(DateExchange.strToUtilDate(expireTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return tokenMapper.addTokenInfo(token);
    }

    /**
     * 更新token信息
     * @param id
     * @param userId
     * @param accessToken
     * @param startTime
     * @param expireTime
     * @return
     */
    @Override
    public int updateTokenInfo(Long id, Long userId, String accessToken, String startTime, String expireTime) {
        Token token = Token.getToken();
        token.setId(id);
        token.setUserId(userId);
        token.setAccessToken(accessToken);
        try {
            token.setStartTime(DateExchange.strToUtilDate(startTime));
            token.setExpireTime(DateExchange.strToUtilDate(expireTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return tokenMapper.updateTokenInfoById(token);
    }

    /**
     * 删除选中的token信息
     * @param ids
     * @return
     */
    @Override
    public int deleteTokenInfoByIds(Long[] ids) {
        return tokenMapper.deleteTokenInfoByIds(ids);
    }

    /**
     * 根据条件查询token信息
     * @param page
     * @param limit
     * @param accessToken
     * @return
     */
    @Override
    public PageInfo<Token> queryTokenByCondition(Integer page, Integer limit, String accessToken) {
        PageHelper.startPage(page , limit);
        List<Token> tokenList = tokenMapper.queryTokenByCondition(accessToken);
        return new PageInfo<>(tokenList);
    }
}
