package com.example.service.impl;

import com.example.dao.IUserDao;
import com.example.domain.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private IUserDao iUserDao;
    @Override
    public List<User> findAll(){
        System.out.println("Service业务层：查询所有账户。。。");
        return iUserDao.findAll();
    }

    @Override
    public void saveUser(User user){
        System.out.println("Service业务层：保护账户");
        iUserDao.saveUser(user);//调用service中的saveUser(user)方法
    }
}
