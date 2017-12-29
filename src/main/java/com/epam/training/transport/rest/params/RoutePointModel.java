package com.epam.training.transport.rest.params;

public class RoutePointModel {

    private long routeId;

    private long pointId;

    private int sequence;

    private String departureTime;

    public RoutePointModel(final int sequence, final String departureTime) {
        this.sequence = sequence;
        this.departureTime = departureTime;
    }

    public RoutePointModel() {
    }

    public RoutePointModel(final long routeId, final long pointId, final int sequence, final String departureTime) {
        this.routeId = routeId;
        this.pointId = pointId;
        this.sequence=sequence;
        this.departureTime = departureTime;

    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(final int sequence) {
        this.sequence = sequence;
    }

    public long getRouteId() {
        return routeId;
    }

    public void setRouteId(final long routeId) {
        this.routeId = routeId;
    }

    public long getPointId() {
        return pointId;
    }

    public void setPointId(final long pointId) {
        this.pointId = pointId;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(final String departureTime) {
        this.departureTime = departureTime;
    }
}
