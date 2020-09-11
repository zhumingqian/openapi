package com.qianfeng.openapi.web.master.service;

import com.github.pagehelper.PageInfo;
import com.qianfeng.openapi.web.master.pojo.AdminUser;
import com.qianfeng.openapi.web.master.pojo.Role;

import java.util.List;

/**
 * @Author ZMQ
 * @Date 2020/9/8
 * @since 1.8
 */
public interface AdminUserService {
    /**
     * 登录
     * @param email
     * @param password
     * @return AdminUser
     */
    AdminUser login(String email, String password);

    /**
     * 查询所有用户信息
     * @param page
     * @param limit
     * @return int
     */
    PageInfo<AdminUser> queryAllUserInfo(Integer page, Integer limit);

    /**
     *添加用户信息
     * @param adminUser
     * @return int
     */
    int addAdminUser(AdminUser adminUser);

    /**
     * 通过id修改用户信息
     * @param adminUser
     * @return int
     */
    int updateAdminUserById(AdminUser adminUser);

    /**
     * 删除选中的用户信息
     * @param ids
     * @return int
     */
    int deleteUserInfo(Integer[] ids);

    /**
     * 查询所有角色信息
     * @return List<Role>
     */
    List<Role> queryRoleInfo();

}
