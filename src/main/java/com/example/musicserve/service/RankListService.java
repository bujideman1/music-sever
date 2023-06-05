package com.example.musicserve.service;

import com.example.musicserve.common.resp.ResponseResult;
import com.example.musicserve.domain.RankList;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface RankListService extends IService<RankList> {

    ResponseResult getRank(Integer songListId);

    ResponseResult getUserRank(Integer consumerId, Integer songListId);
}
