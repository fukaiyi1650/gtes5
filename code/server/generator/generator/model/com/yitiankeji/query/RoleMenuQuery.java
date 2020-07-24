package com.yitiankeji.query;

import lombok.Data;

@Data
public class RoleMenuQuery {

    private Integer pageSize = 10;
    private Integer page = 1;

    private String roleMenuId;
    private String roleId;
    private String menuId;
}
