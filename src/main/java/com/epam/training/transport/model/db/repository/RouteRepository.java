package com.epam.training.transport.model.db.repository;

import com.epam.training.transport.model.db.entity.RouteEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends PagingAndSortingRepository<RouteEntity, Long> {

    RouteEntity findByNumber(int number);

    void deleteByNumber(int number);
}
