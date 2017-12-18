package com.epam.training.transport.service.impl;

import com.epam.training.transport.model.db.entity.PointEntity;
import com.epam.training.transport.model.db.repository.PointRepository;
import com.epam.training.transport.service.PointService;
import com.epam.training.transport.service.exceptions.ErrorCode;
import com.epam.training.transport.service.exceptions.ServiceException;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialException;
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
        if (name.trim()
            .isEmpty()) {
            throw new ServiceException(ErrorCode.REQUIRED_FIELD);
        }
        PointEntity point = new PointEntity();
        point.setName(name);
        try {
            pointRepository.save(point);
        } catch (DataIntegrityViolationException e) {
            throw new ServiceException(ErrorCode.NAME_ALREADY_EXISTS, e);
        }

        return point;
    }

    @Override
    public void delete(final long id) {
        try {
            pointRepository.delete(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ServiceException(ErrorCode.NOT_FOUND, e);
        }
    }

    @Override
    public PointEntity load(final String name) {

        PointEntity point = pointRepository.findByName(name);
        if (point == null) {
            throw new ServiceException(ErrorCode.NOT_FOUND);
        }
        return point;
    }

    @Override
    public PointEntity load(final long id) {

        PointEntity point = pointRepository.findOne(id);
        if (point == null) {
            throw new ServiceException(ErrorCode.NOT_FOUND);
        }
        return point;
    }

    @Override
    public List<PointEntity> loadAll() {

        return pointRepository.findAll();
    }

    @Override
    public PointEntity update(final long id, final String name) {

        PointEntity upPoint = load(id);
        String upName = name.trim();
        if (upName.isEmpty()) {
            throw new ServiceException(ErrorCode.REQUIRED_FIELD);
        }
        upPoint.setName(upName);

        try {
            pointRepository.save(upPoint);
        } catch (DataIntegrityViolationException e) {
            throw new ServiceException(ErrorCode.NAME_ALREADY_EXISTS, e);
        }

        return upPoint;
    }
}
