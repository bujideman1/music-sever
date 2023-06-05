package com.example.musicserve.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.musicserve.common.resp.ResponseResult;
import com.example.musicserve.domain.Collect;
import com.example.musicserve.service.CollectService;
import com.example.musicserve.mapper.CollectMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 *
 */
@Service
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect>
    implements CollectService{
    public boolean isCollection(Collect collect){
        LambdaQueryWrapper<Collect> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(Collect::getUserId,collect.getUserId())
                .eq(!Objects.isNull(collect.getSongId()),Collect::getSongId,collect.getSongId())
                .eq(!Objects.isNull(collect.getSongListId()),Collect::getSongListId,collect.getSongListId());
        Integer integer = getBaseMapper().selectCount(wrapper);
        return integer>0;
    }
    @Override
    public ResponseResult status(Collect collect) {
        return ResponseResult.okResult(isCollection(collect));
    }

    @Override
    public ResponseResult add(Collect collect) {
        if(!isCollection(collect))
            getBaseMapper().insert(collect);
        return ResponseResult.okResult(true);
    }

    @Override
    public ResponseResult delete(Collect collect) {
        LambdaQueryWrapper<Collect> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(Collect::getUserId,collect.getUserId())
                .eq(!Objects.isNull(collect.getSongId()),Collect::getSongId,collect.getSongId())
                .eq(!Objects.isNull(collect.getSongListId()),Collect::getSongListId,collect.getSongListId());

        if(isCollection(collect))
            getBaseMapper().delete(wrapper);
        return ResponseResult.okResult(false);
    }
}




