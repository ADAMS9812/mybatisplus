package com.baomidou.mybatisplus.samples.quickstart.controller;

import com.baomidou.mybatisplus.samples.quickstart.entity.ResultJson;
import com.baomidou.mybatisplus.samples.quickstart.service.IUserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
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
    public ResultJson insert(@RequestParam Integer id, @RequestParam String name, @RequestParam Integer age, @RequestParam String email){
        //将四个参数传到持久层进行持久化操作
        userService.insert(id, name, age, email);
        return ResultJson.ok();
    }

}
