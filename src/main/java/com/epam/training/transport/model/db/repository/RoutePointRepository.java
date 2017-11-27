package com.epam.training.transport.model.db.repository;

import com.epam.training.transport.model.db.entity.RoutePointEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutePointRepository extends PagingAndSortingRepository <RoutePointEntity, Long> {
}
