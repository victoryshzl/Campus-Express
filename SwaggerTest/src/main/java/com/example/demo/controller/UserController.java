package com.example.demo.controller;

import com.example.demo.bean.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api")
public class UserController {
    private  final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ApiOperation(value = "获取用户",notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user",value = "用户详细实体user",required = true,dataType = "User")
    @GetMapping("/user")

    public User findByUser(User user){
        logger.info("开始查询用户列表，请求参数：{}",user);
        User user1=new User();
        user1.setId(1L);
        user1.setName("HZL");
        user1.setAge(11);
        return user1;
    }
}
