package com.lzhijin.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



//@Configuration
//public class InterceptorConfig implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(authenticationInterceptor())
//                .addPathPatterns("/**"); // 拦截所有请求 判断是否有LoginRequired注解决定是否需要登录
//    }
//
//    @Bean
//    public AuthenticationInterceptor authenticationInterceptor(){
//        return new AuthenticationInterceptor();
//    }
//}
