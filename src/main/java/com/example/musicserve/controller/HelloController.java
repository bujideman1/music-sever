package com.example.musicserve.controller;

import com.example.musicserve.common.resp.ResponseResult;
import com.example.musicserve.domain.ListSong;
import com.example.musicserve.service.ListSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private ListSongService listSongService;

    @GetMapping("/hello")
    public String hello(){
        return "hello world!";
    }
    @GetMapping("/listSong/detail")
    public ResponseResult getListSong(Integer songListId){
        return listSongService.getSongSheetDetail(songListId);
    }

}
