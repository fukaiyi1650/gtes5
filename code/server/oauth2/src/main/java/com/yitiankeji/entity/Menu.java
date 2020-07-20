package com.yitiankeji.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 菜单
 * </p>
 *
 * @author art
 * @since 2020-04-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "sys_menu", resultMap = "menuResultMap")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 菜单id */
    @TableId(value = "menu_id", type = IdType.AUTO)
    private Integer menuId;

    /** 父菜单id(0代码顶级菜单) */
    @TableField("parent_id")
    private Integer parentId;

    /** 名称 */
    @TableField("name")
    private String name;

    /** 图标 */
    @TableField("icon")
    private String icon;

    /** 地址 */
    @TableField("url")
    private String url;

    /** 排序 */
    @TableField("sort")
    private Integer sort;

    /** 是否是菜单（1：是  0：不是） */
    @TableField("menu")
    private Boolean menu;

    /** 备注 */
    @TableField("remark")
    private String remark;

    /** 状态 :  1:启用   0:不启用 */
    @TableField("status")
    private Integer status;

    @TableField("remove")
    private Integer remove;


}
