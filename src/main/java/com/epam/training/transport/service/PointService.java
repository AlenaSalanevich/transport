package com.epam.training.transport.service;

import com.epam.training.transport.model.db.entity.PointEntity;

public interface PointService {
    PointEntity getOrCreate(String name);
}
