package com.epam.training.transport.service;

import com.epam.training.transport.model.Direction;
import com.epam.training.transport.model.db.entity.RouteEntity;
import com.epam.training.transport.model.db.entity.ScheduleEntity;
import com.epam.training.transport.model.db.entity.TransportEntity;

import java.sql.Time;
import java.util.List;

public interface ScheduleService {

    ScheduleEntity create(
            long routeId,
            long transportId,
            Direction direction,
            boolean isHoliday,
            Time startTime,
            Time endTime);

    List<ScheduleEntity> loadAll();

    ScheduleEntity load(long id);

    void delete (long id);
}
