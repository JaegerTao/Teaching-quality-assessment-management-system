package com.watermelon.mapper;

import com.watermelon.entity.Supervisor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SupervisorMapper {

    Supervisor getSupervisorById(int id);

    void addSupervisor(Supervisor supervisor);

    void updateSupervisor(Supervisor supervisor);

    void deleteSupervisor(int id);

    int getMaxSupervisorId();

}
