package com.watermelon.service;

import com.watermelon.entity.Admin;

public interface AdminService {

    Admin getAdminById(int id);

    void addAdmin(Admin admin);

    void updateAdmin(Admin admin);

    void deleteAdmin(int id);

    int getMaxAdminId();
}
