package com.yitiankeji.controller;

import com.yitiankeji.api.RoleMenuApi;
import com.yitiankeji.entity.RoleMenu;
import com.yitiankeji.query.RoleMenuQuery;
import com.yitiankeji.response.ResponseData;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 角色菜单 服务调用外部接口
 * </p>
 *
 * @author yitiankeji
 * @since 2020-07-24
*/
@Controller
public class RoleMenuController {

    @Autowired
    private RoleMenuApi roleMenuApi;

    @GetMapping("/roleMenu/list")
    public String list() {
        return "/roleMenu/list";
    }

    @GetMapping("/roleMenu/add")
    public String add() {
        return "/roleMenu/add";
    }

    @GetMapping("/roleMenu/edit")
    public String edit() {
        return "/roleMenu/edit";
    }

    @ResponseBody
    @PostMapping("/roleMenu/page")
    public Page<RoleMenu> page(@RequestBody RoleMenuQuery query) {
        return roleMenuApi.page(query);
    }

    @ResponseBody
    @GetMapping("/roleMenu/findById")
    public RoleMenu findById(@RequestParam Integer id) {
        return roleMenuApi.findById(id);
    }

    @ResponseBody
    @PostMapping("/roleMenu/save")
    public ResponseData save(@RequestBody RoleMenu roleMenu) {
        return roleMenuApi.save(roleMenu);
    }

    @ResponseBody
    @PostMapping("/roleMenu/update")
    public ResponseData update(@RequestBody RoleMenu roleMenu) {
        return roleMenuApi.update(roleMenu);
    }

    @ResponseBody
    @GetMapping("/roleMenu/delete")
    public ResponseData delete(@RequestParam List<Integer> id) {
    return roleMenuApi.delete(id);
    }

    @ResponseBody
    @GetMapping("/roleMenu/export")
    public void export(RoleMenuQuery query, HttpServletResponse response) throws IOException {
        ResponseEntity responseEntity = roleMenuApi.export(10);
        response.setContentType("application/vnd.ms-excel;charset=utf-8");

        HttpHeaders headers = responseEntity.getHeaders();
        response.addHeader("Content-Disposition", headers.getFirst("content-disposition"));

        byte[] body = (byte[]) responseEntity.getBody();
        response.getOutputStream().write(body);
    }
}
