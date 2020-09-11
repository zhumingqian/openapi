package com.qianfeng.openapi.web.master.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianfeng.openapi.web.master.mapper.MenuMapper;
import com.qianfeng.openapi.web.master.pojo.Menu;
import com.qianfeng.openapi.web.master.service.MenuService;
import com.qianfeng.openapi.web.master.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ZMQ
 * @Date 2020/9/9
 * @since 1.8
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    /**
     * 查询登录用户拥有的菜单
     * @param id
     * @return List<Menu>
     */
    @Override
    public List<Menu> queryMenu(Integer id) {
        List<Menu> menuList = menuMapper.queryMenuByUserId(id);
        List<Menu> menus = operationMenu(menuList);
        return menus;
    }

    /**
     * 查询所有菜单
     * @return PageInfo<Menu>
     */
    @Override
    public PageInfo<Menu> queryAllMenus(Integer page , Integer limit) {
        PageHelper.startPage(page , limit);
        List<Menu> menuList = menuMapper.queryAllMenus();
        return new PageInfo<>(menuList);
    }

    /**
     * 查询所有非按钮菜单
     * @return List<Menu>
     */
    @Override
    public List<Menu> queryParentMenus() {
        return menuMapper.queryParentMenus();
    }

    /**
     * 添加菜单
     * @param menu
     * @return int
     */
    @Override
    public int addMenu(Menu menu) {
        //判断添加的菜单是多级菜单还是一级菜单
        //该菜单添加到已有的菜单下
        if(menu.getParentId() != null && menu.getType() != Constant.MENU_TYPE_BUTTON){
            //修改父级菜单类型为多级菜单
            int result_1 = menuMapper.updateMenuTypeById(menu.getParentId());
            if(result_1 > Constant.UPDATE_ADD_DELETE_FAILED_RESULT){
                //将新菜单添加
                return menuMapper.addMenu(menu);
            }
        }
        //新添加的菜单
        return menuMapper.addMenu(menu);
    }

    /**
     * 修改菜单信息
     * @param menu
     * @return int
     */
    @Override
    public int updateMenu(Menu menu) {
        return menuMapper.updateMenuById(menu);
    }

    /**
     * 删除选中的菜单
     * @param ids
     * @return int
     */
    @Override
    public int deleteMenuInfoByIds(Long[] ids) {
        //先找出需要删除的所有菜单
        List<Menu> menuList = menuMapper.queryMenuByIds(ids);
        for (Menu menu : menuList) {
            //查找该目录下的子级目录
            List<Menu> childenMenus = menuMapper.queryMenuByParentId(menu.getId());
            if(childenMenus.size() > 0){
                //存在子目录
                //如果该菜单下有子菜单则将该菜单下的子菜单释放
                int result_1 = menuMapper.releaseChildenMenu(menu.getParentId(),menu.getId());
                if(result_1 > Constant.UPDATE_ADD_DELETE_FAILED_RESULT){
                    //删除该父级菜单
                    int result_2 = menuMapper.deleteParentMenu(menu.getId());
                    return result_2;
                }
                return 0;
            }else{//没有子菜单
                int result_2 = menuMapper.deleteParentMenu(menu.getId());
                return result_2;
            }
        }
        return 0;
    }

    /**
     * 将包括按钮在内的菜单分级
     * @param menuList
     * @return
     */
//    @Override
//    public List<Menu> operationMenuIncludeButton(List<Menu> menuList) {
//        //存放父级菜单
//        List<Menu> parentMenus = new ArrayList<>();
//        //存放所有菜单 按钮
//        Map<Integer , Menu> menuMap = new HashMap<>();
//        //变量查询出的所有菜单信息
//        for (Menu menu : menuList) {
//            //遍历出来的菜单存到map中
//            menuMap.put(menu.getId(),menu);
//            if(menu.getParentId() == null){//是一级菜单
//                //存到父级菜单集合中
//                parentMenus.add(menu);
//            }
//        }
//        return null;
//    }

    /**
     * 将查询到的菜单分级
     * @param menuList
     * @return List<Menu>
     */
    public List<Menu> operationMenu(List<Menu> menuList) {
        //存放父级菜单
        List<Menu> menus = new ArrayList<>();
        //存放所有菜单
        //hashMap初始容量为 : 50  预期大小(expectedSize)/0.75 + 1
        Map<Integer , Menu> menuMap = new HashMap<>((int)(50/0.75)+1);
        for (Menu menu : menuList) {
            //将所有菜单存放到map集合中  菜单ID为key 菜单对象为value
            menuMap.put(menu.getId() , menu);
            //存一级菜单
            if(menu.getParentId() == null){
                //将以及菜单存放到集合中
                menus.add(menu);
            }
        }
        //将二级菜单加到上级菜单中
        for (Menu menu : menuList) {
            if(menu.getType() != Constant.MENU_TYPE_BUTTON){
                if((menu.getParentId() != null) && menuMap.containsKey(menu.getParentId())){
                    menuMap.get(menu.getParentId()).getMenuList().add(menu);
                }
            }
        }
        return menus;
    }
}
