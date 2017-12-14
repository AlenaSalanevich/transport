package com.epam.training.transport.rest.params;

public class RoutePointDeleteParams {


    private long routeId;

    private long pointId;

    public RoutePointDeleteParams(long routeId, long pointId) {
        this.routeId = routeId;
        this.pointId = pointId;
    }
    public RoutePointDeleteParams(){}

    public long getRouteId() {
        return routeId;
    }

    public long getPointId() {
        return pointId;
    }
}



