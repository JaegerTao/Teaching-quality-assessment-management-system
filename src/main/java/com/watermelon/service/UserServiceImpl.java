package com.watermelon.service;

import com.watermelon.entity.Role;
import com.watermelon.entity.User;
import com.watermelon.mapper.RoleMapper;
import com.watermelon.mapper.UserMapper;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleService roleService;

    @Override
    public int registerUser(String username,String password){
        int count = userMapper.getUserNumber();
        User user = new User();
        user.setId(count+1);
        user.setName(username);
//        user.setPassword(password);
        user.setPassword(encodeMD5(password));
        return addUser(user);
    }

    @Override
    public User getUserById(int id) {
        User user = userMapper.getUserById(id);
        user.setRole(roleMapper.getRoleById(user.getRoleId()));
        return user;
    }

    @Override
    public User getUserByName(String name) {
        User user = userMapper.getUserByName(name);
        user.setRole(roleMapper.getRoleById(user.getRoleId()));
        return user;
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int updateUser(User user) {
        User user1 = userMapper.getUserById(user.getId());
        if (user1==null){
            return -1;
        }
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public List<User> listUser() {
        List<User> list = userMapper.listUser();
        for (User user : list){
            Role role = roleService.getRoleById(user.getRoleId());
            user.setRole(role);
        }
        return list;
    }


    /**
     * 使用Shiro提供的Md5Hash类对密码进行加密
     * @param password
     * @return
     */
    public String encodeMD5(String password){
        return  new Md5Hash(password).toHex();
    }

    /**
     * 使用Shiro提供的Md5Hash类对密码进行盐值加密,此处盐值为username
     * @param password
     * @param salt
     * @return
     */
    public String encodeMD5Salt(String password,String salt){
        return  new Md5Hash(password,salt,1).toHex();
    }

}
