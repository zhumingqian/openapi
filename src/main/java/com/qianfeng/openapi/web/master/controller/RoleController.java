package com.qianfeng.openapi.web.master.controller;

import com.github.pagehelper.PageInfo;
import com.qianfeng.openapi.web.master.bean.AjaxResponse;
import com.qianfeng.openapi.web.master.bean.TableData;
import com.qianfeng.openapi.web.master.pojo.Menu;
import com.qianfeng.openapi.web.master.pojo.Role;
import com.qianfeng.openapi.web.master.service.RoleService;
import com.qianfeng.openapi.web.master.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @Author ZMQ
 * @Date 2020/9/10
 * @since 1.8
 */
@RestController
@RequestMapping("/sys/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 查询所有角色信息
     * @param page
     * @param limit
     * @return TableData
     */
    @GetMapping("/queryAllRoleInfo")
    public TableData queryAllRoleInfo(@RequestParam(defaultValue = "1") Integer page ,
                                      @RequestParam(defaultValue = "5") Integer limit){
        TableData<Role> tableData = new TableData<>();
        PageInfo<Role> pageInfo = roleService.queryAllRoleInfo(page , limit);
        tableData.setData(pageInfo.getList());
        tableData.setCount(pageInfo.getTotal());
        return tableData;
    }

    /**
     * 添加角色信息
     * @param role
     * @return AjaxResponse
     */
    @PostMapping("/add")
    public AjaxResponse addRoleInfo(Role role){
        int result = roleService.addRoleInfo(role);
        return result > Constant.UPDATE_ADD_DELETE_FAILED_RESULT ? new AjaxResponse(true , "success") :
                new AjaxResponse(false , "failed");
    }

    /**
     * 修改角色信息 通过id
     * @param role
     * @return AjaxResponse
     */
    @PostMapping("/update")
    public AjaxResponse updateRoleInfoById(Role role){
        int result = roleService.updateRoleInfoById(role);
        return result > Constant.UPDATE_ADD_DELETE_FAILED_RESULT ? new AjaxResponse(true , "success") :
                new AjaxResponse(false , "failed");
    }

    /**
     * 通过所选id删除角色
     * @param ids
     * @return AjaxResponse
     */
    @PostMapping("/deleteRoleInfo")
    public AjaxResponse deleteRoleInfoByIds(Long[] ids){
        int result = roleService.deleteRoleInfoByIds(ids);
        return result > Constant.UPDATE_ADD_DELETE_FAILED_RESULT ? new AjaxResponse(true , "success") :
                new AjaxResponse(false , "failed");
    }

    /**
     * 查询所有菜单信息
     * @return List<Menu>
     */
    @GetMapping("/queryRoleMenu")
    public List<Menu> queryRoleMenu(){
        List<Menu> menuList = roleService.queryRoleMenu();
        return menuList;
    }

    /**
     * 修改角色所拥有的菜单权限
     * @param id 修改的用户的主键ID
     * @param menuId 传递过来的新的菜单ID
     * @return AjaxResponse
     */
    @PostMapping("/updateRoleMenu")
    public AjaxResponse updateRoleMenuByIds(Long id , Integer[] menuId){
        int result = roleService.updateRoleMenuByIds(id , menuId);
        return result > Constant.UPDATE_ADD_DELETE_FAILED_RESULT ? new AjaxResponse(true , "success") :new AjaxResponse(false , "failed");
    }

}
