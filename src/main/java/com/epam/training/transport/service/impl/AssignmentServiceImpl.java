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
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

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
        if (routePoints.size() != scheduleModels.size()) {
            throw new ServiceException(ErrorCode.INCORRECT_ORDER, "The route contains " + routePoints.size() + " points. Please set the departure time for all points.");
        }
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
            long pointId = scheduleModel.getPointId();
            int pointPosition = findPointPosition(pointId, routePoints);
            int modelPosition = scheduleModels.indexOf(scheduleModel);
            if (pointPosition == modelPosition) {

                scheduleEntities.add(new ScheduleEntity(assignment, routePoints.get(pointPosition), scheduleModel.getDepartureTime()));
            }
        }
        if (scheduleEntities.size() != routePoints.size()) {
            throw new ServiceException(ErrorCode.INCORRECT_ORDER, "Please, set the departure time for all points in the route in accordance with sequence of points and direction.");
        }
        assignment.setRoute(routeEntity);
        assignment.setTransport(transportService.load(transportId));
        assignment.setDirection(direction);
        assignment.setHoliday(isHoliday);
        assignment.setScheduleEntities(scheduleEntities);
        assignmentRepository.save(assignment);
        return assignment;
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
        assignmentRepository.delete(id);
    }

    @Override
    public int findPointPosition(final long pointId, List<RoutePointEntity> routePointEntities) {

        Optional<Integer> position = routePointEntities.stream().filter(routePointEntity -> routePointEntity.getPoint().getId() == pointId).findFirst().map(routePointEntity -> routePointEntities.indexOf(routePointEntity));
        if (position.isPresent()) {
            return position.get();
        } else throw new ServiceException(ErrorCode.NOT_FOUND, "The route doesn't contain point with id = " + pointId);
    }

    @Override
    public AssignmentEntity update(long id, AssignmentEntity assignmentEntity) {

        try {
            assignmentRepository.save(assignmentEntity);
        } catch (DataIntegrityViolationException e) {
            throw new ServiceException(ErrorCode.NAME_ALREADY_EXISTS, e, "The route " + assignmentEntity.getRoute().getNumber() + "with direction " + assignmentEntity.getDirection() + "already exists.");
        }

        return assignmentEntity;
    }
}
