package com.epam.training.transport.service.impl;

import com.epam.training.transport.model.Direction;
import com.epam.training.transport.model.db.entity.ScheduleEntity;
import com.epam.training.transport.model.db.repository.ScheduleRepository;
import com.epam.training.transport.service.RouteService;
import com.epam.training.transport.service.ScheduleService;
import com.epam.training.transport.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Time;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Transactional
@Service("scheduleService")
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;
    @Autowired
    TransportService transportService;

    @Autowired
    RouteService routeService;

    @Override
    public ScheduleEntity create(
        final long routeId,
        final long transportId,
        final Direction direction,
        final boolean isHoliday) {
        ScheduleEntity schedule = new ScheduleEntity();
        schedule.setRoute(routeService.load(routeId));
        schedule.setTransport(transportService.load(transportId));
        schedule.setDirection(direction);
        schedule.setHoliday(isHoliday);
        scheduleRepository.save(schedule);
        return schedule;
    }

    @Override
    public List<ScheduleEntity> loadAll(final Optional<Boolean> optIsHoliday) {

      return  optIsHoliday.map(isHoliday -> scheduleRepository.findAllByIsHoliday(isHoliday)).orElseGet(()-> scheduleRepository.findAll());
    }

    @Override
    public ScheduleEntity load(final long id) {
        return scheduleRepository.findOne(id);
    }

    @Override
    public void delete(final long id) {
        scheduleRepository.delete(id);
    }
}
