package com.epam.training.transport.model.db.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ROUTES")
public class RouteEntity extends BaseEntity {

    @Column(name = "number", nullable = false, unique = true, length = 20)
    private String number;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "route", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, orphanRemoval = true)
    List<RoutePointEntity> routePoints = new ArrayList<>();

    public RouteEntity() {
    }

    public RouteEntity(final long id, final String number, final String description) {
        super(id);
        this.number = number;
        this.description = description;
    }

   /* public void addRoutePoint(final RoutePointEntity routePoint) {
        this.routePoints.add(routePoint);
    }*/

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
}
