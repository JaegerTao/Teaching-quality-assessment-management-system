package com.watermelon.service;

import com.watermelon.entity.Supervisor;
import net.bytebuddy.implementation.bind.annotation.Super;

import java.util.List;

public interface SupervisorService {
    List<Supervisor> getAllSupervisor();

    // 设置督导可评价的课程
    int addSupervisorCourse(int supervisorId, int courseId, int teacherId);
    int deleteSupervisorCourse(int supervisorId, int courseId, int teacherId);

    Supervisor getSupervisorById(int id);

    void addSupervisor(Supervisor supervisor);

    void updateSupervisor(Supervisor supervisor);

    void deleteSupervisor(int id);

}
