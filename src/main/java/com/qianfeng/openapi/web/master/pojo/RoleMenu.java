package com.qianfeng.openapi.web.master.pojo;

import lombok.Data;

/**
 * @Author ZMQ
 * @Date 2020/9/11
 * @since 1.8
 * 角色和菜单实体类
 */
@Data
public class RoleMenu {
    /**
     * 角色主键
     */
    private Long role_Id;
    /**
     * 菜单主键
     */
    private Long menu_Id;
}
