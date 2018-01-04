package com.epam.training.transport.model.db.repository;

import com.epam.training.transport.model.db.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alena_Salanevich
 */

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
