package com.qianfeng.openapi.web.master.service;

import com.github.pagehelper.PageInfo;
import com.qianfeng.openapi.web.master.pojo.Menu;

import java.util.List;

/**
 * @Author ZMQ
 * @Date 2020/9/9
 * @since 1.8
 */
public interface MenuService {
    /**
     * 查询用户对应的菜单
     * @param id
     * @return List<Menu>
     */
    List<Menu> queryMenu(Integer id);

    /**
     * 查询所有菜单
     * @param page 当前页
     * @param limit 每页显示条数
     * @return PageInfo<Menu>
     */
    PageInfo<Menu> queryAllMenus(Integer page , Integer limit);

    /**
     * 查询所有父级菜单  非按钮菜单
     * @return List<Menu>
     */
    List<Menu> queryParentMenus();

    /**
     * 添加菜单
     * @param menu
     * @return int
     */
    int addMenu(Menu menu);

    /**
     * 更新菜单信息
     * @param menu
     * @return int
     */
    int updateMenu(Menu menu);

    /**
     * 删除选中的菜单
     * @param ids
     * @return int
     */
    int deleteMenuInfoByIds(Long[] ids);

    /**
     * 将菜单分级 包括按钮
     * @param menuList
     * @return List<Menu>
     */
//    List<Menu> operationMenuIncludeButton(List<Menu> menuList);
}
