package com.epam.training.transport.model.db.repository;

import com.epam.training.transport.model.db.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alena_Salanevich
 */

@Repository
public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long> {
}
