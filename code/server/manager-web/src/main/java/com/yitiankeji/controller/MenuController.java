package com.yitiankeji.controller;

import com.yitiankeji.api.MenuApi;
import com.yitiankeji.entity.Menu;
import com.yitiankeji.query.MenuQuery;
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
 * 菜单 服务调用外部接口
 * </p>
 *
 * @author yitiankeji
 * @since 2020-07-23
*/
@Controller
public class MenuController {

    @Autowired
    private MenuApi menuApi;

    @GetMapping("/menu/list")
    public String list() {
        return "/menu/list";
    }

    @GetMapping("/menu/add")
    public String add() {
        return "/menu/add";
    }

    @GetMapping("/menu/edit")
    public String edit() {
        return "/menu/edit";
    }

    @ResponseBody
    @PostMapping("/menu/page")
    public Page<Menu> page(@RequestBody MenuQuery query) {
        return menuApi.page(query);
    }

    @ResponseBody
    @GetMapping("/menu/findById")
    public Menu findById(@RequestParam Integer id) {
        return menuApi.findById(id);
    }

    @ResponseBody
    @PostMapping("/menu/save")
    public ResponseData save(@RequestBody Menu menu) {
        return menuApi.save(menu);
    }

    @ResponseBody
    @PostMapping("/menu/update")
    public ResponseData update(@RequestBody Menu menu) {
        return menuApi.update(menu);
    }

    @ResponseBody
    @GetMapping("/menu/delete")
    public ResponseData delete(@RequestParam List<Integer> id) {
    return menuApi.delete(id);
    }

    @ResponseBody
    @GetMapping("/menu/export")
    public void export(MenuQuery query, HttpServletResponse response) throws IOException {
        ResponseEntity responseEntity = menuApi.export(10);
        response.setContentType("application/vnd.ms-excel;charset=utf-8");

        HttpHeaders headers = responseEntity.getHeaders();
        response.addHeader("Content-Disposition", headers.getFirst("content-disposition"));

        byte[] body = (byte[]) responseEntity.getBody();
        response.getOutputStream().write(body);
    }
}
