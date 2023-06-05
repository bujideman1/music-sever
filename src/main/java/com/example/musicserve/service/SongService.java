package com.example.musicserve.service;

import com.example.musicserve.common.req.AddSongDto;
import com.example.musicserve.common.resp.ResponseResult;
import com.example.musicserve.domain.Song;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface SongService extends IService<Song> {

    ResponseResult allSong();

    ResponseResult addSong(AddSongDto songDto);

    ResponseResult getDetail(Integer id);
}
