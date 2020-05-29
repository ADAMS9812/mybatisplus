package com.baomidou.mybatisplus.samples.quickstart;

import com.baomidou.mybatisplus.samples.quickstart.entity.User;
import com.baomidou.mybatisplus.samples.quickstart.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Springboot整合MybatisPlus进行CRUD的操作
 */

@SpringBootTest
public class DemoApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    public void contextLoads() {

        System.out.println("Mybatis-Plus入门案例");
        //查询所有数据并返回一个集合
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
        //删除指定的数据集合
        int count = userMapper.deleteBatchIds(ids);
        //重新查询数据
        List<User> users1 = userMapper.selectList(null);
        System.out.println(count);

        for (User user : users1) {
            System.out.println(user);
        }

    }

    /**
     * 新增方法
     */
    @Test
    public void insert(){

        //定义一个user
        User user = new User();
        user.setId(7);
        user.setAge(21);
        user.setName("世文啊啊啊啊啊");
        user.setEmail("-----yshiwen@qq.com");

        userMapper.insert(user);

    }

    /**
     * 更新方法
     */
    @Test
    public void update(){

        User user = new User();
        user.setId(7);
        user.setAge(222);
        user.setName("世文测试");
        user.setEmail("test：yshiwen@qq.com");

        userMapper.updateById(user);

    }

    /**
     *
     */
    @Test
    public void delete(){

        //数字数组
        List ids = new ArrayList();
        ids.add(4);
        ids.add(5);

        //批量删除
        int counts = userMapper.deleteBatchIds(ids);
        System.out.println("集合性删除：" + counts);

        //单独删除
        int count = userMapper.deleteById(6);
        System.out.println("单独删除：" + count);

    }

    @Test
    public void select(){

        //根据id进行查询
        User user = userMapper.selectById(7);
        System.out.println(user + "\n");

        //数字集合
        List list = new ArrayList();
        list.add(8);
        list.add(9);
        //根据id集合进行查询
        List users = userMapper.selectBatchIds(list);
        System.out.println(users + "\n");

    }

}
