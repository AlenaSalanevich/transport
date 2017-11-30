
package com.epam.training.transport.service.impl;

import com.epam.training.transport.model.db.repository.RoutePointRepository;
import com.epam.training.transport.service.RoutePointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class RoutePointServiceImpl implements RoutePointService {


    @Autowired
    RoutePointRepository routePointRepository;

    public RoutePointServiceImpl(RoutePointRepository routePointRepository) {
        this.routePointRepository = routePointRepository;
    }
}

