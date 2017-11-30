package com.epam.training.transport.service;

import com.epam.training.transport.model.db.entity.PointEntity;

public interface PointService {

    PointEntity create(final String name);

    void delete(final String name);

    Iterable<PointEntity> loadAll();

    PointEntity load(final String name);

    void update(final String oldName, final String newName);
}
