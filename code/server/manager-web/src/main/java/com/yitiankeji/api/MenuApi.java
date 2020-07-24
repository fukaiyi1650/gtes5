package com.yitiankeji.api;

import com.yitiankeji.entity.Menu;
import com.yitiankeji.query.MenuQuery;
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
 * 菜单 服务调用端
 * </p>
 *
 * @author yitiankeji
 * @since 2020-07-23
*/
@FeignClient("manager-service")
public interface MenuApi {

    @PostMapping("/menu/page")
    public Page<Menu> page(@RequestBody MenuQuery query);

    @PostMapping("/menu/list")
    public List<Menu> list(@RequestBody MenuQuery query);

    @GetMapping("/menu/findById")
    public Menu findById(@RequestParam Integer id);

    @PostMapping("/menu/save")
    public ResponseData save(@RequestBody Menu menu);

    @PostMapping("/menu/update")
    public ResponseData update(@RequestBody Menu menu);

    @GetMapping("/menu/delete")
    public ResponseData delete(@RequestParam List<Integer> ids);

    @GetMapping(value = "/menu/export", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    ResponseEntity<byte[]> export(@RequestParam Integer id);
}
