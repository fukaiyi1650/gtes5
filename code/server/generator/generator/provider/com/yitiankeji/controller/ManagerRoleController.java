package com.yitiankeji.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.alibaba.excel.EasyExcel;
import com.yitiankeji.query.ManagerRoleQuery;
import com.yitiankeji.response.ResponseData;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yitiankeji.entity.ManagerRole;
import com.yitiankeji.query.ManagerRoleQuery;
import com.yitiankeji.service.ManagerRoleService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * <p>
 * 管理员角色 前端控制器
 * </p>
 *
 * @author yitiankeji
 */
@RestController
public class ManagerRoleController {

    @Autowired
    private ManagerRoleService managerRoleService;

    @PostMapping("/managerRole/page")
    public IPage<ManagerRole> page(@RequestBody ManagerRoleQuery query){
        Page<ManagerRole> page= new Page<ManagerRole>(query.getPage(), query.getPageSize());
        return managerRoleService.page(page);
    }

    @PostMapping("/managerRole/list")
    public List<ManagerRole> list(@RequestBody ManagerRoleQuery query){
        return managerRoleService.list();
    }

    @GetMapping("/managerRole/findById")
    public ManagerRole findById(@RequestParam Integer id) {
        return managerRoleService.getById(id);
    }

    @PostMapping("/managerRole/save")
    public ResponseData save(@RequestBody ManagerRole managerRole) {
        managerRoleService.save(managerRole);
        return ResponseData.success(managerRole);
    }

    @PostMapping("/managerRole/update")
    public ResponseData update(@RequestBody ManagerRole managerRole) {
        managerRoleService.updateById(managerRole);
        return ResponseData.success(managerRole);
    }

    @GetMapping("/managerRole/delete")
    public ResponseData delete(@RequestParam List<Integer> ids) {
        managerRoleService.removeByIds(ids);
        return ResponseData.success(ids);
    }

    @ResponseBody
    @GetMapping("/managerRole/export")
    public void export(ManagerRoleQuery query, HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("管理员角色", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), ManagerRole.class).sheet("管理员角色").doWrite(list(query));
    }
}
