package com.user.service;

import com.user.mapper.UserMapper;
import com.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserMapper userMapper;

    public List<User> queryAllUsers(){
        return userMapper.queryAllUsers();
    }

    public User queryUserById(int id){
        return userMapper.queryUserById(id);
    }

    public void addUser(User user){
        userMapper.addUser(user);
    }

    public void updateUser(User user){
        userMapper.updateUser(user);
    }

    public void deleteUser(User user){
        userMapper.deleteUserById(user.getUserId());
    }
}
