package com.watermelon.service;

import com.watermelon.entity.User;

import java.util.List;

public interface UserService {

    int registerUser(String username,String password);

    User getUserById(int id);

    User getUserByName(String name);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);

    List<User> listUser();

    int getMaxUserId();
}
