package com.epam.training.transport.model.db.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "POINTS")
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
