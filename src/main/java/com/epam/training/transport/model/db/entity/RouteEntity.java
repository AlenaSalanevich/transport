package com.epam.training.transport.model.db.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ROUTE_ENTITY")
public class RouteEntity extends BaseEntity {

    @Column(name = "number", nullable = false, unique = true, length = 20)
    private int number;

    @Column(name = "description")
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<PointEntity> points;

    public List<PointEntity> getPoints() {
        return points;
    }

    public void setPoints(final List<PointEntity> points) {
        this.points = points;
    }

    public RouteEntity() {
    }

    public RouteEntity(final long id, final int number, final String description, final List<PointEntity> points) {
        super(id);
        this.number = number;
        this.description = description;
        this.points = points;
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
