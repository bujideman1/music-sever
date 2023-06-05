package com.example.musicserve.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.musicserve.common.resp.ResponseResult;
import com.example.musicserve.domain.SongList;
import com.example.musicserve.service.SongListService;
import com.example.musicserve.mapper.SongListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class SongListServiceImpl extends ServiceImpl<SongListMapper, SongList>
    implements SongListService{
    @Autowired
    private SongListMapper songListMapper;
    @Override
    public ResponseResult songList() {
        List<SongList> songLists = songListMapper.selectList(null);
        return ResponseResult.okResult(songLists);
    }

    @Override
    public ResponseResult getDetail(Integer songListId) {
        SongList songList = songListMapper.selectById(songListId);
        return ResponseResult.okResult(songList);
    }
}




