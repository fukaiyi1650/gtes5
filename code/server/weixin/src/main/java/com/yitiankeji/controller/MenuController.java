package com.yitiankeji.controller;

import com.yitiankeji.utils.WeixinTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {

    @Autowired
    private WeixinTool weixinTool;

    @GetMapping("/wx/menu/create")
    public String createMenu() {
        boolean result = weixinTool.createMenu();
        return result ? "创建菜单成功" : "创建菜单失败";
    }

    @GetMapping("/wx/menu/delete")
    public String deleteMenu() {
        boolean result = weixinTool.deleteMenu();
        return result ? "删除菜单成功" : "删除菜单失败";
    }
}
