package com.epam.training.transport.model.db.repository;

import com.epam.training.transport.model.db.entity.TransportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportRepository extends JpaRepository<TransportEntity, Long> {

    TransportEntity findByRegistrationNumber(final String registrationNumber);
}
