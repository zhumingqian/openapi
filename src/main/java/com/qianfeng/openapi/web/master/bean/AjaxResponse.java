package com.qianfeng.openapi.web.master.bean;

import lombok.Data;

/**
 * @Author ZMQ
 * @Date 2020/9/7
 * @since 1.8
 * LayUi中Ajax请求相应结果
 */
@Data
public class AjaxResponse {
    /**
     * 响应状态
     */
    private Boolean status;
    /**
     * 响应信息
     */
    private String message;
    /**
     * 返回对象信息
     */
    private Object obj;

    /**
     * 返回用户对象信息
     */
    private Object obj2;

    public AjaxResponse() {
    }

    public AjaxResponse(Boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public AjaxResponse(Boolean status, String message, Object obj) {
        this.status = status;
        this.message = message;
        this.obj = obj;
    }

    public AjaxResponse(Boolean status, String message, Object obj, Object obj2) {
        this.status = status;
        this.message = message;
        this.obj = obj;
        this.obj2 = obj2;
    }
}
