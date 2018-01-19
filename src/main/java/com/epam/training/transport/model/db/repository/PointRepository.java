package com.epam.training.transport.model.db.repository;

import com.epam.training.transport.model.db.entity.PointEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Alena_Salanevich
 */

@Repository
public interface PointRepository extends JpaRepository<PointEntity, Long> {

    PointEntity findByNameIgnoreCase(@Param("name") final String name);

    List<PointEntity> findAllByNameContains(@Param("likeChars") final String likeChars);

    PointEntity findByNameLike(@Param("likeChars") final String likeChars);
}
