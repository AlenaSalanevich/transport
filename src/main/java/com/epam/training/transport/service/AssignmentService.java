package com.epam.training.transport.service;

import com.epam.training.transport.model.Direction;
import com.epam.training.transport.model.db.entity.AssignmentEntity;
import com.epam.training.transport.rest.models.ScheduleModel;

import java.util.List;
import java.util.Optional;

/**
 * @author Alena_Salanevich
 */

public interface AssignmentService {

    AssignmentEntity create(
            final long routeId,
            final long transportId,
            final Direction direction,
            final boolean isHoliday,
            final List<ScheduleModel> scheduleModel);

    List<AssignmentEntity> loadAll(final Optional<Boolean> isHoliday);

    AssignmentEntity load(final long id);

    void delete(final long id);

    AssignmentEntity update(final long id, final AssignmentEntity assignmentEntity);
}
