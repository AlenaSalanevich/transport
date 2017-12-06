package com.epam.training.transport.service;

import com.epam.training.transport.model.db.entity.RouteEntity;

import java.util.List;

public interface RouteService {

    RouteEntity create(final String number, final String description, final long id, final int sequence);

    void delete(final long id);

    List<RouteEntity> loadAll();

    RouteEntity load(final String number);

    RouteEntity load(final long id);

    RouteEntity update(final long id, final String number, final String description);
}
