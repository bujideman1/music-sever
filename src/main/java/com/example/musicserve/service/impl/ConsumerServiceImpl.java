package com.example.musicserve.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.musicserve.common.constant.AppHttpCodeEnum;
import com.example.musicserve.common.req.LoginDto;
import com.example.musicserve.common.resp.ResponseResult;
import com.example.musicserve.domain.Consumer;
import com.example.musicserve.service.ConsumerService;
import com.example.musicserve.mapper.ConsumerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class ConsumerServiceImpl extends ServiceImpl<ConsumerMapper, Consumer>
    implements ConsumerService{
    @Autowired
    private ConsumerMapper consumerMapper;
    @Override
    public ResponseResult login(LoginDto user) {
        LambdaQueryWrapper<Consumer> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(Consumer::getUsername,user.getUsername()).eq(Consumer::getPassword,user.getPassword());
        Consumer consumer = consumerMapper.selectOne(wrapper);
        if(consumer!=null)
            return new ResponseResult(200,"登录成功",consumer);
        else
            return ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_ERROR,"请检查用户名或密码");
    }
}




