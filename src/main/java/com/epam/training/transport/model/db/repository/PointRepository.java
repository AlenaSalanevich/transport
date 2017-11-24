package com.epam.training.transport.model.db.repository;

import com.epam.training.transport.model.db.entity.PointEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface PointRepository extends PagingAndSortingRepository<PointEntity, Long> {

    PointEntity findByName(final String name);
     void deleteByName (final String name);
}
