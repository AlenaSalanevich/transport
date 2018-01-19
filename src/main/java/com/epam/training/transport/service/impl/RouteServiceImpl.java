package com.epam.training.transport.service.impl;

import com.epam.training.transport.model.db.entity.PointEntity;
import com.epam.training.transport.model.db.entity.RouteEntity;
import com.epam.training.transport.model.db.entity.RoutePointEntity;
import com.epam.training.transport.model.db.repository.RoutePointRepository;
import com.epam.training.transport.model.db.repository.RouteRepository;
import com.epam.training.transport.rest.models.AddPointModel;
import com.epam.training.transport.service.PointService;
import com.epam.training.transport.service.RouteService;
import com.epam.training.transport.service.exceptions.ErrorCode;
import com.epam.training.transport.service.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Alena_Salanevich
 */

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
    public List<RouteEntity> loadAll() {

        return routeRepository.findAll().stream()
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
    public List<RoutePointEntity> loadPoints(long routeId) {
        return routeRepository.findOne(routeId)
                .getRoutePoints();
    }

    @Override
    public RouteEntity create(final String number, final String description) {
        final RouteEntity route = new RouteEntity(number, description);
        try {
            routeRepository.save(route);
        } catch (DataIntegrityViolationException e) {
            throw new ServiceException(ErrorCode.NAME_ALREADY_EXISTS, e, "Route with number " + number + " already exists.");
        }
        return route;
    }

    @Override
    public RouteEntity insertPoints(long routeId, List<AddPointModel> points) {
        RouteEntity route = load(routeId);

        for (AddPointModel point : points) {
            insertPoint(routeId, point.getPointId(), point.getSequense());
        }
        return route;
    }

    @Override
    public RouteEntity update(long routeId, RouteEntity routeEntity) {
        try {
            routeRepository.save(routeEntity);
        } catch (final DataIntegrityViolationException e) {
            throw new ServiceException(ErrorCode.NAME_ALREADY_EXISTS, e, "Route with number: " + routeEntity.getNumber() + " already exists.");
        }
        return routeEntity;
    }

    @Override
    public RouteEntity insertPoint(final long routeId, final long pointId, final int sequence) {

        final RouteEntity routeEntity = load(routeId);
        final PointEntity pointEntity = pointService.load(pointId);

        final List<RoutePointEntity> routePointsList =
                routeEntity.getRoutePoints()
                        .stream()
                        .sorted(Comparator.comparingInt(RoutePointEntity::getSequence))
                        .collect(Collectors.toList());

        final Integer position =
                routePointsList.stream()
                        .filter(rp -> rp.getSequence() == sequence)
                        .findFirst()
                        .map(rp -> routePointsList.indexOf(rp))
                        .orElse(routePointsList.size() + 1);

        final List<RoutePointEntity> upRoutePointList =
                Stream.concat(Stream.concat(routePointsList.stream()
                        .limit(position), Stream.of(new RoutePointEntity(routeEntity, pointEntity, sequence))), routePointsList.stream()
                        .skip(position)
                        .map(routePointEntity -> {
                            routePointEntity.setSequence(routePointEntity.getSequence() + 1);
                            return routePointEntity;
                        })
                        .sorted(Comparator.comparingInt(RoutePointEntity::getSequence)))
                        .collect(Collectors.toList());

        routeEntity.setRoutePoints(upRoutePointList);
        routeRepository.save(routeEntity);

        return routeEntity;
    }

    @Override
    public RouteEntity addPoint(long routeId, long pointId) {
        final RouteEntity route = load(routeId);
        final PointEntity point = pointService.load(pointId);
        final List<RoutePointEntity> routePoints = route.getRoutePoints();

        final Integer next =
                routePoints.stream()
                        .sorted(Comparator.comparingInt(RoutePointEntity::getSequence))
                        .reduce((first, second) -> second)
                        .map(RoutePointEntity::getSequence)
                        .orElse(0);
        routePoints.add(new RoutePointEntity(route, point, next + 1));

        route.setRoutePoints(routePoints);
        routeRepository.save(route);

        return route;
    }

    @Override
    public void delete(final long id) {
        try {
            routeRepository.delete(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ServiceException(ErrorCode.NOT_FOUND, e, "Route with id " + id + " doesn't exists.");
        }
    }

    @Override
    public RouteEntity deletePoint(final long routeId, final long pointId) {

        final RouteEntity routeEntity = load(routeId);

        final List<RoutePointEntity> routePoints =
                routeEntity.getRoutePoints()
                        .stream()
                        .sorted(Comparator.comparingInt(RoutePointEntity::getSequence))
                        .collect(Collectors.toList());

        final Optional<Integer> position =
                routePoints.stream()
                        .filter(routePoint -> routePoint.getPoint()
                                .getId() == pointId)
                        .findFirst()
                        .map(rp -> routePoints.indexOf(rp));

        if (position.isPresent()) {
            final List<RoutePointEntity> upRoutePoints =
                    Stream.concat(routePoints.stream()
                            .limit(position.get()), routePoints.stream()
                            .skip(position.get())
                            .filter(routePoint -> routePoint.getPoint()
                                    .getId() != pointId)
                            .map(routePointEntity -> {
                                routePointEntity.setSequence(routePointEntity.getSequence() - 1);
                                return routePointEntity;
                            })
                            .sorted())
                            .collect(Collectors.toList());
            routePointRepository.delete(routePoints.get(position.get()));
            routeEntity.setRoutePoints(upRoutePoints);
            routeRepository.save(routeEntity);
        } else {
            throw new ServiceException(ErrorCode.NOT_FOUND, "The route doesn't contain point with id = " + pointId + ".");
        }
        return routeEntity;
    }

    @Override
    public RouteEntity deletePoints(long routeId) {
        final RouteEntity route = load(routeId);
        final List<RoutePointEntity> routePoints = route.getRoutePoints();
        for (RoutePointEntity routePoint : routePoints)
            routePointRepository.delete(routePoint);
        routePoints.clear();
        routeRepository.save(route);
        return route;
    }
}
