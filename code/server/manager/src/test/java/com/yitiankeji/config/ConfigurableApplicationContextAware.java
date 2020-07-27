package com.yitiankeji.config;


import com.unitils.boot.SpringBootModule;
import com.unitils.boot.util.UnitilsBootBlockJUnit4ClassRunner;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(UnitilsBootBlockJUnit4ClassRunner.class)
public class ConfigurableApplicationContextAware implements InitializingBean {

    @Autowired
    private ConfigurableApplicationContext configurableApplicationContext;

    @Override
    public void afterPropertiesSet() throws Exception {
        SpringBootModule.setApplicationContext(configurableApplicationContext);
    }
}