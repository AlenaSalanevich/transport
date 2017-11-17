package com.epam.training.transport.db.repository;

import com.epam.training.transport.db.entity.BusEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BusRepository extends PagingAndSortingRepository<BusEntity, Long> {
}
