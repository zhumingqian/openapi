package com.qianfeng.openapi.web.master.utils;

/**
 * @Author ZMQ
 * @Date 2020/9/9
 * @since 1.8
 * 常量类
 */
public class Constant {
    /**
     * session存储的登录用户key值
     */
    public static final String LOGIN_SESSION_USER = "adminUser";
    /**
     * 拦截器拦截路径
     */
    public static final String INTERCEPTOR_URL = "logins.html";

    /**
     * 更新操作返回失败结果
     */
    public static final int UPDATE_ADD_DELETE_FAILED_RESULT = 0;

    /**
     * 菜单类型
     */
    public static final int MENU_TYPE_BUTTON = 2;
    /**
     * 菜单类型  单级菜单
     */
    public static final int MENU_TYPE_SINGLE_MENU = 1;
    /**
     * 菜单类型  多级菜单
     */
    public static final int MENU_TYPE_MULTILEVEL_MENU = 0;
}
