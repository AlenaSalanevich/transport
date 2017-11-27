package com.epam.training.transport.model.db.repository;

import com.epam.training.transport.model.db.entity.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository <UserEntity, Long> {
}
