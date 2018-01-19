package com.epam.training.transport.service.impl;

import com.epam.training.transport.model.db.entity.PointEntity;
import com.epam.training.transport.model.db.repository.PointRepository;
import com.epam.training.transport.service.PointService;
import com.epam.training.transport.service.exceptions.ErrorCode;
import com.epam.training.transport.service.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Alena_Salanevich
 */

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

        final PointEntity point = new PointEntity(name);
        try {
            pointRepository.save(point);
        } catch (DataIntegrityViolationException e) {
            throw new ServiceException(ErrorCode.NAME_ALREADY_EXISTS, e, "Point with name " + name + " already exists.");
        }
        return point;
    }

    @Override
    public void delete(final long id) {
        try {
            pointRepository.delete(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ServiceException(ErrorCode.NOT_FOUND, e, "Point with id " + id + " doesn't exists.");
        }
    }

    @Override
    public PointEntity load(final String name) {

        final PointEntity point = pointRepository.findByNameLike(name);

        return point;
    }

    @Override
    public PointEntity load(final long id) {

        final PointEntity point = pointRepository.findOne(id);

        return point;

    }

    @Override
    public List<PointEntity> loadAll(Optional<String> startWith) {

        return startWith.map(startChar -> pointRepository.findAllByNameContains(startChar.trim()))
                .orElse(pointRepository.findAll());
    }

    @Override
    public PointEntity update(final long id, final PointEntity pointEntity) {

        try {
            pointRepository.save(pointEntity);
        } catch (final DataAccessException e) {
            throw new ServiceException(ErrorCode.NAME_ALREADY_EXISTS, e, "Point with name " + pointEntity.getName() + " already exists.");
        }
        return pointEntity;
    }

    @Override
    public List<PointEntity> loadByListId(final ArrayList<Long> idList) {
        final List<PointEntity> pointEntityList = new ArrayList<>();

        for (Long id : idList) {
            pointEntityList.add(pointRepository.findOne(id));
        }
        return pointEntityList;
    }
}
