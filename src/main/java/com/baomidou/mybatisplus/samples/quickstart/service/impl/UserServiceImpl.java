package com.baomidou.mybatisplus.samples.quickstart.service.impl;

import com.baomidou.mybatisplus.samples.quickstart.entity.User;
import com.baomidou.mybatisplus.samples.quickstart.mapper.UserMapper;
import com.baomidou.mybatisplus.samples.quickstart.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户service层实现类
 */

@Service
public class UserServiceImpl implements IUserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public void insert(Integer id, String name, Integer age, String email) {

        //创建一个User用户接受对象数据
        User user = new User(id,name,age,email);
        //新增一个用户到数据库
        userMapper.insert(user);

    }
}
