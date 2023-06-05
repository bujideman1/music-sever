package com.example.musicserve.service;

import com.example.musicserve.common.resp.ResponseResult;
import com.example.musicserve.domain.SongList;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface SongListService extends IService<SongList> {

    ResponseResult songList();

    ResponseResult getDetail(Integer songListId);
}
