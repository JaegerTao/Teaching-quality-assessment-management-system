package com.watermelon.service;

import com.watermelon.entity.Admin;
import com.watermelon.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin getAdminById(int id) {
        return adminMapper.getAdminById(id);
    }

    @Override
    public void addAdmin(Admin admin) {
        adminMapper.addAdmin(admin);
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminMapper.updateAdmin(admin);
    }

    @Override
    public void deleteAdmin(int id) {
        adminMapper.deleteAdmin(id);
    }
}
