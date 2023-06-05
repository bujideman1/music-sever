package com.example.musicserve.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.musicserve.common.resp.ResponseResult;
import com.example.musicserve.domain.Comment;

/**
 *
 */
public interface CommentService extends IService<Comment> {

    ResponseResult getComment(Integer songListId, Integer songId);
}
