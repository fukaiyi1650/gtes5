package com.yitiankeji.query;

import lombok.Data;

@Data
public class ManagerQuery {

    private Integer pageSize = 10;
    private Integer page = 1;

    private String managerId;
    private String account;
    private String password;
    private String name;
    private String avatar;
    private String birthday;
    private String sex;
    private String email;
    private String phone;
    private String status;
    private String createTime;
    private String version;
}
