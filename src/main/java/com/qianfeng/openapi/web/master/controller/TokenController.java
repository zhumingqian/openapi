package com.qianfeng.openapi.web.master.controller;

import com.github.pagehelper.PageInfo;
import com.qianfeng.openapi.web.master.bean.AjaxResponse;
import com.qianfeng.openapi.web.master.bean.TableData;
import com.qianfeng.openapi.web.master.pojo.Customer;
import com.qianfeng.openapi.web.master.pojo.Token;
import com.qianfeng.openapi.web.master.service.AppInfoService;
import com.qianfeng.openapi.web.master.service.TokenService;
import com.qianfeng.openapi.web.master.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author ZMQ
 * @Date 2020/9/10
 * @since 1.8
 * Token管理Controller
 */
@RestController
@RequestMapping("/sys/token")
public class TokenController {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private AppInfoService appInfoService;

    /**
     * 查询所有token信息
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/queryAllInfo")
    public TableData queryAllTokenInfo(@RequestParam(defaultValue = "1") Integer page
                                        ,@RequestParam(defaultValue = "5")Integer limit){
        TableData<Token> tableData = new TableData<>();
        PageInfo<Token> pageInfo = tokenService.queryAllTokenInfo(page , limit);
        tableData.setCount(pageInfo.getTotal());
        tableData.setData(pageInfo.getList());
        return tableData;
    }

    /**
     * 查询所有客户信息
     * @return
     */
    @GetMapping("/queryCustomer")
    public List<Customer> queryCustomer(){
        List<Customer> customerList = appInfoService.queryCustomer();
        return customerList;
    }

    /**
     * 添加token信息
     * @param userId
     * @param accessToken
     * @param startTime
     * @param expireTime
     * @return
     */
    @PostMapping("/add")
    public AjaxResponse addTokenInfo(Long userId,String accessToken,String startTime,String expireTime){
        int result = tokenService.addTokenInfo(userId,accessToken,startTime,expireTime);
        return result > Constant.UPDATE_ADD_DELETE_FAILED_RESULT ? new AjaxResponse(true,"success"):new AjaxResponse(false , "failed");
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
    @PostMapping("/update")
    public AjaxResponse updateTokenInfoById(Long id,Long userId,String accessToken,String startTime,String expireTime){
        int result = tokenService.updateTokenInfo(id,userId,accessToken,startTime,expireTime);
        return result > Constant.UPDATE_ADD_DELETE_FAILED_RESULT ? new AjaxResponse(true,"success"):new AjaxResponse(false , "failed");
    }


    /**
     * 删除选中的token信息
     * @param ids
     * @return
     */
    @PostMapping("/delete")
    public AjaxResponse deleteTokenInfoByIds(Long[] ids){
        int result = tokenService.deleteTokenInfoByIds(ids);
        return result > Constant.UPDATE_ADD_DELETE_FAILED_RESULT ? new AjaxResponse(true,"success"):new AjaxResponse(false , "failed");
    }

    /**
     * 根据条件查询token信息
     * @param page
     * @param limit
     * @param accessToken
     * @return
     */
    @GetMapping("/queryTokenByCondition")
    public TableData queryTokenByCondition(@RequestParam(defaultValue = "1") Integer page
                                            ,@RequestParam(defaultValue = "5")Integer limit
                                            ,String accessToken){
        TableData<Token> tableData = new TableData<>();
        PageInfo<Token> pageInfo = tokenService.queryTokenByCondition(page , limit , accessToken);
        tableData.setCount(pageInfo.getTotal());
        tableData.setData(pageInfo.getList());
        return tableData;
    }
}
