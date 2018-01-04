package com.epam.training.transport.service.impl;

import com.epam.training.transport.model.Direction;
import com.epam.training.transport.model.db.entity.AssignmentEntity;
import com.epam.training.transport.model.db.repository.AssignmentRepository;
import com.epam.training.transport.service.RouteService;
import com.epam.training.transport.service.AssignmentService;
import com.epam.training.transport.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
    RouteService routeService;

    @Override
    public AssignmentEntity create(
        final long routeId,
        final long transportId,
        final Direction direction,
        final boolean isHoliday) {
        final AssignmentEntity assignment = new AssignmentEntity();
        assignment.setRoute(routeService.load(routeId));
        assignment.setTransport(transportService.load(transportId));
        assignment.setDirection(direction);
        assignment.setHoliday(isHoliday);
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
}
