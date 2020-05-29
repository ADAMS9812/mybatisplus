package com.baomidou.mybatisplus.samples.quickstart;

import com.baomidou.mybatisplus.samples.quickstart.entity.User;
import com.baomidou.mybatisplus.samples.quickstart.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
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

    }

}
