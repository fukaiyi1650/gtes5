package com.yitiankeji.api;

import com.yitiankeji.entity.RoleMenu;
import com.yitiankeji.query.RoleMenuQuery;
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
 * 角色菜单 服务调用端
 * </p>
 *
 * @author yitiankeji
 * @since 2020-07-24
*/
@FeignClient("manager-service")
public interface RoleMenuApi {

    @PostMapping("/roleMenu/page")
    public Page<RoleMenu> page(@RequestBody RoleMenuQuery query);

    @PostMapping("/roleMenu/list")
    public List<RoleMenu> list(@RequestBody RoleMenuQuery query);

    @GetMapping("/roleMenu/findById")
    public RoleMenu findById(@RequestParam Integer id);

    @PostMapping("/roleMenu/save")
    public ResponseData save(@RequestBody RoleMenu roleMenu);

    @PostMapping("/roleMenu/update")
    public ResponseData update(@RequestBody RoleMenu roleMenu);

    @GetMapping("/roleMenu/delete")
    public ResponseData delete(@RequestParam List<Integer> id);

    @GetMapping(value = "/roleMenu/export", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    ResponseEntity<byte[]> export(@RequestParam Integer id);
}
