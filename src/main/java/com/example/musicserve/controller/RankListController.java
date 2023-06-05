package com.example.musicserve.controller;

import com.example.musicserve.common.resp.ResponseResult;
import com.example.musicserve.service.RankListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rankList")
public class RankListController {
    @Autowired
    private RankListService rankListService;
    @GetMapping
    public ResponseResult getRank(Integer songListId){
        /**
         * 获取歌单
         */
        return rankListService.getRank(songListId);
    }
    @GetMapping("/user")
    public ResponseResult getUserRank(Integer consumerId,Integer songListId){
        /**
         * 获取用户歌单打分
         */
        return rankListService.getUserRank(consumerId,songListId);
    }
}
