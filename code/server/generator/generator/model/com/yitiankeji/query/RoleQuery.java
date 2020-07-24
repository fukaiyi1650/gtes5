package com.yitiankeji.query;

import lombok.Data;

@Data
public class RoleQuery {

    private Integer pageSize = 10;
    private Integer page = 1;

    private String roleId;
    private String name;
    private String sort;
    private String remark;
}
