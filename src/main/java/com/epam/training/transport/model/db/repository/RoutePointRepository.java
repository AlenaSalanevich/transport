
package com.epam.training.transport.model.db.repository;


import com.epam.training.transport.model.db.entity.PointEntity;
import com.epam.training.transport.model.db.entity.RoutePointEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Alena_Salanevich
 */

@Repository
public interface RoutePointRepository extends JpaRepository<RoutePointEntity, Long> {

    RoutePointEntity findOneByRoute_IdAndPoint_Id(final long routeId, final long pointId);

    RoutePointEntity findByPointId(final long pointId);

    List<RoutePointEntity> findByRouteId(final long routeId);

}

