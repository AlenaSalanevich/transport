package com.epam.training.transport.model.db.repository;

import com.epam.training.transport.model.db.entity.RouteEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RouteRepository extends PagingAndSortingRepository <RouteEntity, Long> {
}
