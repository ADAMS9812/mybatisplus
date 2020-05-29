package com.baomidou.mybatisplus.samples.quickstart.service.impl;

import com.baomidou.mybatisplus.samples.quickstart.entity.User;
import com.baomidou.mybatisplus.samples.quickstart.mapper.UserMapper;
import com.baomidou.mybatisplus.samples.quickstart.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户service层实现类
 */

@Service
public class UserServiceImpl implements IUserService{

    @Resource
    private UserMapper userMapper;

    /**
     * 新增用户
     *
     * @param id
     * @param name
     * @param age
     * @param email
     */
    @Override
    public void insert(Integer id, String name, Integer age, String email) {

        //创建一个User用户接受对象数据
        User user = new User(id,name,age,email);
        //新增一个用户到数据库
        userMapper.insert(user);

    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @Override
    public List<User> select() {
        //查询并返回所有用户
        return userMapper.selectList(null);
    }

    /**
     * 根据用户id查询所有用户
     *
     * @param id
     * @return
     */
    @Override
    public User selectById(Integer id) {
        return userMapper.selectById(id);
    }

    /**
     * 新增用户
     * @param user
     */
    @Override
    public void insertVo(User user) {
        userMapper.insert(user);
    }

    /**
     * 根据用户id删除一个用户，并返回删除的个数（一个）
     *
     * @param userId
     * @return
     */
    @Override
    public Integer deleteById(Integer userId) {
        return userMapper.deleteById(userId);
    }

    /**
     * 根据集合删除用户（多个）
     *
     * @param ids
     * @return
     */
    @Override
    public Integer deleteByIds(List<Integer> ids) {
        return userMapper.deleteBatchIds(ids);
    }

    /**
     * 根据用户id进行更新操作
     *
     * @param user
     * @return
     */
    @Override
    public Integer updateById(User user) {
        return userMapper.updateById(user);
    }


}