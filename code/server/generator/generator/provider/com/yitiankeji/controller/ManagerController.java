package com.yitiankeji.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.alibaba.excel.EasyExcel;
import com.yitiankeji.query.ManagerQuery;
import com.yitiankeji.response.ResponseData;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yitiankeji.entity.Manager;
import com.yitiankeji.query.ManagerQuery;
import com.yitiankeji.service.ManagerService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * <p>
 * 管理员 前端控制器
 * </p>
 *
 * @author yitiankeji
 */
@RestController
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @PostMapping("/manager/page")
    public IPage<Manager> page(@RequestBody ManagerQuery query){
        Page<Manager> page= new Page<Manager>(query.getPage(), query.getPageSize());
        return managerService.page(page);
    }

    @PostMapping("/manager/list")
    public List<Manager> list(@RequestBody ManagerQuery query){
        return managerService.list();
    }

    @GetMapping("/manager/findById")
    public Manager findById(@RequestParam Integer id) {
        return managerService.getById(id);
    }

    @PostMapping("/manager/save")
    public ResponseData save(@RequestBody Manager manager) {
        managerService.save(manager);
        return ResponseData.success(manager);
    }

    @PostMapping("/manager/update")
    public ResponseData update(@RequestBody Manager manager) {
        managerService.updateById(manager);
        return ResponseData.success(manager);
    }

    @GetMapping("/manager/delete")
    public ResponseData delete(@RequestParam List<Integer> ids) {
        managerService.removeByIds(ids);
        return ResponseData.success(ids);
    }

    @ResponseBody
    @GetMapping("/manager/export")
    public void export(ManagerQuery query, HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("管理员", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), Manager.class).sheet("管理员").doWrite(list(query));
    }
}
