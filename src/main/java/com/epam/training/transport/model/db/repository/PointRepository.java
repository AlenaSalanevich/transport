package com.epam.training.transport.model.db.repository;

import com.epam.training.transport.model.db.entity.PointEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PointRepository extends PagingAndSortingRepository<PointEntity, Long> {
}
