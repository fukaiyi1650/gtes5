package com.yitiankeji.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MenuQuery {

    private Integer pageSize = 10;
    private Integer page = 1;

    @ApiModelProperty(value = "菜单ID", notes = "菜单ID")
    private String menuId;
    @ApiModelProperty(value = "父菜单ID", notes = "父菜单ID")
    private String parentId;
    @ApiModelProperty(value = "名称", notes = "名称")
    private String name;
    @ApiModelProperty(value = "图标", notes = "图标")
    private String icon;
    @ApiModelProperty(value = "URL", notes = "URL")
    private String url;
    @ApiModelProperty(value = "排序", notes = "排序")
    private String sort;
    @ApiModelProperty(value = "是否菜单", notes = "是否菜单")
    private String menu;
    @ApiModelProperty(value = "备注", notes = "备注")
    private String remark;
    @ApiModelProperty(value = "状态", notes = "状态")
    private String status;
    @ApiModelProperty(value = "删除", notes = "删除")
    private String remove;
}
