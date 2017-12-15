package com.epam.training.transport.service;

import com.epam.training.transport.model.db.entity.PointEntity;
import com.epam.training.transport.model.db.entity.RouteEntity;
import com.epam.training.transport.model.db.entity.RoutePointEntity;

import java.util.List;

public interface RouteService {

    RouteEntity create(final String number, final String description);

    RouteEntity addPointToRoute(RouteEntity route, PointEntity point, String sequence);

    RouteEntity deletePointFromRoute(long routeId, long pointId);

    void delete(final long id);

    List<RouteEntity> loadAll();

    RouteEntity load(final String number);

    RouteEntity load(final long id);
}
