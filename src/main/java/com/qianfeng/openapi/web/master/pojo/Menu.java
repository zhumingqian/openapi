package com.qianfeng.openapi.web.master.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ZMQ
 * @Date 2020/9/9
 * @since 1.8
 * 菜单实体类
 */
@Data
public class Menu {
  /**
   * 菜单ID
   */
  private Integer id;
  /**
   * 菜单名
   */
  private String name;
  /**
   * 父级菜单ID
   */
  private Integer parentId;
  /**
   * 菜单地址
   */
  private String url;
  /**
   * 图标
   */
  private String icon;
  /**
   *
   */
  private String perms;
  /**
   * 菜单类型
   */
  private long type;
  /**
   *
   */
  private long sort;
  /**
   * 存放二级菜单
   */
  private List<Menu> menuList = new ArrayList<>();

}
