package com.epam.training.transport.model.db.repository;

import com.epam.training.transport.model.db.entity.RoutePointEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RoutePointRepository extends PagingAndSortingRepository <RoutePointEntity, Long> {
}
