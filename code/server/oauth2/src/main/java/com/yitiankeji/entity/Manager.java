package com.yitiankeji.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 管理员
 * </p>
 *
 * @author art
 * @since 2020-04-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "sys_manager", resultMap = "managerResultMap")
public class Manager implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 主键id */
    @TableId(value = "manager_id", type = IdType.AUTO)
    private Integer managerId;

    /** 头像 */
    @TableField("avatar")
    private String avatar;

    /** 账号 */
    @TableField("account")
    private String account;

    /** 密码 */
    @TableField("password")
    private String password;

    /** 盐 */
    @TableField("salt")
    private String salt;

    /** 姓名 */
    @TableField("name")
    private String name;

    /** 生日 */
    @TableField("birthday")
    private Date birthday;

    /** 性别 */
    @TableField("sex")
    private String sex;

    /** 邮箱 */
    @TableField("email")
    private String email;

    /** 电话 */
    @TableField("phone")
    private String phone;

    /** 状态(1：启用  2：未激活  3：冻结  4：删除） */
    @TableField("status")
    private Integer status;

    /** 创建时间 */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /** 乐观锁 */
    @TableField("version")
    private Integer version;

    private List<Role> roles;

}
