package com.example.musicserve.controller;

import com.example.musicserve.common.constant.Constants;
import com.example.musicserve.common.resp.ResponseResult;
import com.example.musicserve.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RestController
@RequestMapping("/singer")
public class SingerController {

    @Configuration
    public static class MyPicConfig implements WebMvcConfigurer {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
//            歌手图片的静态资源映射
            registry.addResourceHandler("/img/singerPic/**")
                    .addResourceLocations(Constants.SINGER_PIC_PATH);
        }
    }
    @Autowired
    private SingerService singerService;
    @GetMapping
    public ResponseResult singerList(){
        return singerService.singerList();
    }
}
