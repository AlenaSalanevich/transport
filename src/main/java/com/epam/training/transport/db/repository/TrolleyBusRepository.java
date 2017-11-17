package com.epam.training.transport.db.repository;

import com.epam.training.transport.db.entity.TrolleyBusEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TrolleyBusRepository extends PagingAndSortingRepository<TrolleyBusEntity, Long> {
}
