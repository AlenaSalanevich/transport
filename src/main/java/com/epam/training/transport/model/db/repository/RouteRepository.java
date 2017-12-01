package com.epam.training.transport.model.db.repository;

import com.epam.training.transport.model.db.entity.RouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<RouteEntity, Long> {

    RouteEntity findByNumber(int number);

    void deleteByNumber(int number);
}
