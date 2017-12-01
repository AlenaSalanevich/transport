package com.epam.training.transport.service.impl;

import com.epam.training.transport.model.db.entity.PointEntity;
import com.epam.training.transport.model.db.repository.PointRepository;
import com.epam.training.transport.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service("pointService")
public class PointServiceImpl implements PointService {

    @Autowired
    PointRepository pointRepository;

    public PointServiceImpl(final PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    public PointServiceImpl() {
    }

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

        return pointRepository.findAll();
    }

    @Override
    public PointEntity update(String name, String newName) {
        PointEntity upPoint = pointRepository.findByName(name);
        upPoint.setName(newName);
        pointRepository.save(upPoint);
        return upPoint;
    }
}
