package com.yitiankeji.query;

import lombok.Data;

@Data
public class RoleQuery extends BaseQuery {

    private String roleId;
    private String name;
    private String sort;
    private String remark;
}
