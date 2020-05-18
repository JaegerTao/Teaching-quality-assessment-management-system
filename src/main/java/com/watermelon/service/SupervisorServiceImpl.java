package com.watermelon.service;

import com.watermelon.entity.Supervisor;
import com.watermelon.mapper.SupervisorCourseMapper;
import com.watermelon.mapper.SupervisorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupervisorServiceImpl implements SupervisorService {

    @Autowired
    private SupervisorMapper supervisorMapper;

    @Autowired
    private SupervisorCourseMapper supervisorCourseMapper;

    @Override
    public List<Supervisor> getAllSupervisor() {
        return supervisorMapper.getAllSupervisor();
    }

    @Override
    public int addSupervisorCourse(int supervisorId, int courseId, int teacherId) {
        return supervisorCourseMapper.addSupervisorCourse(supervisorId,courseId,teacherId);
    }

    @Override
    public int deleteSupervisorCourse(int supervisorId, int courseId, int teacherId) {
        return supervisorCourseMapper.deleteSupervisorCourse(supervisorId,courseId,teacherId);
    }


    @Override
    public Supervisor getSupervisorById(int id) {
        return supervisorMapper.getSupervisorById(id);
    }

    @Override
    public void addSupervisor(Supervisor supervisor) {
        supervisor.setId(supervisorMapper.getMaxSupervisorId()+1);
        supervisorMapper.addSupervisor(supervisor);
    }

    @Override
    public void updateSupervisor(Supervisor supervisor) {
        Supervisor s = getSupervisorById(supervisor.getId());
        if (s!=null){
            supervisorMapper.updateSupervisor(supervisor);
        }
    }

    @Override
    public void deleteSupervisor(int id) {
        supervisorMapper.deleteSupervisor(id);
    }

    @Override
    public List<Supervisor> listSupervisor() {
        return supervisorMapper.listSupervisor();
    }
}
