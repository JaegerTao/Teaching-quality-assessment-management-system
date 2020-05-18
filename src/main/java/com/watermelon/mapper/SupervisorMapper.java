package com.watermelon.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.watermelon.entity.Course;
import com.watermelon.entity.Supervisor;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SupervisorMapper {
    List<Supervisor> getAllSupervisor();

    Supervisor getSupervisorById(int id);

    void addSupervisor(Supervisor supervisor);

    void updateSupervisor(Supervisor supervisor);

    void deleteSupervisor(int id);

    int getMaxSupervisorId();

    List<Supervisor> listSupervisor(Page<Course> page);

}
