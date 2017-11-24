package com.epam.training.transport.service.impl;

import com.epam.training.transport.model.db.entity.PointEntity;
import com.epam.training.transport.model.db.repository.PointRepository;
import com.epam.training.transport.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service("pointService")
public class PointServiceImpl implements PointService {

    @Autowired
    PointRepository pointRepository;

    @Override
    public PointEntity create(final String name) {
        PointEntity point = new PointEntity();
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
    public List<PointEntity> loadAll() {
        List<PointEntity> allPoints = new ArrayList<>();
        Iterable<PointEntity> all = pointRepository.findAll();
        for (PointEntity point : all) {
            allPoints.add(point);
        }
        return allPoints;
    }

    @Override
    public void update(String oldName, String newName) {
        PointEntity point = pointRepository.findByName(oldName);
        point.setName(newName);
        pointRepository.save(point);
    }
}
