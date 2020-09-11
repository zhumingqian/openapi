package com.qianfeng.openapi.web.master.bean;

import lombok.Data;

import java.util.List;

/**
 * @Author ZMQ
 * @Date 2020/9/7
 * @since 1.8
 * 查询到前端layUi页面信息类
 */
@Data
public class TableData<T> {
    /**
     * LayUI返回代码
     */
    private Integer code = 0;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 返回查询数据总数
     */
    private Long count;
    /**
     * 返回数据集合
     */
    private List<T> data;
}
