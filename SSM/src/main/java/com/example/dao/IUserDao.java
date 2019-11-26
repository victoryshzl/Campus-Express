package com.example.dao;

import com.example.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserDao {

    @Select("select * from user")
    public List<User> findAll();
    @Insert("insert into user (name,money) value (#{name},#{money})")
    public void saveUser(User user);
}
