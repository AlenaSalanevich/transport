package com.epam.training.transport.service.impl;

import com.epam.training.transport.model.db.entity.PointEntity;
import com.epam.training.transport.model.db.entity.RouteEntity;
import com.epam.training.transport.model.db.entity.RoutePointEntity;
import com.epam.training.transport.model.db.repository.RoutePointRepository;
import com.epam.training.transport.model.db.repository.RouteRepository;
import com.epam.training.transport.service.PointService;
import com.epam.training.transport.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

        RouteEntity route = new RouteEntity();
        route.setNumber(number);
        route.setDescription(description);
        routeRepository.save(route);
        return route;
    }

    @Override
    public RoutePointEntity createRoutePoint(final PointEntity point, final String sequence) {

        return null;
    }

    @Override
    public RouteEntity addPointToRoute(final RouteEntity route, final PointEntity point, final String sequence) {
        RoutePointEntity routePoint = new RoutePointEntity();
     //   routePoint.setRoute(route);
        routePoint.setPoint(point);
        routePoint.setSequence(sequence);
        routePointRepository.save(routePoint);
        route.addRoutePoint(routePoint);
        routeRepository.save(route);
        return route;
    }

    @Override
    public void delete(final long id) {
        routeRepository.delete(id);
    }

    @Override
    public List<RouteEntity> loadAll() {
        return routeRepository.findAll();
    }

    @Override
    public RouteEntity load(final String number) {
        return routeRepository.findByNumber(number);
    }

    @Override
    public RouteEntity load(final long id) {
        return routeRepository.findOne(id);
    }

}
