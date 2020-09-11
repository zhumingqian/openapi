package com.qianfeng.openapi.web.master.mapper;

import com.qianfeng.openapi.web.master.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author ZMQ
 * @Date 2020/9/10
 * @since 1.8
 */
public interface RoleMapper {
    /**
     * 查询所有角色信息
     * @return List<Role>
     */
    List<Role> queryAllRoleInfo();

    /**
     * 添加角色信息
     * @param role
     * @return int
     */
    int addRoleInfo(Role role);

    /**
     * 通过id修改角色信息
     * @param role
     * @return int
     */
    int updateRoleInfoById(Role role);

    /**
     * 通过选中的id 来删除角色信息
     * @param ids
     * @return int
     */
    int deleteRoleInfoByIds(Long[] ids);

    /**
     * 用户角色关系表中添加用户角色信息
     * @param id
     * @param role
     * @return int
     */
    int addAdminUserRole(@Param("id") Integer id,@Param("role") Integer role);

    /**
     * 更新角色菜单信息
     * @param id
     * @param menuId
     * @return int
     */
    int updateRoleMenu(@Param("role_Id") Long id,@Param("menu_Id") Integer menuId);

    /**
     * 删除原始的角色菜单关系
     * @param id
     * @return int
     */
    int deleteOriginalRoleMenuRelation(Long id);

    /**
     * 查询当前用户数据条数
     * @param id
     * @return
     */
    int queryRoleMenuCount(Long id);
}
