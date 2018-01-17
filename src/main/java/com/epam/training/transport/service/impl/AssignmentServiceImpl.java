package com.epam.training.transport.service.impl;

import com.epam.training.transport.model.Direction;
import com.epam.training.transport.model.db.entity.AssignmentEntity;
import com.epam.training.transport.model.db.entity.RouteEntity;
import com.epam.training.transport.model.db.entity.RoutePointEntity;
import com.epam.training.transport.model.db.entity.ScheduleEntity;
import com.epam.training.transport.model.db.repository.AssignmentRepository;
import com.epam.training.transport.rest.models.ScheduleModel;
import com.epam.training.transport.service.RouteService;
import com.epam.training.transport.service.AssignmentService;
import com.epam.training.transport.service.ScheduleService;
import com.epam.training.transport.service.TransportService;
import com.epam.training.transport.service.exceptions.ErrorCode;
import com.epam.training.transport.service.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author Alena_Salanevich
 */

@Transactional
@Service("assignmentService")
public class AssignmentServiceImpl implements AssignmentService {

    @Autowired
    AssignmentRepository assignmentRepository;
    @Autowired
    TransportService transportService;
    @Autowired
    ScheduleService scheduleService;
    @Autowired
    RouteService routeService;

    @Override
    public AssignmentEntity create(
            final long transportId,
            final long routeId,
            final Direction direction,
            final boolean isHoliday,
            final List<ScheduleModel> scheduleModels) {
        final AssignmentEntity assignment = new AssignmentEntity();
        RouteEntity routeEntity = routeService.load(routeId);
        List<RoutePointEntity> routePoints = routeEntity.getRoutePoints();
        Collections.sort(scheduleModels);
        if (routePoints.size() == scheduleModels.size()) {

            List<ScheduleEntity> scheduleEntities = new ArrayList<>();

            switch (direction) {
                case DIRECT: {
                    Collections.sort(routePoints);
                }
                break;

                case REVERSE: {
                    routePoints.sort(Collections.reverseOrder());
                    break;
                }
            }

            for (ScheduleModel scheduleModel : scheduleModels) {
                RoutePointEntity routePointEntity = routeService.loadByPoint(routeId, scheduleModel.getPointId());
                if ((routePoints.contains(routePointEntity)) && (routePoints.indexOf(routePointEntity) == scheduleModels.indexOf(scheduleModel))) {

                    scheduleEntities.add(new ScheduleEntity(assignment, routePointEntity, scheduleModel.getDepartureTime()));
                }
            }
            if (scheduleEntities.size() == routePoints.size()) {
                assignment.setRoute(routeEntity);
                assignment.setTransport(transportService.load(transportId));
                assignment.setDirection(direction);
                assignment.setHoliday(isHoliday);
                assignment.setScheduleEntities(scheduleEntities);
                assignmentRepository.save(assignment);
                return assignment;
            }
            throw new ServiceException(ErrorCode.INCORRECT_ORDER, "Please, set the departure time for all points in the route in accordance with sequence of points and direction.");
        } else {
            throw new ServiceException(ErrorCode.INCORRECT_ORDER, "The route contains " + routePoints.size() + " points. Please set the departure time for all points.");
        }
    }


    @Override
    public List<AssignmentEntity> loadAll(final Optional<Boolean> optIsHoliday) {

        return optIsHoliday.map(isHoliday -> assignmentRepository.findAllByIsHoliday(isHoliday))
                .orElseGet(() -> assignmentRepository.findAll());
    }

    @Override
    public AssignmentEntity load(final long id) {
        return assignmentRepository.findOne(id);
    }

    @Override
    public void delete(final long id) {
        scheduleService.deleteByAssignment(id);
        assignmentRepository.delete(id);
    }
}
