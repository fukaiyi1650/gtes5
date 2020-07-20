package com.yitiankeji.config;

import org.springframework.boot.actuate.autoconfigure.security.reactive.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        return http
                .csrf().disable()
                .cors()
                .and().formLogin().disable()
                .httpBasic().disable()
                .authorizeExchange()
                .pathMatchers("/**").permitAll()
                .matchers(EndpointRequest.toAnyEndpoint()).hasRole("ACTUATOR_ADMIN")
                .and().build();
    }
}

////拦截所有endpoint，拥有ACTUATOR_ADMIN角色可访问，否则需登录
//                .requestMatchers(EndpointRequest.toAnyEndpoint()).hasRole("ACTUATOR_ADMIN")
//                        //静态文件允许访问
//                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
//                        //根路径允许访问
//                        .antMatchers("/").permitAll()
//                        //所有请求路径可以访问
//                        .antMatchers("/**").permitAll()
//                        .and().httpBasic();
