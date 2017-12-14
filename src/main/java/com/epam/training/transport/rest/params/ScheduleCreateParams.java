package com.epam.training.transport.rest.params;

import com.epam.training.transport.model.Direction;

import java.sql.Time;

public class ScheduleCreateParams {

    private long routeId;

    private long transportId;

    private Direction direction;

    private boolean isHoliday;

    private Time startTime;

    private Time endTime;

    public ScheduleCreateParams(
        long routeId,
        long transportId,
        Direction direction,
        boolean isHoliday,
        Time startTime,
        Time endTime) {
        this.routeId = routeId;
        this.transportId = transportId;
        this.direction = direction;
        this.isHoliday = isHoliday;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public ScheduleCreateParams() {
    }

    public long getRouteId() {
        return routeId;
    }

    public long getTransportId() {
        return transportId;
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean isHoliday() {
        return isHoliday;
    }

    public Time getStartTime() {
        return startTime;
    }

    public Time getEndTime() {
        return endTime;
    }
}
