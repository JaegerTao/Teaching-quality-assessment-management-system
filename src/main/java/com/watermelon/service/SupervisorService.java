package com.watermelon.service;

import com.watermelon.entity.Supervisor;

public interface SupervisorService {

    Supervisor getSupervisorById(int id);

    void addSupervisor(Supervisor supervisor);

    void updateSupervisor(Supervisor supervisor);

    void deleteSupervisor(int id);

}
