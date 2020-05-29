package com.baomidou.mybatisplus.samples.quickstart.service;

import com.baomidou.mybatisplus.samples.quickstart.entity.User;

import java.util.List;

/**
 * 用户的service层接口
 */
public interface IUserService {

    //新增用户的方法
    void insert(Integer id, String name, Integer age, String email);

    //获取所有的用户
    List<User> select();

    //根据用户id查询用户
    User selectById(Integer id);

    //第二种新增用户的方式
    void insertVo(User user);

    //根据用户id删除用户，删除成功就返回1
    Integer deleteById(Integer userId);

    //根据用户ids删除用户，删除成功就返回删除用户的个数
    Integer deleteByIds(List<Integer> ids);

    //根据id进行修改
    Integer updateById(User user);

}