package com.yitiankeji.controller;

import com.yitiankeji.api.ManagerRoleApi;
import com.yitiankeji.entity.ManagerRole;
import com.yitiankeji.query.ManagerRoleQuery;
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
 * 管理员角色 服务调用外部接口
 * </p>
 *
 * @author yitiankeji
 * @since 2020-07-24
*/
@Controller
public class ManagerRoleController {

    @Autowired
    private ManagerRoleApi managerRoleApi;

    @GetMapping("/managerRole/list")
    public String list() {
        return "/managerRole/list";
    }

    @GetMapping("/managerRole/add")
    public String add() {
        return "/managerRole/add";
    }

    @GetMapping("/managerRole/edit")
    public String edit() {
        return "/managerRole/edit";
    }

    @ResponseBody
    @PostMapping("/managerRole/page")
    public Page<ManagerRole> page(@RequestBody ManagerRoleQuery query) {
        return managerRoleApi.page(query);
    }

    @ResponseBody
    @GetMapping("/managerRole/findById")
    public ManagerRole findById(@RequestParam Integer id) {
        return managerRoleApi.findById(id);
    }

    @ResponseBody
    @PostMapping("/managerRole/save")
    public ResponseData save(@RequestBody ManagerRole managerRole) {
        return managerRoleApi.save(managerRole);
    }

    @ResponseBody
    @PostMapping("/managerRole/update")
    public ResponseData update(@RequestBody ManagerRole managerRole) {
        return managerRoleApi.update(managerRole);
    }

    @ResponseBody
    @GetMapping("/managerRole/delete")
    public ResponseData delete(@RequestParam List<Integer> id) {
    return managerRoleApi.delete(id);
    }

    @ResponseBody
    @GetMapping("/managerRole/export")
    public void export(ManagerRoleQuery query, HttpServletResponse response) throws IOException {
        ResponseEntity responseEntity = managerRoleApi.export(10);
        response.setContentType("application/vnd.ms-excel;charset=utf-8");

        HttpHeaders headers = responseEntity.getHeaders();
        response.addHeader("Content-Disposition", headers.getFirst("content-disposition"));

        byte[] body = (byte[]) responseEntity.getBody();
        response.getOutputStream().write(body);
    }
}
