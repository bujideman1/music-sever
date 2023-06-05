package com.example.musicserve.service;

import com.example.musicserve.common.resp.ResponseResult;
import com.example.musicserve.domain.Collect;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface CollectService extends IService<Collect> {

    ResponseResult status(Collect collect);

    ResponseResult add(Collect collect);

    ResponseResult delete(Collect collect);
}
