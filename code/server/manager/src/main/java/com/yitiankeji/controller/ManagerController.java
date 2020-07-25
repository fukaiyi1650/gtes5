package com.yitiankeji.controller;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yitiankeji.dto.ManagerRoleDto;
import com.yitiankeji.entity.Manager;
import com.yitiankeji.query.ManagerQuery;
import com.yitiankeji.response.ResponseData;
import com.yitiankeji.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
 * @since 2020-07-23
 */
@RestController
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @PostMapping("/manager/saveRoles")
    public ResponseData saveRoles(@RequestBody ManagerRoleDto managerRoleDto) {
        managerService.saveRoles(managerRoleDto.getManagerId(), managerRoleDto.getRoleIds());
        return ResponseData.success();
    }

    @RequestMapping("/manager/page")
    public IPage<Manager> page(@RequestBody ManagerQuery query){
        Page<Manager> page = new Page<Manager>(query.getIDisplayStart() / query.getIDisplayLength() + 1, query.getIDisplayLength());
        return managerService.page(page);
    }

    @RequestMapping("/manager/list")
    public List<Manager> list(@RequestBody ManagerQuery query){
        return managerService.list();
    }

    @RequestMapping("/manager/findById")
    public Manager findById(@RequestParam Integer id) {
        return managerService.getById(id);
    }

    @RequestMapping("/manager/save")
    public ResponseData save(@RequestBody Manager manager) {
        managerService.save(manager);
        return ResponseData.success(manager);
    }

    @RequestMapping("/manager/update")
    public ResponseData update(@RequestBody Manager manager) {
        managerService.updateById(manager);
        return ResponseData.success(manager);
    }

    @RequestMapping("/manager/delete")
    public ResponseData delete(@RequestParam List<Integer> ids) {
        managerService.removeByIds(ids);
        return ResponseData.success(ids);
    }

    @ResponseBody
    @RequestMapping("/manager/export")
    public void export(ManagerQuery query, HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("管理员", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), Manager.class).sheet("管理员").doWrite(list(query));
    }
}
