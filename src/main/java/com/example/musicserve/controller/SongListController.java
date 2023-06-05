package com.example.musicserve.controller;

import com.example.musicserve.common.constant.Constants;
import com.example.musicserve.common.resp.ResponseResult;
import com.example.musicserve.service.SongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RestController
@RequestMapping("/songList")
public class SongListController {
    @Configuration
    public static class MyPicConfig implements WebMvcConfigurer {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/img/songListPic/**")
                    .addResourceLocations(Constants.SONGLIST_PIC_PATH);
        }
    }
    @Autowired
    private SongListService songListService;
    @RequestMapping
    public ResponseResult songList(){
        return songListService.songList();
    }
    @GetMapping("/detail")
    public ResponseResult getDetail(Integer songListId){
        return songListService.getDetail(songListId);
    }
}
