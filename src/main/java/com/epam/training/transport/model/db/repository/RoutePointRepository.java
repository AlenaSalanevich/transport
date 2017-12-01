
package com.epam.training.transport.model.db.repository;


import com.epam.training.transport.model.db.entity.RoutePointEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutePointRepository extends JpaRepository<RoutePointEntity, Long> {
}

