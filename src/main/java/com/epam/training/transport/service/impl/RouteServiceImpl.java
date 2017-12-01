package com.epam.training.transport.service.impl;

import com.epam.training.transport.model.db.entity.RouteEntity;
import com.epam.training.transport.model.db.repository.RouteRepository;
import com.epam.training.transport.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service ("routeService")
public class RouteServiceImpl implements RouteService {

    @Autowired
    RouteRepository routeRepository;

    public RouteServiceImpl(final RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public RouteEntity create(final int number, final String description) {
        RouteEntity route = new RouteEntity();
        route.setNumber(number);
        route.setDescription(description);
        routeRepository.save(route);
        return route;
    }

    @Override
    public void delete(final int number) {
        routeRepository.deleteByNumber(number);

    }

    @Override
    public List<RouteEntity> loadAll() {
        return routeRepository.findAll();
    }

    @Override
    public RouteEntity load(final int number) {
        return routeRepository.findByNumber(number);
    }

    @Override
    public RouteEntity update(final int oldNumber, final int newNumber) {
        RouteEntity upRoute = routeRepository.findByNumber(oldNumber);
        upRoute.setNumber(newNumber);
        routeRepository.save(upRoute);
        return upRoute;
    }
}
