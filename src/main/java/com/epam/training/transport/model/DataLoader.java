package com.epam.training.transport.model;

import com.epam.training.transport.model.db.entity.PointEntity;
import com.epam.training.transport.model.db.entity.RouteEntity;
import com.epam.training.transport.model.db.entity.RoutePointEntity;
import com.epam.training.transport.model.db.repository.PointRepository;
import com.epam.training.transport.model.db.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    @Autowired
    private PointRepository pointRepository;

    @Autowired
    private RouteRepository routeRepository;

    public DataLoader(final PointRepository pointRepository, final RouteRepository routeRepository) {
        this.pointRepository = pointRepository;
        this.routeRepository = routeRepository;
        loadPoints();
        loadRoutes();
    }

    private void loadPoints() {
        pointRepository.save(new PointEntity("ABC"));
        pointRepository.save(new PointEntity("BCD"));
        pointRepository.save(new PointEntity("CDE"));
        pointRepository.save(new PointEntity("DEF"));
        pointRepository.save(new PointEntity("EFG"));
    }

    private void loadRoutes() {
        routeRepository.save(new RouteEntity("60", "From ABC to CDE"));
        routeRepository.save(new RouteEntity("200", "From BCD to CDE"));
        routeRepository.save(new RouteEntity("600", "From DEF to ABC"));
        routeRepository.save(new RouteEntity("6", "From ABC to EFG"));
        routeRepository.save(new RouteEntity("210", "From BCD to CDE"));
        routeRepository.save(new RouteEntity("1100", "From BCD to CDE"));
        routeRepository.save(new RouteEntity("10", "From BCD to CDE"));
    }
}
