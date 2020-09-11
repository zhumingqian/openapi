package com.qianfeng.openapi.web.master.service;

import com.github.pagehelper.PageInfo;
import com.qianfeng.openapi.web.master.pojo.Menu;
import com.qianfeng.openapi.web.master.pojo.Role;

import java.util.List;

/**
 * @Author ZMQ
 * @Date 2020/9/10
 * @since 1.8
 */
public interface RoleService {
    /**
     * 查询所有角色信息
     * @param page
     * @param limit
     * @return PageInfo<Role>
     */
    PageInfo<Role> queryAllRoleInfo(Integer page, Integer limit);

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
     * 通过选中id删除角色信息
     * @param ids
     * @return int
     */
    int deleteRoleInfoByIds(Long[] ids);

    /**
     * 查询所有菜单数据
     * @return List<Menu>
     */
    List<Menu> queryRoleMenu();

    /**
     * 更新角色菜单权限信息
     * @param id 用户角色ID
     * @param menuId 菜单ID
     * @return int
     */
    int updateRoleMenuByIds(Long id, Integer[] menuId);
}
