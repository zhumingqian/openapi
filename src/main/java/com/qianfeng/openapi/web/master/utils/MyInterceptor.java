package com.qianfeng.openapi.web.master.utils;

import com.qianfeng.openapi.web.master.pojo.AdminUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author ZMQ
 * @Date 2020/9/9
 * @since 1.8
 * 自定义拦截器   拦截未登录情况下访问其他页面
 */
public class MyInterceptor implements HandlerInterceptor {
    /**
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取session中的用户信息
        AdminUser adminUser = (AdminUser) request.getSession().getAttribute(Constant.LOGIN_SESSION_USER);
        //判断访问路劲是否符合条件
        if(adminUser == null && !request.getRequestURI().endsWith(Constant.INTERCEPTOR_URL)){
            response.sendRedirect("logins.html");
            return false;
        }
        return true;
    }

    /**
     * 控制层处理后触发
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println(111);
    }

    /**
     * 渲染视图后触发
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println(222);
    }
}
