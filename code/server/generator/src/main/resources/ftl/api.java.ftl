package ${cfg.basePackage}.api;

import ${package.Entity}.${entity};
import ${cfg.basePackage}.query.${entity}Query;
import ${cfg.basePackage}.response.ResponseData;

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
 * ${table.comment!} 服务调用端
 * </p>
 *
 * @author ${author}
 * @since ${date}
*/
@FeignClient("${cfg.module}-service")
public interface ${entity}Api {

    @PostMapping("/${table.entityPath}/page")
    public Page<${entity}> page(@RequestBody ${entity}Query query);

    @PostMapping("/${table.entityPath}/list")
    public List<${entity}> list(@RequestBody ${entity}Query query);

    @GetMapping("/${table.entityPath}/findById")
    public ${entity} findById(@RequestParam Integer id);

    @PostMapping("/${table.entityPath}/save")
    public ResponseData save(@RequestBody ${entity} ${table.entityPath});

    @PostMapping("/${table.entityPath}/update")
    public ResponseData update(@RequestBody ${entity} ${table.entityPath});

    @GetMapping("/${table.entityPath}/delete")
    public ResponseData delete(@RequestParam List<Integer> id);

    @GetMapping(value = "/${table.entityPath}/export", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    ResponseEntity<byte[]> export(@RequestParam Integer id);
}
