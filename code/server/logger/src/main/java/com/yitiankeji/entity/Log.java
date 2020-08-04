package com.yitiankeji.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@Document
public class Log {

    @Id
    private ObjectId _id;
    // 时间
    @Field
    private Date createTime;
    // 类名+方法名
    private String methodName;
    // 是否异常
    private boolean error;
    // 参数列表
    private String args;
    // 返回值
    private String result;
    // 异常信息
    private String exception;
}
