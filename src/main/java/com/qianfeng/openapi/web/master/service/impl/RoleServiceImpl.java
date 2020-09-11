package com.qianfeng.openapi.web.master.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianfeng.openapi.web.master.mapper.MenuMapper;
import com.qianfeng.openapi.web.master.mapper.RoleMapper;
import com.qianfeng.openapi.web.master.pojo.Menu;
import com.qianfeng.openapi.web.master.pojo.Role;
import com.qianfeng.openapi.web.master.service.RoleService;
import com.qianfeng.openapi.web.master.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ZMQ
 * @Date 2020/9/10
 * @since 1.8
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private MenuMapper menuMapper;

    /**
     * 查询所有角色信息
     * @param page
     * @param limit
     * @return  PageInfo<Role>
     */
    @Override
    public PageInfo<Role> queryAllRoleInfo(Integer page, Integer limit) {
        PageHelper.startPage(page , limit);
        List<Role> roleList = roleMapper.queryAllRoleInfo();
        return new PageInfo<>(roleList);
    }

    /**
     * 添加角色信息
     * @param role
     * @return int
     */
    @Override
    public int addRoleInfo(Role role) {
        return roleMapper.addRoleInfo(role);
    }

    /**
     * 通过id修改角色信息
     * @param role
     * @return int
     */
    @Override
    public int updateRoleInfoById(Role role) {
        return roleMapper.updateRoleInfoById(role);
    }

    /**
     * 通过选中id删除角色信息
     * @param ids
     * @return int
     */
    @Override
    public int deleteRoleInfoByIds(Long[] ids) {
        return roleMapper.deleteRoleInfoByIds(ids);
    }

    /**
     * 查询所有菜单信息
     * @return List<Menu>
     */
    @Override
    public List<Menu> queryRoleMenu() {
        List<Menu> menuList = menuMapper.queryAllMenus();
        return menuList;
    }

    /**
     * 更新用户菜单权限信息
     * @param id 用户角色ID
     * @param menuId 菜单ID
     * @return int
     */
    @Override
    public int updateRoleMenuByIds(Long id, Integer[] menuId) {
        //删除原来的菜单信息
        int result_1 = 0;
        int result_2 = 0;
        int count = roleMapper.queryRoleMenuCount(id);
        if(count > 0){
            result_2 = roleMapper.deleteOriginalRoleMenuRelation(id);
            if(result_2 > Constant.UPDATE_ADD_DELETE_FAILED_RESULT){
                for (Integer m : menuId) {
                    result_1 = roleMapper.updateRoleMenu(id , m);
                }
                return result_1;
            }
            return 0;
        }else {
            for (Integer m : menuId) {
                result_1 = roleMapper.updateRoleMenu(id , m);
            }
            return result_1;
        }
    }
}
