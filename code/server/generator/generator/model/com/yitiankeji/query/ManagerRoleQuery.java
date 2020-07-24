package com.yitiankeji.query;

import lombok.Data;

@Data
public class ManagerRoleQuery {

    private Integer pageSize = 10;
    private Integer page = 1;

    private String managerRoleId;
    private String managerId;
    private String roleId;
}
