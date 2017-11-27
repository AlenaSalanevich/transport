package com.epam.training.transport.service;

import com.epam.training.transport.model.db.entity.PointEntity;

public interface PointService {

    PointEntity create(String name);

    void delete(String name);

    Iterable<PointEntity> loadAll();

    PointEntity load(String name);

    void update(String oldName, String newName);
}
