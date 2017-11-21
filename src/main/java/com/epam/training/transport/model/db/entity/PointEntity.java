package com.epam.training.transport.model.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "POINT_ENTITY")
public class PointEntity extends BaseEntity {

    @Column(name = "name", unique = true, length = 100, nullable = false)
    private String name;

    public PointEntity() {
    }

    public PointEntity(final long id, final String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }


}
