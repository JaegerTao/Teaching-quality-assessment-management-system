package com.watermelon.mapper;

import com.watermelon.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdminMapper {

    Admin getAdminById(int id);

    void addAdmin(Admin admin);

    void updateAdmin(Admin admin);

    void deleteAdmin(int id);

}
