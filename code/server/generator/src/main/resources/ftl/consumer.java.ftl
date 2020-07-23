package ${cfg.basePackage}.controller;

import ${cfg.basePackage}.api.${entity}Api;
import ${package.Entity}.${entity};
import ${cfg.basePackage}.query.${entity}Query;
import ${cfg.basePackage}.response.ResponseData;

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
 * ${table.comment!} 服务调用外部接口
 * </p>
 *
 * @author ${author}
 * @since ${date}
*/
@Controller
public class ${entity}Controller {

    @Autowired
    private ${entity}Api ${table.entityPath}Api;

    @GetMapping("/${table.entityPath}/list")
    public String list() {
        return "/${table.entityPath}/list";
    }

    @GetMapping("/${table.entityPath}/add")
    public String add() {
        return "/${table.entityPath}/add";
    }

    @GetMapping("/${table.entityPath}/edit")
    public String edit() {
        return "/${table.entityPath}/edit";
    }

    @ResponseBody
    @PostMapping("/${table.entityPath}/page")
    public Page<${entity}> page(@RequestBody ${entity}Query query) {
        return ${table.entityPath}Api.page(query);
    }

    @ResponseBody
    @GetMapping("/${table.entityPath}/findById")
    public ${entity} findById(@RequestParam Integer id) {
        return ${table.entityPath}Api.findById(id);
    }

    @ResponseBody
    @PostMapping("/${table.entityPath}/save")
    public ResponseData save(@RequestBody ${entity} ${table.entityPath}) {
        return ${table.entityPath}Api.save(${table.entityPath});
    }

    @ResponseBody
    @PostMapping("/${table.entityPath}/update")
    public ResponseData update(@RequestBody ${entity} ${table.entityPath}) {
        return ${table.entityPath}Api.update(${table.entityPath});
    }

    @ResponseBody
    @GetMapping("/${table.entityPath}/delete")
    public ResponseData delete(@RequestParam List<Integer> id) {
    return ${table.entityPath}Api.delete(id);
    }

    @ResponseBody
    @GetMapping("/${table.entityPath}/export")
    public void export(${entity}Query query, HttpServletResponse response) throws IOException {
        ResponseEntity responseEntity = ${table.entityPath}Api.export(10);
        response.setContentType("application/vnd.ms-excel;charset=utf-8");

        HttpHeaders headers = responseEntity.getHeaders();
        response.addHeader("Content-Disposition", headers.getFirst("content-disposition"));

        byte[] body = (byte[]) responseEntity.getBody();
        response.getOutputStream().write(body);
    }
}
