package com.epam.training.transport.model.db.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ROUTES")
public class RouteEntity extends BaseEntity {


    @Column(name = "number", nullable = false, unique = true, length = 20)
    private int number;

    @Column(name = "description")
    private String description;


    public RouteEntity() {
    }

    public RouteEntity(final long id, final int number, final String description) {
        super(id);
        this.number = number;
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(final int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }
}
