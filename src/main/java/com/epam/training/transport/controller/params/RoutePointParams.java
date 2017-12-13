package com.epam.training.transport.controller.params;

public class RoutePointParams {

    private long routeId;

    private  long pointId;

    private String sequence;

    public RoutePointParams(final String sequence) {
        this.sequence = sequence;
    }

    public RoutePointParams() {
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(final String sequence) {
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
}