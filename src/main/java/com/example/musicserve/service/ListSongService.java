package com.example.musicserve.service;

import com.example.musicserve.common.resp.ResponseResult;
import com.example.musicserve.domain.ListSong;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
public interface ListSongService extends IService<ListSong> {

    ResponseResult getSongSheetDetail(Integer songListId);
}
