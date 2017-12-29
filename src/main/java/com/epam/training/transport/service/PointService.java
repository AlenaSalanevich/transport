package com.epam.training.transport.service;

import com.epam.training.transport.model.db.entity.PointEntity;

import java.util.List;
import java.util.Optional;

public interface PointService {

    PointEntity create(final String name);

    void delete(final long id);

    List<PointEntity> loadAll(Optional<String> startWith);

    PointEntity load(final String name);

    PointEntity load(final long id);

    PointEntity update(final long id, final PointEntity pointEntity);
}
