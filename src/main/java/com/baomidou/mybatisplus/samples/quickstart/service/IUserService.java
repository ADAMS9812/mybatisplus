package com.baomidou.mybatisplus.samples.quickstart.service;

/**
 * 用户的service层接口
 */
public interface IUserService {

    //新增用户的方法
    void insert(Integer id, String name, Integer age, String email);

}