package com.example.musicserve.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.musicserve.common.constant.Constants;
import com.example.musicserve.common.resp.ResponseResult;
import com.example.musicserve.domain.Comment;
import com.example.musicserve.service.CommentService;
import com.example.musicserve.mapper.CommentMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 *
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService{

    @Override
    public ResponseResult getComment(Integer songListId, Integer songId) {
        LambdaQueryWrapper<Comment> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(!Objects.isNull(songListId),Comment::getSongListId,songListId)
                .eq(!Objects.isNull(songId),Comment::getSongId,songId);
        List<Comment> comments = getBaseMapper().selectList(wrapper);
        return ResponseResult.okResult(comments);
    }
}




