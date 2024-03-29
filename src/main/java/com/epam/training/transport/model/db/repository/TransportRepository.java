package com.epam.training.transport.model.db.repository;

import com.epam.training.transport.model.TransportType;
import com.epam.training.transport.model.db.entity.TransportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Alena_Salanevich
 */

@Repository
public interface TransportRepository extends JpaRepository<TransportEntity, Long> {

    TransportEntity findByRegistrationNumber(final String registrationNumber);

    List<TransportEntity> findAllByRegistrationNumberContains(final String registrationNumber);

    List<TransportEntity> findAllByTransportTypeAndFunctionality(@Param("transportType")
    final TransportType transportType, @Param("functionality")
    final boolean noFunctionally);

    List<TransportEntity> findAllByTransportType(@Param("transportType")
    final TransportType transportType);

    List<TransportEntity> findAllByFunctionality(@Param("functionality")
    final boolean noFunctionally);
}
