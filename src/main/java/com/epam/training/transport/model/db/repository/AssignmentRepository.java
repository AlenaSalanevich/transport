package com.epam.training.transport.model.db.repository;

import com.epam.training.transport.model.db.entity.AssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Alena_Salanevich
 */

@Repository
public interface AssignmentRepository extends JpaRepository<AssignmentEntity, Long> {

    List<AssignmentEntity> findAllByIsHoliday(@Param("isHoliday")
    final boolean isHoliday);

}
