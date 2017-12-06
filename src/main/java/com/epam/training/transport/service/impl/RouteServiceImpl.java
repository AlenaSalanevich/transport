package com.epam.training.transport.service.impl;

import com.epam.training.transport.model.db.entity.PointEntity;
import com.epam.training.transport.model.db.entity.RouteEntity;
import com.epam.training.transport.model.db.entity.RoutePointEntity;
import com.epam.training.transport.model.db.repository.RouteRepository;
import com.epam.training.transport.service.PointService;
import com.epam.training.transport.service.RoutePointService;
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
    PointService pointService;
    @Autowired
    RoutePointService routePointService;

    public RouteServiceImpl(final RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public RouteEntity create(final String number, final String description, final long id, final int sequence) {
        RouteEntity route = new RouteEntity();
        PointEntity point = pointService.load(id);
        RoutePointEntity routePointEntity= routePointService.create(point, sequence);
        route.setNumber(number);
        route.setDescription(description);
        route.addPoint(routePointEntity);
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

    @Override
    public RouteEntity update(final long id, final String number, final String description) {
        RouteEntity upRoute = routeRepository.findOne(id);
        if (!(number.equals(upRoute.getNumber())) || (!number.isEmpty())) {
            upRoute.setNumber(number);
        }
        if (!(description.equals(upRoute.getDescription())) && !description.isEmpty() && !description.equals("")) {

            upRoute.setDescription(description);
        }
        routeRepository.save(upRoute);
        return upRoute;
    }
}
