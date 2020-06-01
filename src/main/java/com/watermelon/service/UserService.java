package com.watermelon.service;

import com.watermelon.entity.Query;
import com.watermelon.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {

    int registerUser(String username,String password);

    User getUserById(int id);

    User getUserByName(String name);

    String getNameById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);

    List<User> listUser(int startPage, int pageSize);

    int getMaxUserId();

    String encodeMD5(String str);

}
