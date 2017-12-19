package com.epam.training.transport.model.db.entity;

import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ROUTES")
public class RouteEntity extends BaseEntity implements Comparable<RouteEntity> {

    @Column(name = "number", nullable = false, unique = true, length = 20)
    private String number;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
    List<RoutePointEntity> routePoints = new ArrayList<>();

    public RouteEntity() {
    }

    public RouteEntity(final long id, final String number, final String description) {
        super(id);
        this.number = number;
        this.description = description;
    }

    public RouteEntity(final String number, final String description) {
        this.number = number;
        this.description = description;
    }

    public List<RoutePointEntity> getRoutePoints() {
        return routePoints;
    }

    public void setRoutePoints(final List<RoutePointEntity> routePoints) {
        this.routePoints = routePoints;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(final String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    @Override
    public int compareTo(@NotNull RouteEntity o) {
        return this.number.compareTo(o.getNumber());
    }
}
