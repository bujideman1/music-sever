package com.example.musicserve.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.musicserve.common.resp.ResponseResult;
import com.example.musicserve.domain.ListSong;
import com.example.musicserve.domain.Song;
import com.example.musicserve.mapper.SongMapper;
import com.example.musicserve.service.ListSongService;
import com.example.musicserve.mapper.ListSongMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
@Service
public class ListSongServiceImpl extends ServiceImpl<ListSongMapper, ListSong>
    implements ListSongService{
    @Autowired
    private ListSongMapper listSongMapper;
    @Autowired
    private SongMapper songMapper;


    @Override
    public ResponseResult getSongSheetDetail(Integer songListId) {
        LambdaQueryWrapper<ListSong> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(ListSong::getSongListId,songListId).select(ListSong::getSongId);
        List<ListSong> listSongs = listSongMapper.selectList(wrapper);
        return ResponseResult.okResult(listSongs);
    }
}




