package com.qianfeng.openapi.web.master.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianfeng.openapi.web.master.mapper.AdminUserMapper;
import com.qianfeng.openapi.web.master.mapper.RoleMapper;
import com.qianfeng.openapi.web.master.pojo.AdminUser;
import com.qianfeng.openapi.web.master.pojo.Role;
import com.qianfeng.openapi.web.master.service.AdminUserService;
import com.qianfeng.openapi.web.master.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ZMQ
 * @Date 2020/9/8
 * @since 1.8
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private AdminUserMapper adminUserMapper;
    @Autowired
    private RoleMapper roleMapper;

    /**
     * 用户登录
     * @param email
     * @param password
     * @return AdminUser
     */
    @Override
    public AdminUser login(String email, String password) {
        AdminUser adminUser = adminUserMapper.queryAdminUserByEmail(email);
        if(adminUser == null || !adminUser.getPassword().equals(password)){
            return null;
        }
        return adminUser;
    }

    /**
     * 查询所有用户信息
     * @param page
     * @param limit
     * @return PageInfo<AdminUser>
     */
    @Override
    public PageInfo<AdminUser> queryAllUserInfo(Integer page, Integer limit) {
        PageHelper.startPage(page , limit);
        List<AdminUser> adminUsers = adminUserMapper.queryAllUserInfo();
        return new PageInfo<>(adminUsers);
    }

    /**
     * 添加用户信息
     * @param adminUser
     * @return int
     */
    @Override
    public int addAdminUser(AdminUser adminUser) {
        //添加用户角色关系
        int result = adminUserMapper.addAdminUser(adminUser);
        if(result > Constant.UPDATE_ADD_DELETE_FAILED_RESULT){
            return roleMapper.addAdminUserRole(adminUser.getId() , adminUser.getRole());
        }
        return Constant.UPDATE_ADD_DELETE_FAILED_RESULT;
    }

    /**
     * 通过id修改用户信息
     * @param adminUser
     * @return int
     */
    @Override
    public int updateAdminUserById(AdminUser adminUser) {
        //修改用户表信息
        int i = adminUserMapper.updateAdminUserById(adminUser);
        if (i > Constant.UPDATE_ADD_DELETE_FAILED_RESULT){
            //修改用户 角色关系表信息
            return adminUserMapper.updateAdminUserRoleRelation(adminUser.getId(),adminUser.getRole());
        }
        return 0;
    }

    /**
     * 删除选中的用户信息
     * @param ids
     * @return int
     */
    @Override
    public int deleteUserInfo(Integer[] ids) {
        return adminUserMapper.deleteUserInfo(ids);
    }

    /**
     * 查询所有角色信息
     * @return List<Role>
     */
    @Override
    public List<Role> queryRoleInfo() {
        return roleMapper.queryAllRoleInfo();
    }
}
