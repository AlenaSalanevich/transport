package com.epam.training.transport.service.impl;

import com.epam.training.transport.model.db.entity.PointEntity;
import com.epam.training.transport.model.db.entity.RouteEntity;
import com.epam.training.transport.model.db.entity.RoutePointEntity;
import com.epam.training.transport.model.db.repository.RoutePointRepository;
import com.epam.training.transport.model.db.repository.RouteRepository;
import com.epam.training.transport.service.PointService;
import com.epam.training.transport.service.RouteService;
import com.epam.training.transport.service.exceptions.ErrorCode;
import com.epam.training.transport.service.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Transactional
@Service("routeService")
public class RouteServiceImpl implements RouteService {

    @Autowired
    RouteRepository routeRepository;

    @Autowired
    RoutePointRepository routePointRepository;

    @Autowired
    PointService pointService;

    public RouteServiceImpl(final RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public RouteEntity create(final String number, final String description) {

        final RouteEntity route = new RouteEntity();
        route.setNumber(number);
        route.setDescription(description);
        routeRepository.save(route);

        return route;
    }

    @Override
    public RouteEntity deletePointFromRoute(final long routeId, final long pointId) {
        final RouteEntity route = load(routeId);
        final List<RoutePointEntity> routePoints = route.getRoutePoints();
        Collections.sort(routePoints);

        final Optional<RoutePointEntity> optional =
            routePoints.stream()
                .filter(routePoint -> routePoint.getPoint()
                    .getId() == pointId)
                .findFirst();
        if (optional.isPresent()) {
            final int position = routePoints.indexOf(optional.get());

            final List<RoutePointEntity> upRoutePoints =
                Stream.concat(routePoints.stream()
                    .limit(position), routePoints.stream()
                        .skip(position)
                        .filter(routePoint -> routePoint.getPoint()
                            .getId() != pointId)
                        .map(routePointEntity -> {
                            routePointEntity.setSequence(routePointEntity.getSequence() - 1);
                            return routePointEntity;
                        })
                        .sorted())
                    .collect(Collectors.toList());

            route.setRoutePoints(upRoutePoints);
            routeRepository.save(route);
        } else {
            throw new ServiceException(ErrorCode.NOT_FOUND);
        }

        return route;
    }

    @Override
    public RouteEntity addPointToRoute(long routeId, long pointId) {
        final RouteEntity route = load(routeId);
       route.getRoutePoints().stream().sorted(Comparator.comparingInt(RoutePointEntity::getSequence));

        return null;
    }

    @Override
    public void delete(final long id) {
        routeRepository.delete(id);
    }

    @Override
    public List<RouteEntity> loadAll() {

        return routeRepository.findAll()
            .stream()
            .map(routeEntity -> {
                routeEntity.getRoutePoints()
                    .sort(Comparator.comparingInt(RoutePointEntity::getSequence));
                return routeEntity;
            })
            .collect(Collectors.toList());
    }

    @Override
    public RouteEntity load(final String number) {
        return routeRepository.findByNumberLike(number);
    }

    @Override
    public RouteEntity load(final long id) {
        return routeRepository.findOne(id);
    }

    @Override
    public RouteEntity insertPointToRoute(final long routeId, final long pointId, final int sequence) {

        final RouteEntity route = load(routeId);
        final PointEntity point = pointService.load(pointId);

        final List<RoutePointEntity> routePointsList = route.getRoutePoints();
        routePointsList.sort(Comparator.comparingInt(RoutePointEntity::getSequence));

        final Optional<RoutePointEntity> optional =
            routePointsList.stream()
                .filter(rp -> rp.getSequence() == sequence)
                .findFirst();

        if (optional.isPresent()) {
            final int position = routePointsList.indexOf(optional.get());

            final List<RoutePointEntity> upRoutePointList =
                Stream.concat(Stream.concat(routePointsList.stream()
                    .limit(position), Stream.of(new RoutePointEntity(route, point, sequence))), routePointsList
                        .stream()
                        .skip(position)
                        .map(routePointEntity -> {
                            routePointEntity.setSequence(routePointEntity.getSequence() + 1);
                            return routePointEntity;
                        })
                        .sorted(Comparator.comparingInt(RoutePointEntity::getSequence)))
                    .collect(Collectors.toList());

            route.setRoutePoints(upRoutePointList);
            routeRepository.save(route);
        } else {
            routePointsList.add(new RoutePointEntity(route, point, sequence));
            routePointsList.sort(Comparator.comparingInt(RoutePointEntity::getSequence));
            routeRepository.save(route);
        }
        return route;
    }
}
