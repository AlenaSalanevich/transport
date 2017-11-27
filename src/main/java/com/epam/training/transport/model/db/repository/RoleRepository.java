package com.epam.training.transport.model.db.repository;

import com.epam.training.transport.model.db.entity.RoleEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends PagingAndSortingRepository<RoleEntity, Long> {
}
