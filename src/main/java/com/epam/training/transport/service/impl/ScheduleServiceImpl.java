package com.epam.training.transport.service.impl;

/**
 * @author Alena_Salanevich
 */

import com.epam.training.transport.model.db.entity.ScheduleEntity;
import com.epam.training.transport.model.db.repository.ScheduleRepository;
import com.epam.training.transport.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("scheduleService")
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;

    @Override
    public List<ScheduleEntity> loadAll() {
        return scheduleRepository.findAll();
    }
}
