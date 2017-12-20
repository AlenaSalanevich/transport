package com.epam.training.transport.service;

import com.epam.training.transport.model.Direction;
import com.epam.training.transport.model.db.entity.ScheduleEntity;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

public interface ScheduleService {

    ScheduleEntity create(
        final long routeId,
        final long transportId,
        final Direction direction,
        final boolean isHoliday,
        final Time startTime,
        final Time endTime);

    List<ScheduleEntity> loadAll(final Optional<Boolean> isHoliday);

    ScheduleEntity load(final long id);

    void delete(final long id);
}
