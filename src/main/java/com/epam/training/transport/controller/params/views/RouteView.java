package com.epam.training.transport.controller.params.views;

import com.epam.training.transport.model.db.entity.RoutePointEntity;

import java.util.List;

public class RouteView {

    private long id;
    private String number;
    private String description;
    private List<RoutePointEntity> points;

    public RouteView(final long id,final String number,final String description, final List<RoutePointEntity> points) {
        this.id = id;
        this.number = number;
        this.description = description;
        this.points = points;
    }

    public RouteView() {
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
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

    public List<RoutePointEntity> getPoints() {
        return points;
    }

    public void setPoints(final List<RoutePointEntity> points) {
        this.points = points;
    }
}
