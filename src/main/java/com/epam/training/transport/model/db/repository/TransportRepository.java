package com.epam.training.transport.model.db.repository;

import com.epam.training.transport.model.db.entity.TransportEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TransportRepository extends PagingAndSortingRepository<TransportEntity, Long> {
}
