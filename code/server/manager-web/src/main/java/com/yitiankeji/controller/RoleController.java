package com.yitiankeji.controller;

import com.yitiankeji.api.RoleApi;
import com.yitiankeji.entity.Role;
import com.yitiankeji.query.RoleQuery;
import com.yitiankeji.response.Pagation;
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
 * 角色 服务调用外部接口
 * </p>
 *
 * @author yitiankeji
*/
@Controller
public class RoleController {

    @Autowired
    private RoleApi roleApi;

    @GetMapping("/role/list")
    public String list() {
        return "/role/list";
    }

    @GetMapping("/role/add")
    public String add() {
        return "/role/add";
    }

    @GetMapping("/role/edit")
    public String edit() {
        return "/role/edit";
    }

    @ResponseBody
    @PostMapping("/role/page")
    public Pagation page(RoleQuery query) {
        Page<Role> page = roleApi.page(query);
        Pagation pagation = new Pagation(page);
        pagation.setsEcho(query.getSEcho());
        return pagation;
    }

    @ResponseBody
    @GetMapping("/role/findById")
    public Role findById(@RequestParam Integer id) {
        return roleApi.findById(id);
    }

    @ResponseBody
    @PostMapping("/role/save")
    public ResponseData save(@RequestBody Role role) {
        return roleApi.save(role);
    }

    @ResponseBody
    @PostMapping("/role/update")
    public ResponseData update(@RequestBody Role role) {
        return roleApi.update(role);
    }

    @ResponseBody
    @PostMapping("/role/delete")
    public ResponseData delete(@RequestParam List<Integer> ids) {
    return roleApi.delete(ids);
    }

    @ResponseBody
    @GetMapping("/role/export")
    public void export(RoleQuery query, HttpServletResponse response) throws IOException {
        ResponseEntity responseEntity = roleApi.export(10);
        response.setContentType("application/vnd.ms-excel;charset=utf-8");

        HttpHeaders headers = responseEntity.getHeaders();
        response.addHeader("Content-Disposition", headers.getFirst("content-disposition"));

        byte[] body = (byte[]) responseEntity.getBody();
        response.getOutputStream().write(body);
    }
}
