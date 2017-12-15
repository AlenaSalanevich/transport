package com.epam.training.transport.model.db.entity;

import com.epam.training.transport.model.Direction;

import javax.persistence.*;
import java.sql.Time;
import java.util.GregorianCalendar;
import java.util.List;

@Entity
@Table(name = "SCHEDULE")
public class ScheduleEntity extends BaseEntity {


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id")
    private RouteEntity route;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "transport_id")
    private TransportEntity  transport;


    @Column(name = "direction", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private Direction direction;

    @Column(name = "is_holiday", nullable = false)
    private boolean isHoliday;

    @Column(name = "start_time", nullable = false)
    private Time startTime;

    @Column(name = "end_time", nullable = false)
    private Time endTime;

    public ScheduleEntity() {
    }

    public ScheduleEntity(final long id, final RouteEntity route, final TransportEntity transport,
                          final Direction direction, final boolean isHoliday, final Time startTime, final Time endTime) {
        super(id);
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

    public void setRoute(final RouteEntity route) {
        this.route = route;
    }

    public TransportEntity getTransport() {
        return transport;
    }

    public void setTransport(final TransportEntity transport) {
        this.transport = transport;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(final Direction direction) {
        this.direction = direction;
    }

    public boolean isHoliday() {
        return isHoliday;
    }

    public void setHoliday(final boolean holiday) {
        isHoliday = holiday;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
}
