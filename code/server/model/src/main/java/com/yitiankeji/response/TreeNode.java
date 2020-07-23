package com.yitiankeji.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TreeNode {

    private Integer id;
    private String name;

    private List<TreeNode> children = new ArrayList<>();
}
