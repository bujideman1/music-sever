package com.example.musicserve.controller;

import com.example.musicserve.common.resp.ResponseResult;
import com.example.musicserve.domain.Collect;
import com.example.musicserve.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/collection")
public class CollectionController {
    @Autowired
    private CollectService collectService;
    @PostMapping("/status")
    public ResponseResult status(Collect collect){
        /**
         * 判断是否收藏歌单
         */
        return collectService.status(collect);
    }
    @PostMapping("/add")
    public ResponseResult add(Collect collect){
        /**
         * 收藏歌曲
         */
        return collectService.add(collect);
    }
    @DeleteMapping("/delete")
    public ResponseResult delete(Collect collect){
        return collectService.delete(collect);
    }
}
