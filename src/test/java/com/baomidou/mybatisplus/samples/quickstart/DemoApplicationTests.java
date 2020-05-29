package com.baomidou.mybatisplus.samples.quickstart;

import com.baomidou.mybatisplus.samples.quickstart.entity.User;
import com.baomidou.mybatisplus.samples.quickstart.mapper.UserMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class DemoApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    public void contextLoads() {

        System.out.println("Mybatis-Plus入门案例");
        List<User> users = userMapper.selectList(null);
        System.out.println();
        for (User user : users) {
            System.out.println(user);
        }

        //ctrl + alt + v 自动补全返回类型
        System.out.println("删除三个");
        List ids = new ArrayList();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        int count = userMapper.deleteBatchIds(ids);
        List<User> users1 = userMapper.selectList(null);
        System.out.println(count);
        for (User user : users1) {
            System.out.println(user);
        }

    }

}
