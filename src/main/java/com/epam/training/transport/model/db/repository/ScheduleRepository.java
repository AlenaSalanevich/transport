package com.epam.training.transport.model.db.repository;

import com.epam.training.transport.model.db.entity.ScheduleEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends PagingAndSortingRepository<ScheduleEntity, Long> {
}