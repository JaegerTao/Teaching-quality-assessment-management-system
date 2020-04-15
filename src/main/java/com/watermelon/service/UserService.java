package com.watermelon.service;

import com.watermelon.entity.User;

import java.util.List;

public interface UserService {

    List<User> listUser();

    User getUserById(int id);

    User getUserByName(String name);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);

}
