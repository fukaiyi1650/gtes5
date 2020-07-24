package com.yitiankeji.query;

import lombok.Data;

@Data
public class ManagerRoleQuery extends BaseQuery {

    private String managerRoleId;
    private String managerId;
    private String roleId;
}
