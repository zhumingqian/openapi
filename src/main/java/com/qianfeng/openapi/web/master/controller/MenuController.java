package com.qianfeng.openapi.web.master.controller;

import com.github.pagehelper.PageInfo;
import com.qianfeng.openapi.web.master.bean.AjaxResponse;
import com.qianfeng.openapi.web.master.bean.TableData;
import com.qianfeng.openapi.web.master.pojo.AdminUser;
import com.qianfeng.openapi.web.master.pojo.Menu;
import com.qianfeng.openapi.web.master.service.MenuService;
import com.qianfeng.openapi.web.master.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author ZMQ
 * @Date 2020/9/9
 * @since 1.8
 */
@RestController
@RequestMapping("/sys/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 查询用户对应的菜单
     * @param session
     * @return
     */
    @GetMapping("/loadMenu")
    public AjaxResponse loadMenuByIdentity(HttpSession session){
        AdminUser adminUser = (AdminUser) session.getAttribute(Constant.LOGIN_SESSION_USER);
        if(adminUser != null){
            List<Menu> menuList = menuService.queryMenu(adminUser.getId());
            return new AjaxResponse(true , "success" , menuList);
        }
        return null;
    }

    /**
     * 查询所有菜单
     * @return
     */
    @GetMapping("/queryAllMenuInfo")
    public TableData queryAllMenuInfo(@RequestParam(defaultValue = "1") Integer page ,
                                      @RequestParam(defaultValue = "5")Integer limit){
        TableData<Menu> tableData = new TableData<>();
        PageInfo<Menu> pageInfo = menuService.queryAllMenus(page , limit);
        tableData.setCount(pageInfo.getTotal());
        tableData.setData(pageInfo.getList());
        return tableData;
    }

    /**
     * 查询所有菜单
     * @return
     */
    @GetMapping("/queryParentMenu")
    public List<Menu> queryParentMenu(){
        List<Menu> menuList = menuService.queryParentMenus();
        return menuList;
    }

    /**
     * 添加菜单
     * @param menu
     * @return
     */
    @PostMapping("/add")
    public AjaxResponse addMenu(Menu menu){
        int result = menuService.addMenu(menu);
        return result > Constant.UPDATE_ADD_DELETE_FAILED_RESULT ? new AjaxResponse(true , "success") :
                new AjaxResponse(false ,
                "failed");
    }

    /**
     * 更新菜单信息
     * @param menu
     * @return
     */
    @PostMapping("/update")
    public AjaxResponse updateMenuInfo(Menu menu){
        int result = menuService.updateMenu(menu);
        return result > Constant.UPDATE_ADD_DELETE_FAILED_RESULT ? new AjaxResponse(true , "success") :new AjaxResponse(false ,"failed");
    }

    /**
     * 删除选中的菜单信息
     * @param ids
     * @return
     */
    @PostMapping("/deleteMenuInfo")
    public AjaxResponse deleteMenuInfoByIds(Long[] ids){
        int result = menuService.deleteMenuInfoByIds(ids);
        return result > Constant.UPDATE_ADD_DELETE_FAILED_RESULT ? new AjaxResponse(true , "success") :new AjaxResponse(false ,"failed");
    }

}
