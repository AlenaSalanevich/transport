package com.epam.training.transport.rest.views;

import com.epam.training.transport.model.db.entity.PointEntity;

import java.util.Map;

public class RouteView {

    private long id;
    private String number;
    private String description;
    private Map<PointEntity, String> points;

    public RouteView(final long id,final String number,final String description, final Map<PointEntity, String> points) {
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

    public Map<PointEntity, String> getPoints() {
        return points;
    }

    public void setPoints( final Map<PointEntity, String> points) {
        this.points = points;
    }
}
