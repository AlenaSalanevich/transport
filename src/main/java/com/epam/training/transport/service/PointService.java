package com.epam.training.transport.service;

import com.epam.training.transport.model.db.entity.PointEntity;

import java.util.List;

public interface PointService {

    PointEntity create(String name);

    void delete(String name);

    List<PointEntity> loadAll();

    PointEntity load(String name);

    void update(String oldName, String newName);
}
