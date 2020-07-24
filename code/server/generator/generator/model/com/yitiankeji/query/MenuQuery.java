package com.yitiankeji.query;

import lombok.Data;

@Data
public class MenuQuery {

    private Integer pageSize = 10;
    private Integer page = 1;

    private String menuId;
    private String parentId;
    private String name;
    private String icon;
    private String url;
    private String sort;
    private String menu;
    private String remark;
    private String status;
    private String remove;
}
