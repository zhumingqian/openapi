package com.qianfeng.openapi.web.master.mapper;

import com.qianfeng.openapi.web.master.pojo.AdminUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author ZMQ
 * @Date 2020/9/8
 * @since 1.8
 */
public interface AdminUserMapper {
    /**
     * 根据邮箱号查询用户信息
     * @param email
     * @return AdminUser
     */
    AdminUser queryAdminUserByEmail(String email);

    /**
     * 查询所有用户信息
     * @return List<AdminUser>
     */
    List<AdminUser> queryAllUserInfo();

    /**
     * 添加用户信息
     * @param adminUser
     * @return int
     */
    int addAdminUser(AdminUser adminUser);

    /**
     * 更新用户信息 根据ID
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
     * 修改用户  角色关系表
     * @param id
     * @param role
     * @return
     */
    int updateAdminUserRoleRelation(@Param("userId") Integer id,@Param("role") Integer role);
}
