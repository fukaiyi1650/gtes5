package com.yitiankeji.entity;

import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
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
 * @author yitiankeji
 * @since 2020-07-23
 */
@ContentRowHeight(20)
@HeadRowHeight(20)
@ColumnWidth(20)
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_menu")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 菜单ID */
    @TableId(value = "menu_id", type = IdType.AUTO)
    private Integer menuId;

    /** 父菜单ID */
    @TableField("parent_id")
    private Integer parentId;

    /** 名称 */
    @TableField("name")
    private String name;

    /** 图标 */
    @TableField("icon")
    private String icon;

    /** URL */
    @TableField("url")
    private String url;

    /** 排序 */
    @TableField("sort")
    private Integer sort;

    /** 是否菜单 */
    @TableField("menu")
    private Boolean menu;

    /** 备注 */
    @TableField("remark")
    private String remark;

    /** 状态 */
    @TableField("status")
    private Integer status;

    /** 删除 */
    @TableField("remove")
    private Boolean remove;


}
