package com.example.musicserve.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.musicserve.common.req.LoginDto;
import com.example.musicserve.common.resp.ResponseResult;
import com.example.musicserve.domain.Consumer;

/**
 *
 */
public interface ConsumerService extends IService<Consumer> {

    ResponseResult login(LoginDto user);
}
