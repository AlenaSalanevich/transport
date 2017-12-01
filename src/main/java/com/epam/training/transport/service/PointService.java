package com.epam.training.transport.service;

import com.epam.training.transport.model.db.entity.PointEntity;

import java.util.List;

public interface PointService {

    PointEntity create(final String name);

    void delete(final String name);

    List<PointEntity> loadAll();

    PointEntity load(final String name);

    PointEntity update(final String oldName, final String newName);
}
