package com.example.service;

import com.example.domain.User;

import java.util.List;

public interface UserService {
    //查询所有账户
    public List<User> findAll();
    // 保存帐户信息
    public void saveUser(User user);
}
