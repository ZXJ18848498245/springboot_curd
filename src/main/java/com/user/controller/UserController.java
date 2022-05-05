package com.user.controller;

import com.sun.org.apache.bcel.internal.generic.NEWARRAY;
import com.user.pojo.User;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public List<String> getAllUsers(){
        List<String> list = new ArrayList<>();
        for(User user : userService.queryAllUsers()){
            list.add(user.toString());
        }
        return list;
    }

    @GetMapping(value = "/user/{id}")
    public String getUserById(@PathVariable(value = "id") int id){
        User user = userService.queryUserById(id);
        System.out.println(user.toString());
       // return userService.queryUserById(id).getUserName();
        return  user.toString();
    }

    @GetMapping(value = "/add")
    public String addUser(){
        User user = new User();
        user.setUserName("小米");
        user.setUserPassword("123456");
        userService.addUser(user);
        return "ok";
    }

    @GetMapping(value = "/update/{id}")
    public String uodateUser(@PathVariable int id){
        User user = userService.queryUserById(id);
        user.setUserName("小明");
        userService.updateUser(user);
        return "ok";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable int id){
        User user = userService.queryUserById(id);
        userService.deleteUser(user);
        return "ok";
    }


}
