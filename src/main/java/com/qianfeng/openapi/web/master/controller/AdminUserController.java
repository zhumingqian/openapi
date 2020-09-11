package com.qianfeng.openapi.web.master.controller;

import com.github.pagehelper.PageInfo;
import com.qianfeng.openapi.web.master.bean.AjaxResponse;
import com.qianfeng.openapi.web.master.bean.TableData;
import com.qianfeng.openapi.web.master.pojo.AdminUser;
import com.qianfeng.openapi.web.master.pojo.Role;
import com.qianfeng.openapi.web.master.service.AdminUserService;
import com.qianfeng.openapi.web.master.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author ZMQ
 * @Date 2020/9/8
 * @since 1.8
 * 管理员用户登录Controller
 */
@RestController
@RequestMapping("/adminUser")
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;

    /**
     * 用户登录
     * @param email
     * @param password
     * @param session
     * @return AjaxResponse
     */
    @PostMapping("/login")
    public AjaxResponse login(String email , String password , HttpSession session){
        AdminUser adminUser = adminUserService.login(email , password);
        if(adminUser == null){
            return new AjaxResponse(false , "用户名或密码错误");
        }
        session.setAttribute(Constant.LOGIN_SESSION_USER, adminUser);
        return new AjaxResponse(true , "success");
    }

    /**
     * 退出
     * @param session
     * @return Boolean
     */
    @GetMapping("/exist")
    public Boolean exist(HttpSession session){
        session.removeAttribute(Constant.LOGIN_SESSION_USER);
        return true;
    }

    /**
     * 返回session中 的用户信息
     * @param session
     * @return AdminUser
     */
    @GetMapping("/getSession")
    public AdminUser getSessionAdminUser(HttpSession session){
        AdminUser adminUser = (AdminUser) session.getAttribute(Constant.LOGIN_SESSION_USER);
        return adminUser != null ? adminUser : null;
    }

    /**
     * 查询所有用户信息
     * @param page
     * @param limit
     * @return TableData
     */
    @GetMapping("/queryAllUserInfo")
    public TableData queryAllUserInfo(@RequestParam(defaultValue = "1") Integer page ,
                                      @RequestParam(defaultValue = "5") Integer limit){
        TableData<AdminUser> tableData = new TableData<>();
        PageInfo<AdminUser> pageInfo = adminUserService.queryAllUserInfo(page , limit);
        tableData.setCount(pageInfo.getTotal());
        tableData.setData(pageInfo.getList());
        return tableData;
    }

    /**
     * 添加用户
     * @param adminUser
     * @return AjaxResponse
     */
    @PostMapping("/add")
    public AjaxResponse addAdminUser(AdminUser adminUser){
        int result = adminUserService.addAdminUser(adminUser);
        return result > Constant.UPDATE_ADD_DELETE_FAILED_RESULT ? new AjaxResponse(true , "success") :
                new AjaxResponse(false , "failed");
    }

    /**
     * 修改用户信息
     * @param adminUser
     * @return AjaxResponse
     */
    @PostMapping("/update")
    public AjaxResponse updateAdminUserById(AdminUser adminUser){
        System.out.println(adminUser.getId());
        int result = adminUserService.updateAdminUserById(adminUser);
        return result > Constant.UPDATE_ADD_DELETE_FAILED_RESULT ? new AjaxResponse(true , "success") :
                new AjaxResponse(false , "failed");
    }

    /**
     * 删除选中的用户信息
     * @param ids
     * @return AjaxResponse
     */
    @PostMapping("/deleteUserInfo")
    public AjaxResponse deleteUserInfo(Integer[] ids){
        int result = adminUserService.deleteUserInfo(ids);
        return result > Constant.UPDATE_ADD_DELETE_FAILED_RESULT ? new AjaxResponse(true , "success") :
                new AjaxResponse(false , "failed");
    }

    /**
     * 查询所有角色
     * @return List<Role>
     */
    @GetMapping("/queryRole")
    public List<Role> queryRole(){
        List<Role> roleList = adminUserService.queryRoleInfo();
        return roleList;
    }

}
