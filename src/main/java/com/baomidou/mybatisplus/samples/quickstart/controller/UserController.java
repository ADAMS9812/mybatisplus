package com.baomidou.mybatisplus.samples.quickstart.controller;

import com.baomidou.mybatisplus.samples.quickstart.entity.ResultJson;
import com.baomidou.mybatisplus.samples.quickstart.entity.User;
import com.baomidou.mybatisplus.samples.quickstart.mapper.UserMapper;
import com.baomidou.mybatisplus.samples.quickstart.service.IUserService;
import com.baomidou.mybatisplus.samples.quickstart.utils.ArrayToList;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 为什么不直接用Vo对象存数据？前端传什么我们就接收什么了
     *
     * 新增用户的方法：记得这里的paramType意思是以参数的形式进行传递，而不是PathVariable
     *
     * @param id
     * @param name
     * @param age
     * @param email
     * @return
     */
    @ApiOperation(value = "新增用户", httpMethod = "POST")
    @PostMapping(value = "/insert")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "用户id", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "name", value = "用户姓名", required = true, dataType = "string"),
            @ApiImplicitParam(paramType = "query", name = "age", value = "用户年龄", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "email", value = "用户邮箱", required = true, dataType = "string")
    })
    public ResultJson insert(@RequestParam Integer id, @RequestParam String name, @RequestParam Integer age, @RequestParam String email) {
        //将四个参数传到持久层进行持久化操作
        userService.insert(id, name, age, email);
        return ResultJson.ok();
    }

    /**
     * 查询所有用户的方法
     *
     * @return
     */
    @ApiOperation(value = "查询所有用户", httpMethod = "GET")
    @GetMapping("/select")
    public ResultJson select(){
        //查询所有用户
        List<User> users = userService.select();
        //返回所有用户的数据给前端
        return ResultJson.ok(users);
    }

    /**
     * 根据用户id查询一个用户
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "根据用户id查询用户", httpMethod = "GET")
    @GetMapping("selectById")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "query", name = "id", value = "用户id", required = true, dataType = "int") })
    public ResultJson selectById(@RequestParam Integer id){
        //根据用户id查询一个用户
        User user = userService.selectById(id);
        //返回一个用户
        return ResultJson.ok(user);
    }

    /**
     * 第二种新增用户的方式
     *
     * @ApiImplicitParams({
     *             @ApiImplicitParam(paramType = "query", name = "id", value = "用户id", required = true, dataType = "int"),
     *             @ApiImplicitParam(paramType = "query", name = "name", value = "用户名", required = true, dataType = "string"),
     *             @ApiImplicitParam(paramType = "query", name = "age", value = "用户年龄", required = true, dataType = "int"),
     *             @ApiImplicitParam(paramType = "query", name = "email", value = "用户邮箱", required = true, dataType = "string")
     * })
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "新增用户的第二种方式", httpMethod = "POST")
    @PostMapping("/insertVo")
    public ResultJson insertVo(User user){
        userService.insertVo(user);
        return ResultJson.ok();
    }

    /**
     * 根据用户id删除一个用户
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除一个用户", httpMethod = "DELETE")
    @DeleteMapping("/deleteById")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "query", name = "id", value = "要删除的用户id", dataType = "int") })
    public ResultJson deleteById(@RequestParam Integer id){
        Integer count = userService.deleteById(id);
        return ResultJson.ok(count);
    }

    /**
     * 根据ids（用户id集合）来删除数据
     *
     * @param ids
     * @return
     */
    @ApiOperation(value = "删除一群用户", httpMethod = "DELETE")
    @DeleteMapping("/deleteByIds")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "query", name = "ids", value = "用户id群", allowMultiple=true, dataType = "int") })
    public ResultJson deleteByIds(Integer[] ids){
        //这里我们要将数组转集合再传
        List<Integer> list = ArrayToList.toList(ids);
        Integer counts = userService.deleteByIds(list);
        //将转好的数据类型进行返回
        return ResultJson.ok(counts);
    }

    /**
     * 根据用户id进行更新操作
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "根据用户id更新用户信息", httpMethod = "PUT")
    @PutMapping("/updateById")
    public ResultJson updateById(User user){
        //根据用户id进行更新操作
        Integer count = userService.updateById(user);
        return ResultJson.ok(count);
    }

}