package com.watermelon.service;

import com.watermelon.entity.Supervisor;
import com.watermelon.mapper.SupervisorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupervisorServiceImpl implements SupervisorService {

    @Autowired
    private SupervisorMapper supervisorMapper;

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
}
