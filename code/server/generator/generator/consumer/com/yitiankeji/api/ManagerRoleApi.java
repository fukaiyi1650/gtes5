package com.yitiankeji.api;

import com.yitiankeji.entity.ManagerRole;
import com.yitiankeji.query.ManagerRoleQuery;
import com.yitiankeji.response.ResponseData;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 * 管理员角色 服务调用端
 * </p>
 *
 * @author yitiankeji
*/
@FeignClient("manager-service")
public interface ManagerRoleApi {

    @PostMapping("/managerRole/page")
    public Page<ManagerRole> page(@RequestBody ManagerRoleQuery query);

    @PostMapping("/managerRole/list")
    public List<ManagerRole> list(@RequestBody ManagerRoleQuery query);

    @GetMapping("/managerRole/findById")
    public ManagerRole findById(@RequestParam Integer id);

    @PostMapping("/managerRole/save")
    public ResponseData save(@RequestBody ManagerRole managerRole);

    @PostMapping("/managerRole/update")
    public ResponseData update(@RequestBody ManagerRole managerRole);

    @GetMapping("/managerRole/delete")
    public ResponseData delete(@RequestParam List<Integer> ids);

    @GetMapping(value = "/managerRole/export", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    ResponseEntity<byte[]> export(@RequestParam Integer id);
}
