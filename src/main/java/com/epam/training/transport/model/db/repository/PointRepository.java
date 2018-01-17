package com.epam.training.transport.model.db.repository;

import com.epam.training.transport.model.db.entity.PointEntity;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alena_Salanevich
 */

@Repository
public interface PointRepository extends JpaRepository<PointEntity, Long> {

    PointEntity findByNameIgnoreCase(@Param("name")
    final String name);

    List<PointEntity> findAllByNameStartsWithAndNameContains(@Param("startChar")
    final String startChar, @Param("containChar")
    final String containChar);

    PointEntity findByNameLike(@Param("likeChars")
    final String likeChars);
}
