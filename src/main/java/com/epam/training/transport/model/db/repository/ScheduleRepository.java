package com.epam.training.transport.model.db.repository;

import com.epam.training.transport.model.db.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long> {

    List<ScheduleEntity> findAllByIsHoliday(@Param("isHoliday")
    final boolean isHoliday);
}
