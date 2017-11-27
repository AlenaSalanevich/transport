package com.epam.training.transport.service.impl;

import com.epam.training.transport.model.db.entity.PointEntity;
import com.epam.training.transport.model.db.repository.PointRepository;
import com.epam.training.transport.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("pointService")
public class PointServiceImpl implements PointService {

    @Autowired
    PointRepository pointRepository;

    @Override
    public PointEntity create(final String name) {
        PointEntity point = new PointEntity();
        point = load(name);
        if (pointRepository.findByName(name) != null) {
            return point;
        }
        point.setName(name);
        pointRepository.save(point);
        return point;
    }

    @Override
    public void delete(final String name) {
        pointRepository.deleteByName(name);
    }

    public PointEntity load(String name) {
        return pointRepository.findByName(name);
    }

    @Override
    public Iterable<PointEntity> loadAll() {
       /* List<PointEntity> allPoints = new ArrayList<>();
        Iterable<PointEntity> all = pointRepository.findAll();
        for (PointEntity point : all) {
            allPoints.add(point);
        }*/
        return pointRepository.findAll();
    }

    @Override
    public void update(String oldName, String newName) {
        PointEntity point = pointRepository.findByName(oldName);
        point.setName(newName);
        pointRepository.save(point);
    }
}
