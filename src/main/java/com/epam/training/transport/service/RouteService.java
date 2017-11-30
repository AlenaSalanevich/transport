package com.epam.training.transport.service;

import com.epam.training.transport.model.db.entity.RouteEntity;

public interface RouteService {

    RouteEntity create(final int number, final String description);

    void delete(final int number);

    Iterable<RouteEntity> loadAll();

    RouteEntity load(final int number);

    RouteEntity update(final int oldNumber, final int newNumber);
}
