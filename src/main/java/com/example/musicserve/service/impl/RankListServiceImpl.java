package com.example.musicserve.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.musicserve.common.resp.ResponseResult;
import com.example.musicserve.domain.RankList;
import com.example.musicserve.service.RankListService;
import com.example.musicserve.mapper.RankListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
@Service
public class RankListServiceImpl extends ServiceImpl<RankListMapper, RankList>
    implements RankListService{
    @Autowired
    private  RankListMapper rankListMapper;

    /**
     * 根据歌单id获取打分列表，计算平均分
     * @param songListId 歌单id
     * @return 返回歌单打分的平均分
     */
    @Override
    public ResponseResult getRank(Integer songListId) {
        LambdaQueryWrapper<RankList> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(RankList::getSongListId,songListId).select(RankList::getScore);
        List<RankList> rankLists = rankListMapper.selectList(wrapper);
        Double avg = rankLists.stream().collect(Collectors.averagingInt(RankList::getScore));
        return ResponseResult.okResult(avg);
    }

    @Override
    public ResponseResult getUserRank(Integer consumerId, Integer songListId) {
        LambdaQueryWrapper<RankList> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(RankList::getSongListId,songListId)
                .eq(RankList::getConsumerId,consumerId)
                .select(RankList::getScore);
        RankList rankList = rankListMapper.selectOne(wrapper);
        if(rankList!=null)
            return ResponseResult.okResult(rankList.getScore());
        else
            return ResponseResult.okResult();
    }
}




