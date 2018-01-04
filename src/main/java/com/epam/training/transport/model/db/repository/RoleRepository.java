package com.epam.training.transport.model.db.repository;

import com.epam.training.transport.model.db.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alena_Salanevich
 */

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
