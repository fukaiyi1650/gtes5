package com.yitiankeji.api;

import com.yitiankeji.entity.Manager;
import com.yitiankeji.query.ManagerQuery;
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
 * 管理员 服务调用端
 * </p>
 *
 * @author yitiankeji
 * @since 2020-07-23
*/
@FeignClient("manager-service")
public interface ManagerApi {

    @PostMapping("/manager/page")
    public Page<Manager> page(@RequestBody ManagerQuery query);

    @PostMapping("/manager/list")
    public List<Manager> list(@RequestBody ManagerQuery query);

    @GetMapping("/manager/findById")
    public Manager findById(@RequestParam Integer id);

    @PostMapping("/manager/save")
    public ResponseData save(@RequestBody Manager manager);

    @PostMapping("/manager/update")
    public ResponseData update(@RequestBody Manager manager);

    @GetMapping("/manager/delete")
    public ResponseData delete(@RequestParam List<Integer> ids);

    @GetMapping(value = "/manager/export", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    ResponseEntity<byte[]> export(@RequestParam Integer id);
}
