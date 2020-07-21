package ${cfg.basePackage}.controller;

import ${cfg.basePackage}.api.${entity}Api;
import ${package.Entity}.${entity};
import ${cfg.basePackage}.query.${entity}Query;
import ${cfg.basePackage}.response.ResponseData;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 * ${table.comment!} 服务调用外部接口
 * </p>
 *
 * @author ${author}
 * @since ${date}
*/
@RestController
public class ${entity}Controller {

    @Autowired
    private ${entity}Api ${table.entityPath}Api;

    @RequestMapping("/${table.entityPath}/page")
    public Page<${entity}> page(${entity}Query query) {
        return ${table.entityPath}Api.page(query);
    }

    @RequestMapping("/${table.entityPath}/list")
    public List<${entity}> list() {
        return ${table.entityPath}Api.list();
    }

    @RequestMapping("/${table.entityPath}/findById")
    public ${entity} findById(@RequestParam Integer id) {
        return ${table.entityPath}Api.findById(id);
    }

    @RequestMapping("/${table.entityPath}/save")
    public ResponseData save(@RequestBody ${entity} ${table.entityPath}) {
        return ${table.entityPath}Api.save(${table.entityPath});
    }

    @RequestMapping("/${table.entityPath}/update")
    public ResponseData update(@RequestBody ${entity} ${table.entityPath}) {
        return ${table.entityPath}Api.update(${table.entityPath});
    }

    @RequestMapping("/${table.entityPath}/delete")
    public ResponseData delete(@RequestParam List<Integer> id) {
    return ${table.entityPath}Api.delete(id);
    }
}
