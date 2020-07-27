package com.yitiankeji.dto;

import lombok.Data;

import java.util.List;

@Data
public class ManagerRoleDto {

    private Integer managerId;
    private List<Integer> roleIds;
}
