package com.epam.training.transport.rest.views;

import com.epam.training.transport.model.Direction;
import com.epam.training.transport.model.db.entity.RouteEntity;
import com.epam.training.transport.model.db.entity.TransportEntity;

import java.util.Date;

public class ScheduleView {

    private RouteEntity route;


    private TransportEntity transport;


    private Direction direction;


    private boolean isHoliday;


    private Date startTime;


    private Date endTime;

    public ScheduleView() {
    }

    public ScheduleView(RouteEntity route, TransportEntity transport, Direction direction, boolean isHoliday, Date startTime, Date endTime) {
        this.route = route;
        this.transport = transport;
        this.direction = direction;
        this.isHoliday = isHoliday;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public RouteEntity getRoute() {
        return route;
    }

    public void setRoute(RouteEntity route) {
        this.route = route;
    }

    public TransportEntity getTransport() {
        return transport;
    }

    public void setTransport(TransportEntity transport) {
        this.transport = transport;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isHoliday() {
        return isHoliday;
    }

    public void setHoliday(boolean holiday) {
        isHoliday = holiday;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
