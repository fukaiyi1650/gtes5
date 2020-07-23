package com.yitiankeji.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.alibaba.excel.EasyExcel;
import com.yitiankeji.query.RoleQuery;
import com.yitiankeji.response.ResponseData;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yitiankeji.entity.Role;
import com.yitiankeji.query.RoleQuery;
import com.yitiankeji.service.RoleService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * <p>
 * 角色 前端控制器
 * </p>
 *
 * @author yitiankeji
 * @since 2020-07-23
 */
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/role/page")
    public IPage<Role> page(@RequestBody RoleQuery query){
        Page<Role> page= new Page<Role>(query.getPage(), query.getPageSize());
        return roleService.page(page);
    }

    @RequestMapping("/role/list")
    public List<Role> list(@RequestBody RoleQuery query){
        return roleService.list();
    }

    @RequestMapping("/role/findById")
    public Role findById(@RequestParam Integer id) {
        return roleService.getById(id);
    }

    @RequestMapping("/role/save")
    public ResponseData save(@RequestBody Role role) {
        roleService.save(role);
        return ResponseData.success(role);
    }

    @RequestMapping("/role/update")
    public ResponseData update(@RequestBody Role role) {
        roleService.updateById(role);
        return ResponseData.success(role);
    }

    @RequestMapping("/role/delete")
    public ResponseData delete(@RequestParam List<Integer> id) {
        roleService.removeByIds(id);
        return ResponseData.success(id);
    }

    @ResponseBody
    @RequestMapping("/role/export")
    public void export(RoleQuery query, HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("角色", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), Role.class).sheet("角色").doWrite(list(query));
    }
}
