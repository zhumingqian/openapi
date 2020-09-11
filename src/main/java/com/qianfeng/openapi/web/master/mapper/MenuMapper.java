package com.qianfeng.openapi.web.master.mapper;

import com.qianfeng.openapi.web.master.pojo.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author ZMQ
 * @Date 2020/9/9
 * @since 1.8
 */
public interface MenuMapper {
    /**
     * 通过用户id查询对应的菜单信息
     * @param id
     * @return List<Menu>
     */
    List<Menu> queryMenuByUserId(Integer id);

    /**
     * 查询所有菜单
     * @return List<Menu>
     */
    List<Menu> queryAllMenus();

    /**
     * 查询所有非按钮菜单
     * @return List<Menu>
     */
    List<Menu> queryParentMenus();

    /**
     * 通过id修改菜单信息
     * @param menu
     * @return int
     */
    int updateMenuById(Menu menu);

    /**
     * 添加菜单信息
     * @param menu
     * @return int
     */
    int addMenu(Menu menu);

    /**
     * 修改父类型菜单
     * @param parentId
     * @return int
     */
    int updateMenuTypeById(Integer parentId);

    /**
     * 通过id查询单个菜单
     * @param id
     * @return Menu
     */
    Menu querySingleMenuById(Integer id);



    /**
     * 通过ids查询出菜单
     * @param ids
     * @return List<Menu>
     */
    List<Menu> queryMenuByIds(Long[] ids);

    /**
     * 通过parentId查找其子级目录
     * @param parentId
     * @return List<Menu>
     */
    List<Menu> queryMenuByParentId(Integer parentId);

    /**
     * 释放要删除菜单下的子菜单
     * @param parentId 父级菜单ID
     * @param id 当前菜单ID
     * @return int
     */
    int releaseChildenMenu(@Param("parentId") Integer parentId,@Param("id") Integer id);

    /**
     * 通过id删除菜单
     * @param id
     * @return int
     */
    int deleteParentMenu(Integer id);
}
