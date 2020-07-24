package com.yitiankeji.query;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BaseQuery {

    private Integer sEcho = 1;
    private Integer iDisplayStart = 0;
    private Integer iDisplayLength = 10;

    private List<Integer> iSortCol = new ArrayList<>();
    private List<String> sSortDir = new ArrayList<>();
}