package com.epam.training.transport.service;

import com.epam.training.transport.model.db.entity.RouteEntity;
import com.epam.training.transport.model.db.entity.RoutePointEntity;
import com.epam.training.transport.rest.models.AddPointModel;

import java.util.List;

/**
 * @author Alena_Salanevich
 */

public interface RouteService {

    RouteEntity create(final String number, final String description);

    RouteEntity update(long routId, AddPointModel point);

    RouteEntity insertPoint(final long routeId, final long pointId, final int sequence);

    RouteEntity deletePoint(long routeId, long pointId);

    RouteEntity deletePoints(long routeId);

    RouteEntity addPoint(final long routeId, final long pointId);

    void delete(final long id);

    List<RouteEntity> loadAll();

    RouteEntity load(final String number);

    RouteEntity load(final long id);

    RouteEntity insertPoints(final long routeId, final List<AddPointModel> points);

    RouteEntity update (final long routId, final List <AddPointModel> points);

    List<RoutePointEntity> loadPoints(final long routeId);
}
