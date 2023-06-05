package com.example.musicserve.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//允许跨域的url
                .allowedOriginPatterns("*")//设置允许跨域请求的域名
                .allowedMethods("*")//设置允许跨域请求的请求类型
                .allowCredentials(true)//是否发送Cookie
                .exposedHeaders("*");//暴露的header
    }
}
