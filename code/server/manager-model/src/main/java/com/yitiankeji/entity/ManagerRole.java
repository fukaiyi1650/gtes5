package com.yitiankeji.entity;

import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 管理员角色
 * </p>
 *
 * @author yitiankeji
 * @since 2020-07-23
 */
@ContentRowHeight(20)
@HeadRowHeight(20)
@ColumnWidth(20)
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_manager_role")
public class ManagerRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 管理员角色ID */
    @TableId(value = "manager_role_id", type = IdType.AUTO)
    private Integer managerRoleId;

    /** 管理员ID */
    @TableField("manager_id")
    private Integer managerId;

    /** 角色ID */
    @TableField("role_id")
    private Integer roleId;


}
