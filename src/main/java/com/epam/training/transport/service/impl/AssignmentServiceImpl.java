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

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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
        assignment.setTransport(transportService.load(transportId));
        assignment.setDirection(direction);
        assignment.setHoliday(isHoliday);

      /*  List<RoutePointEntity> routePointEntitiesModel = new ArrayList<>();
        for (ScheduleModel scheduleModel : scheduleModels) {
            routePointEntitiesModel.add(routeService.loadByPoint(routeId, scheduleModel.getPointId()));
        }
        routePointEntitiesModel.stream().sorted(Comparator.comparingInt(RoutePointEntity::getSequence)).collect(Collectors.toList());*/

        List<RoutePointEntity> routePointEntities = routeEntity.getRoutePoints().stream().sorted(Comparator.comparingInt(RoutePointEntity::getSequence)).collect(Collectors.toList());
        scheduleModels.stream().sorted(Comparator.comparingInt(ScheduleModel::getDepartureTime)).forEach(s -> {
            RoutePointEntity routePouint = routePointEntities.remove(0);
            if (s.getPointId() != routePouint.getPoint().getId()) {
                throw new ServiceException(ErrorCode.REQUIRED_FIELD);
            }

            new ScheduleEntity(assignment, routePouint, s.getDepartureTime()));
        });



        // 1. достато пары время -> сиквенс
        // 2. отсортировать по сиквенсу - 1 лист
        // 3. остортировать по времени - 2й лист
        // 4. написать компоратор по сиквесу и времени
        // 5. сравнить 2 листа


        if (routePointEntities.equals(routePointEntitiesModel)) {


            for (ScheduleModel scheduleModel : scheduleModels) {

                routePointEntities
                        .stream()
                        .filter(routePointEntity -> routePointEntity.getPoint()
                                .getId() == scheduleModel.getPointId())
                        .findFirst()
                        .map(routePointEntity -> routePointEntity.getScheduleEntities()
                                .add(new ScheduleEntity(assignment, routePointEntity, scheduleModel.getDepartureTime())))
                        .orElseThrow(() -> new ServiceException(ErrorCode.NOT_FOUND));
            }

            List<RoutePointEntity> routePointEntitiesByTime = routePointEntities.stream().sorted(Comparator.comparingInt(RoutePointEntity::)).collect(Collectors.toList());
            if (routePointEntities.equals(routePointEntitiesByTime)) {

                assignment.setRoute(routeEntity);
                assignmentRepository.save(assignment);

                return assignment;

        } else {
            throw new ServiceException(ErrorCode.REQUIRED_FIELD);
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
