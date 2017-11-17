package com.epam.training.transport.db.repository;

import com.epam.training.transport.db.entity.TramEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TramRepository extends PagingAndSortingRepository<TramEntity, Long> {
}
