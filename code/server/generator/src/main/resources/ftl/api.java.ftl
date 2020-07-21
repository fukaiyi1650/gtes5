package ${cfg.basePackage}.api;

import ${package.Entity}.${entity};
import ${cfg.basePackage}.query.${entity}Query;
import ${cfg.basePackage}.response.ResponseData;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
@FeignClient("${table.entityPath}-service")
public interface ${entity}Api {

    @RequestMapping("/${table.entityPath}/page")
    public Page<${entity}> page(@RequestBody ${entity}Query query);

    @RequestMapping("/${table.entityPath}/list")
    public List<${entity}> list();

    @RequestMapping("/${table.entityPath}/findById")
    public ${entity} findById(@RequestParam Integer id);

    @RequestMapping("/${table.entityPath}/save")
    public ResponseData save(@RequestBody ${entity} ${table.entityPath});

    @RequestMapping("/${table.entityPath}/update")
    public ResponseData update(@RequestBody ${entity} ${table.entityPath});

    @RequestMapping("/${table.entityPath}/delete")
    public ResponseData delete(@RequestParam List<Integer> id);
}
