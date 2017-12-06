package com.epam.training.transport.service.impl;

import com.epam.training.transport.model.db.entity.PointEntity;
import com.epam.training.transport.model.db.repository.PointRepository;
import com.epam.training.transport.service.PointService;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

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
    public void delete(final long id) {
        pointRepository.delete(id);
    }

    @Override
    public PointEntity load(final String name) {

        return Objects.requireNonNull(pointRepository.findByName(name), "Point not found!");
    }

    @Override
    public PointEntity load(final long id) {

        return Objects.requireNonNull(pointRepository.findOne(id), "Point not found!");
    }

    @Override
    public List<PointEntity> loadAll() {

        return Objects.requireNonNull(pointRepository.findAll(), "No such points!");
    }

    @Override
    public PointEntity update(final long id, final String name) {

        PointEntity upPoint = load(id);
        upPoint.setName(name);
        pointRepository.save(upPoint);

        return upPoint;
    }
}
