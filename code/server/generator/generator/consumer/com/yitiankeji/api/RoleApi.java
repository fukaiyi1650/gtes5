package com.yitiankeji.api;

import com.yitiankeji.entity.Role;
import com.yitiankeji.query.RoleQuery;
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
 * 角色 服务调用端
 * </p>
 *
 * @author yitiankeji
*/
@FeignClient("manager-service")
public interface RoleApi {

    @PostMapping("/role/page")
    public Page<Role> page(@RequestBody RoleQuery query);

    @PostMapping("/role/list")
    public List<Role> list(@RequestBody RoleQuery query);

    @GetMapping("/role/findById")
    public Role findById(@RequestParam Integer id);

    @PostMapping("/role/save")
    public ResponseData save(@RequestBody Role role);

    @PostMapping("/role/update")
    public ResponseData update(@RequestBody Role role);

    @GetMapping("/role/delete")
    public ResponseData delete(@RequestParam List<Integer> ids);

    @GetMapping(value = "/role/export", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    ResponseEntity<byte[]> export(@RequestParam Integer id);
}
