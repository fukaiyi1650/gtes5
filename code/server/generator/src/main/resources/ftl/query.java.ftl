package ${cfg.basePackage}.query;

import lombok.Data;

@Data
public class ${entity}Query {

    private Integer pageSize = 10;
    private Integer page = 1;

    <#list table.fields as field>
    private String ${field.propertyName};
    </#list>
}
