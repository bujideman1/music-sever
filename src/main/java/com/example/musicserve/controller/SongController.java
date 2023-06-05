package com.example.musicserve.controller;

import com.example.musicserve.common.constant.Constants;
import com.example.musicserve.common.req.AddSongDto;
import com.example.musicserve.common.resp.ResponseResult;
import com.example.musicserve.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;

@RestController
@RequestMapping("/song")
public class SongController {
    @Autowired
    private SongService songService;
//    上传文件大小设置
    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory=new MultipartConfigFactory();
//        文件最大上传大小，dataunit提供五种类型B,KB,MB,GB,TB
        factory.setMaxFileSize(DataSize.of(20, DataUnit.MEGABYTES));
        factory.setMaxRequestSize(DataSize.of(20,DataUnit.MEGABYTES));
        return factory.createMultipartConfig();
    }
//    设置静态资源映射
    @Configuration
    public static class MySongConfig implements WebMvcConfigurer{
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("img/songPic/**")
                .addResourceLocations(Constants.SONG_PIC_PATH);
        registry.addResourceHandler("/song/**")
                .addResourceLocations(Constants.SONG_PATH);
    }
}
//    返回所有歌曲
    @GetMapping
    public ResponseResult allSong(){
        return songService.allSong();
    }
    //添加歌曲
    @PostMapping("/add")
    public  ResponseResult addSong(AddSongDto songDto){
        return songService.addSong(songDto);
    }
    @GetMapping("/detail")
    public ResponseResult getDetail(Integer id){
        return songService.getDetail(id);
    }
}
