package com.example.musicserve.service;

import com.example.musicserve.common.resp.ResponseResult;
import com.example.musicserve.domain.Singer;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface SingerService extends IService<Singer> {

    ResponseResult singerList();
}
