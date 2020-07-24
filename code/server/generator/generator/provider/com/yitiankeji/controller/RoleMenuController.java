package com.yitiankeji.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.alibaba.excel.EasyExcel;
import com.yitiankeji.query.RoleMenuQuery;
import com.yitiankeji.response.ResponseData;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yitiankeji.entity.RoleMenu;
import com.yitiankeji.query.RoleMenuQuery;
import com.yitiankeji.service.RoleMenuService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * <p>
 * 角色菜单 前端控制器
 * </p>
 *
 * @author yitiankeji
 */
@RestController
public class RoleMenuController {

    @Autowired
    private RoleMenuService roleMenuService;

    @PostMapping("/roleMenu/page")
    public IPage<RoleMenu> page(@RequestBody RoleMenuQuery query){
        Page<RoleMenu> page= new Page<RoleMenu>(query.getPage(), query.getPageSize());
        return roleMenuService.page(page);
    }

    @PostMapping("/roleMenu/list")
    public List<RoleMenu> list(@RequestBody RoleMenuQuery query){
        return roleMenuService.list();
    }

    @GetMapping("/roleMenu/findById")
    public RoleMenu findById(@RequestParam Integer id) {
        return roleMenuService.getById(id);
    }

    @PostMapping("/roleMenu/save")
    public ResponseData save(@RequestBody RoleMenu roleMenu) {
        roleMenuService.save(roleMenu);
        return ResponseData.success(roleMenu);
    }

    @PostMapping("/roleMenu/update")
    public ResponseData update(@RequestBody RoleMenu roleMenu) {
        roleMenuService.updateById(roleMenu);
        return ResponseData.success(roleMenu);
    }

    @GetMapping("/roleMenu/delete")
    public ResponseData delete(@RequestParam List<Integer> ids) {
        roleMenuService.removeByIds(ids);
        return ResponseData.success(ids);
    }

    @ResponseBody
    @GetMapping("/roleMenu/export")
    public void export(RoleMenuQuery query, HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("角色菜单", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), RoleMenu.class).sheet("角色菜单").doWrite(list(query));
    }
}
