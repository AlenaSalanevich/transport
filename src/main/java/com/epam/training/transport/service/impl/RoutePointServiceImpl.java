
package com.epam.training.transport.service.impl;

import com.epam.training.transport.model.db.entity.PointEntity;
import com.epam.training.transport.model.db.entity.RoutePointEntity;
import com.epam.training.transport.model.db.repository.RoutePointRepository;
import com.epam.training.transport.service.PointService;
import com.epam.training.transport.service.RoutePointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class RoutePointServiceImpl implements RoutePointService {

    @Autowired
    PointService pointService;

    @Override
    public RoutePointEntity create(final PointEntity point, int sequence) {
        RoutePointEntity routePointEntity = new RoutePointEntity();
        routePointEntity.setPointEntity(point);
        routePointEntity.setSequence(sequence);
        return routePointEntity;
    }
}
