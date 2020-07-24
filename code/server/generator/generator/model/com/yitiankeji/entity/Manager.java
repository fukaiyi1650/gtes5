package com.yitiankeji.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.alibaba.excel.converters.integer.IntegerStringConverter;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 管理员
 * </p>
 *
 * @author yitiankeji
 * @since 2020-07-24
 */
@ContentRowHeight(20)
@HeadRowHeight(20)
@ColumnWidth(20)
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_manager")
public class Manager implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 管理员ID */
    @TableId(value = "manager_id", type = IdType.AUTO)
    private Integer managerId;

    /** 账号 */
    @TableField("account")
    private String account;

    /** 密码 */
    @TableField("password")
    private String password;

    /** 名称 */
    @TableField("name")
    private String name;

    /** 头像 */
    @TableField("avatar")
    private String avatar;

    /** 生日 */
    @TableField("birthday")
    private Date birthday;

    /** 性别 */
    @TableField("sex")
    private Integer sex;

    /** 邮箱 */
    @TableField("email")
    private String email;

    /** 电话 */
    @TableField("phone")
    private String phone;

    /** 状态 */
    @TableField("status")
    private Integer status;

    /** 创建时间 */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /** 版本 */
    @TableField("version")
    private Integer version;


}
