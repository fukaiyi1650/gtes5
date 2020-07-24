package com.yitiankeji.controller;

import com.yitiankeji.api.ManagerApi;
import com.yitiankeji.entity.Manager;
import com.yitiankeji.query.ManagerQuery;
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
 * 管理员 服务调用外部接口
 * </p>
 *
 * @author yitiankeji
 * @since 2020-07-24
*/
@Controller
public class ManagerController {

    @Autowired
    private ManagerApi managerApi;

    @GetMapping("/manager/list")
    public String list() {
        return "/manager/list";
    }

    @GetMapping("/manager/add")
    public String add() {
        return "/manager/add";
    }

    @GetMapping("/manager/edit")
    public String edit() {
        return "/manager/edit";
    }

    @ResponseBody
    @PostMapping("/manager/page")
    public Page<Manager> page(@RequestBody ManagerQuery query) {
        return managerApi.page(query);
    }

    @ResponseBody
    @GetMapping("/manager/findById")
    public Manager findById(@RequestParam Integer id) {
        return managerApi.findById(id);
    }

    @ResponseBody
    @PostMapping("/manager/save")
    public ResponseData save(@RequestBody Manager manager) {
        return managerApi.save(manager);
    }

    @ResponseBody
    @PostMapping("/manager/update")
    public ResponseData update(@RequestBody Manager manager) {
        return managerApi.update(manager);
    }

    @ResponseBody
    @GetMapping("/manager/delete")
    public ResponseData delete(@RequestParam List<Integer> id) {
    return managerApi.delete(id);
    }

    @ResponseBody
    @GetMapping("/manager/export")
    public void export(ManagerQuery query, HttpServletResponse response) throws IOException {
        ResponseEntity responseEntity = managerApi.export(10);
        response.setContentType("application/vnd.ms-excel;charset=utf-8");

        HttpHeaders headers = responseEntity.getHeaders();
        response.addHeader("Content-Disposition", headers.getFirst("content-disposition"));

        byte[] body = (byte[]) responseEntity.getBody();
        response.getOutputStream().write(body);
    }
}
