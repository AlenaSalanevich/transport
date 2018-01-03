package com.epam.training.transport.model.db.repository;

import com.epam.training.transport.model.TransportType;
import com.epam.training.transport.model.db.entity.TransportEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransportRepository extends JpaRepository<TransportEntity, Long> {

    TransportEntity findByRegistrationNumber(final String registrationNumber);

    List<TransportEntity> findAllByRegistrationNumberContains(final String registrationNumber);

    List<TransportEntity> findAllByTransportTypeAndNoFunctionally(@Param("transportType")
    final TransportType transportType, @Param("noFunctionally")
    final boolean noFunctionally);

    List<TransportEntity> findAllByTransportType(@Param("transportType")
    final TransportType transportType);

    List<TransportEntity> findAllByNoFunctionally(@Param("noFunctionally")
    final boolean noFunctionally);
}
