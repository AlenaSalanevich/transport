package com.epam.training.transport.model.db.repository;

import com.epam.training.transport.model.db.entity.RouteEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<RouteEntity, Long> {

    RouteEntity findByNumberLike(@Param("number")
    final String number);

    List<RouteEntity> findAllByNumberContains(@Param("number")
    final String number);

    List<RouteEntity> findAllByDescriptionContains(@Param("description")
    final String description);
}
