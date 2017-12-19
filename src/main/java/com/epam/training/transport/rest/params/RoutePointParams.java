package com.epam.training.transport.rest.params;

public class RoutePointParams {

    private long routeId;

    private  long pointId;

    private int sequence;

    public RoutePointParams(final int sequence) {
        this.sequence = sequence;
    }

    public RoutePointParams() {
    }

    public RoutePointParams(long routeId, long pointId) {
        this.routeId = routeId;
        this.pointId = pointId;
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
}