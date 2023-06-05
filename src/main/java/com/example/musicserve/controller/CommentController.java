package com.example.musicserve.controller;

import com.example.musicserve.common.resp.ResponseResult;
import com.example.musicserve.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @GetMapping("/songList/detail")
    public ResponseResult getComment(Integer songListId,Integer songId){
        return commentService.getComment(songListId,songId);
    }
}
