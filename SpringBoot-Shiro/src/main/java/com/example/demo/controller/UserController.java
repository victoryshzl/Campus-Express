package com.example.demo.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/user")
@Controller
public class UserController {
    @RequiresPermissions("user:list")
    @ResponseBody
    @RequestMapping("/show")
    public String showUser(){
        return "学生信息";
    }
}
