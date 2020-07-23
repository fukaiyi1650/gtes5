package com.yitiankeji.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/** 分页类 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page<T> {

    /** 当前页面的记录 **/
    private List<T> records;
    /** 满足条件的总记录数 **/
    private Long total;
    /** 当前页 **/
    private Integer page;
    /** 页面记录数 **/
    private Integer pageSize;
}
