package com.yitiankeji.generator;

import com.yitiankeji.config.GeneratorConfig;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MyBatisPlusGenerator implements ApplicationRunner {

    @Autowired
    private GeneratorConfig config;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // 代码生成器
        AutoGenerator generator = new AutoGenerator();
        generator.setTemplateEngine(new FreemarkerTemplateEngine());

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        // 设置输出的路径 项目的绝对路径地址
        String projectPath = System.getProperty("user.dir") + "/generator";
        gc.setOutputDir(projectPath + "/generator/provider");

        // 设置作者
        gc.setAuthor(config.getAuthor());
        // 是否覆盖同名文件，默认是false
        gc.setFileOverride(true);
        // 不需要ActiveRecord特性的请改为false
        gc.setActiveRecord(false);
        // XML ResultMap
        gc.setBaseResultMap(true);
        // XML columList
        gc.setBaseColumnList(false);
        // 是否立刻打开
        gc.setOpen(false);
        // 设置时间格式
        gc.setDateType(DateType.ONLY_DATE);
        // 设置主键类型
        gc.setIdType(IdType.AUTO);
        gc.setSwagger2(false);
        // 设置生成代码的名字
        gc.setEntityName("%s")
                // .setServiceName("%sService")
                .setServiceImplName("%sService")
                .setMapperName("%sMapper")
                .setControllerName("%sController");
        generator.setGlobalConfig(gc);

        //数据源配置,包括了数据库类型，用户名密码，链接地址。
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver").setDbType(DbType.MYSQL);
        dataSourceConfig.setUsername(username).setPassword(password).setUrl(url);
        generator.setDataSource(dataSourceConfig);

        // 包的配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(config.getBasepackage());
        packageConfig.setXml("mapping");
        packageConfig.setServiceImpl("service");

        // 关闭默认 xml 生成，调整生成 至 根目录
        TemplateConfig tc = new TemplateConfig();
        tc.setXml(null);
        tc.setService(null);
        tc.setEntity(null);
        tc.setController("/ftl/controller.java");
        tc.setServiceImpl("/ftl/serviceImpl.java");
        generator.setTemplate(tc);

        // PackageConfig packageConfig = new PackageConfig();
        // packageConfig.setParent(null);
        // packageConfig.setEntity("com.yitiankeji.model");
        // packageConfig.setMapper("com.yitiankeji.mapper");
        // packageConfig.setController("com.yitiankeji.controller");
        // packageConfig.setService("com.yitiankeji.service");
        // packageConfig.setServiceImpl("com.yitiankeji.service.impl");
        // packageConfig.setXml("resources.mapper");
        // 调整 xml 生成目录演示
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/generator/provider/mapping/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });
        focList.add(new FileOutConfig("/ftl/page.vue.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/generator/vue/" + tableInfo.getEntityName() + ".vue";
            }
        });
        focList.add(new FileOutConfig("/ftl/api.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/generator/consumer/" + config.getBasepackage().replace('.', '/') + "/api/" + tableInfo.getEntityName() + "Api.java";
            }
        });
        focList.add(new FileOutConfig("/ftl/consumer.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/generator/consumer/" + config.getBasepackage().replace('.', '/') + "/controller/" + tableInfo.getEntityName() + "Controller.java";
            }
        });
        focList.add(new FileOutConfig("/ftl/query.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/generator/consumer/" + config.getBasepackage().replace('.', '/') + "/query/" + tableInfo.getEntityName() + "Query.java";
            }
        });
        focList.add(new FileOutConfig("/ftl/entity.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/generator/consumer/" + config.getBasepackage().replace('.', '/') + "/entity/" + tableInfo.getEntityName() + ".java";
            }
        });
        focList.add(new FileOutConfig("/ftl/query.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/generator/provider/" + config.getBasepackage().replace('.', '/') + "/query/" + tableInfo.getEntityName() + "Query.java";
            }
        });
        focList.add(new FileOutConfig("/ftl/entity.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/generator/provider/" + config.getBasepackage().replace('.', '/') + "/entity/" + tableInfo.getEntityName() + ".java";
            }
        });
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("basePackage", config.getBasepackage());
                map.put("module", config.getModule());
                this.setMap(map);
            }
        };
//        cfg.setFileCreate(new IFileCreate() {
//            @Override
//            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
//                return false;
//            }
//        });
        cfg.setFileOutConfigList(focList);
        generator.setCfg(cfg);

        generator.setPackageInfo(packageConfig);

        StrategyConfig strategy = new StrategyConfig();
        // 设置字段名大小写转换
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);

        List<String> tables = config.getTables();
        if (!tables.isEmpty()) {
            String first = tables.get(0);
            if (!StringUtils.equals("0", first)) {
                // 设置生成的表名(可以有多个)，这里使用include，写入null，表示生成所有表。
                strategy.setInclude(config.getTables().toArray(new String[config.getTables().size()]));
            }
        }

        strategy.setTablePrefix(config.getPrefix().toArray(new String[config.getPrefix().size()]));
        // 设置自定义的service层继承代码，这里使用我定义的service和impl来进行继承
        // strategy.setSuperServiceClass("com.yitiankeji.util.MyService");
        // strategy.setSuperServiceImplClass("com.yitiankeji.util.MyServiceImpl");
        // 实体类是否带有lombok风格
        strategy.setEntityLombokModel(true);
        //rest风格controller
        strategy.setRestControllerStyle(true);
        //允许字段自动注解
        strategy.setEntityTableFieldAnnotationEnable(true);
        //设置逻辑删除的字段名
        strategy.setLogicDeleteFieldName("del");
        //填充字段配置
        List<TableFill> list = new ArrayList<>();
        list.add(new TableFill("create_time", FieldFill.INSERT));
        list.add(new TableFill("update_time", FieldFill.INSERT_UPDATE));
        strategy.setTableFillList(list);

        generator.setStrategy(strategy);

        generator.execute();
    }
}
