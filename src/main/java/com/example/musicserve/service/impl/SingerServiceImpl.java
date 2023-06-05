package com.example.musicserve.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.musicserve.common.resp.ResponseResult;
import com.example.musicserve.domain.Singer;
import com.example.musicserve.service.SingerService;
import com.example.musicserve.mapper.SingerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class SingerServiceImpl extends ServiceImpl<SingerMapper, Singer>
    implements SingerService{
    @Autowired
    private SingerMapper singerMapper;
    @Override
    public ResponseResult singerList() {
        List<Singer> singers = singerMapper.selectList(null);
        return ResponseResult.okResult(singers);
    }
}




