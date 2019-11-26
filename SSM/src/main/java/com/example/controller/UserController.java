package com.example.controller;

import com.example.domain.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/findAll")
    public String findAll(Model model){ //存数据，Model对象
        System.out.println("Controller表现层：查询所有账户...");
        //调用service方法
        List<User> list=userService.findAll();
        model.addAttribute("list",list);
        return "list";
    }

    @RequestMapping("/user/save")
    public void save(User user, HttpServletRequest request, HttpServletResponse response) throws IOException{
        userService.saveUser(user);
        response.sendRedirect(request.getContextPath()+"/user/findAll");
        return;
    }
}
