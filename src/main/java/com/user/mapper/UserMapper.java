package com.user.mapper;

import com.user.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    List<User> queryAllUsers();

    User queryUserById(int id);

    void addUser(User user);

    void updateUser(User user);

    void deleteUserById(int userId);
}
