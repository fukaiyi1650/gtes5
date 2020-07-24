package com.yitiankeji.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.alibaba.excel.EasyExcel;
import com.yitiankeji.query.MenuQuery;
import com.yitiankeji.response.ResponseData;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yitiankeji.entity.Menu;
import com.yitiankeji.query.MenuQuery;
import com.yitiankeji.service.MenuService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * <p>
 * 菜单 前端控制器
 * </p>
 *
 * @author yitiankeji
 * @since 2020-07-24
 */
@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping("/menu/page")
    public IPage<Menu> page(@RequestBody MenuQuery query){
        Page<Menu> page= new Page<Menu>(query.getPage(), query.getPageSize());
        return menuService.page(page);
    }

    @PostMapping("/menu/list")
    public List<Menu> list(@RequestBody MenuQuery query){
        return menuService.list();
    }

    @GetMapping("/menu/findById")
    public Menu findById(@RequestParam Integer id) {
        return menuService.getById(id);
    }

    @PostMapping("/menu/save")
    public ResponseData save(@RequestBody Menu menu) {
        menuService.save(menu);
        return ResponseData.success(menu);
    }

    @PostMapping("/menu/update")
    public ResponseData update(@RequestBody Menu menu) {
        menuService.updateById(menu);
        return ResponseData.success(menu);
    }

    @GetMapping("/menu/delete")
    public ResponseData delete(@RequestParam List<Integer> id) {
        menuService.removeByIds(id);
        return ResponseData.success(id);
    }

    @ResponseBody
    @GetMapping("/menu/export")
    public void export(MenuQuery query, HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("菜单", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), Menu.class).sheet("菜单").doWrite(list(query));
    }
}
