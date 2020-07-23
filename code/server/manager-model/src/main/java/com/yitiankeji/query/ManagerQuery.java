package com.yitiankeji.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ManagerQuery {

    private Integer pageSize = 10;
    private Integer page = 1;

    @ApiModelProperty(value = "管理员ID", notes = "管理员ID")
    private String managerId;
    @ApiModelProperty(value = "账号", notes = "账号")
    private String account;
    @ApiModelProperty(value = "密码", notes = "密码")
    private String password;
    @ApiModelProperty(value = "名称", notes = "名称")
    private String name;
    @ApiModelProperty(value = "头像", notes = "头像")
    private String avatar;
    @ApiModelProperty(value = "生日", notes = "生日")
    private String birthday;
    @ApiModelProperty(value = "性别", notes = "性别")
    private String sex;
    @ApiModelProperty(value = "邮箱", notes = "邮箱")
    private String email;
    @ApiModelProperty(value = "电话", notes = "电话")
    private String phone;
    @ApiModelProperty(value = "状态", notes = "状态")
    private String status;
    @ApiModelProperty(value = "创建时间", notes = "创建时间")
    private String createTime;
    @ApiModelProperty(value = "版本", notes = "版本")
    private String version;
}
