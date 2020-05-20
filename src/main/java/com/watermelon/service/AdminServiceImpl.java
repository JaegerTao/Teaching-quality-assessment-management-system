package com.watermelon.service;

import com.watermelon.entity.Admin;
import com.watermelon.entity.Teacher;
import com.watermelon.entity.User;
import com.watermelon.mapper.AdminMapper;
import com.watermelon.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Admin getAdminById(int id) {
        return adminMapper.getAdminById(id);
    }

    @Override
    public void addAdmin(Admin admin) {
        admin.setId(adminMapper.getMaxUserId()+1);
        userMapper.addUser(toUser(admin));
        adminMapper.addAdmin(admin);
    }

    @Override
    public void updateAdmin(Admin admin) {
        userMapper.updateUser(toUser(admin));
        adminMapper.updateAdmin(admin);
    }

    @Override
    public void deleteAdmin(int id) {
        adminMapper.deleteAdmin(id);
        userMapper.deleteUser(id);
    }

    @Override
    public int getMaxAdminId() {
        return adminMapper.getMaxUserId();
    }

    /**
     * 将Admin转换为User便于存储和管理
     * @return user User
     */
    public User toUser(Admin admin){
        User user = new User();
        user.setId(admin.getId());
        user.setName(admin.getName());
        user.setPassword(admin.getPassword());
        user.setRoleId(admin.getRole().getId());
        user.setRole(admin.getRole());
        user.setIdNumber(admin.getIdNumber());
        return user;
    }

}
