package ${cfg.basePackage}.query;

<#if swagger2>
import io.swagger.annotations.ApiModelProperty;
</#if>
import lombok.Data;

@Data
public class ${entity}Query extends BaseQuery {

    <#list table.fields as field>
    <#if swagger2>
    @ApiModelProperty(value = "${field.comment}", notes = "${field.comment}")
    </#if>
    private String ${field.propertyName};
    </#list>
}
