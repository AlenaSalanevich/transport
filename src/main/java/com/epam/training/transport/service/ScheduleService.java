package com.epam.training.transport.service;

import com.epam.training.transport.model.db.entity.ScheduleEntity;

import java.util.List;

/**
 * @author Alena_Salanevich
 */

public interface ScheduleService {

    List<ScheduleEntity> loadAll();
}
