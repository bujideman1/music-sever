package com.example.musicserve.controller;

import com.example.musicserve.common.constant.Constants;
import com.example.musicserve.common.req.LoginDto;
import com.example.musicserve.common.resp.ResponseResult;
import com.example.musicserve.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RestController
@RequestMapping("/user")
public class UserController {
    //    设置静态资源映射
    @Configuration
    public static class MySongConfig implements WebMvcConfigurer {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/img/avatorImages/**")
                    .addResourceLocations(Constants.AVATOR_IMAGES_PATH);

        }
    }
    @Autowired
    private ConsumerService consumerService;
    @PostMapping("/login/status")
    public ResponseResult login( LoginDto user){
        return consumerService.login(user);
    }
    @GetMapping("/detail")
    public ResponseResult getDetail(Integer id){
        return ResponseResult.okResult(consumerService.getById(id));
    }
}
