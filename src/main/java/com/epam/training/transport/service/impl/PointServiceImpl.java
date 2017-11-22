package com.epam.training.transport.service.impl;

import com.epam.training.transport.model.db.entity.PointEntity;
import com.epam.training.transport.model.db.repository.PointRepository;
import com.epam.training.transport.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.util.Optional;

@Service ("pointService")
public class PointServiceImpl implements PointService {

    @Autowired
    PointRepository pointRepository;

    @Override
    public PointEntity getOrCreate(final String name){
     Optional<PointEntity> optPoint = pointRepository.findByName(name);
        PointEntity point = optPoint.get();
        if (!optPoint.isPresent()){
            point = new PointEntity();
            point.setName(name);
            try {
                pointRepository.save(point);
            }
            catch (final PersistenceException e){
           point = pointRepository.findByName(name).get();
            }
        }
        return point;
    }
}
