package com.watermelon.service;

import com.watermelon.entity.Supervisor;

import java.util.List;

public interface SupervisorService {

    Supervisor getSupervisorById(int id);

    void addSupervisor(Supervisor supervisor);

    void updateSupervisor(Supervisor supervisor);

    void deleteSupervisor(int id);

    List<Supervisor> listSupervisor();

}
