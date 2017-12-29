package com.epam.training.transport.model.db.entity;

import com.epam.training.transport.model.Direction;

import javax.persistence.*;

@Entity
@Table(name = "SCHEDULE")
public class ScheduleEntity extends BaseEntity {

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "route_id")
    private RouteEntity route;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "transport_id")
    private TransportEntity transport;

    @Column(name = "direction", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private Direction direction;

    @Column(name = "is_holiday", nullable = false)
    private boolean isHoliday;

    public ScheduleEntity() {
    }

    public ScheduleEntity(
        final long id,
        final RouteEntity route,
        final TransportEntity transport,
        final Direction direction,
        final boolean isHoliday,
        final String departureTime) {
        super(id);
        this.route = route;
        this.transport = transport;
        this.direction = direction;
        this.isHoliday = isHoliday;

    }

    public ScheduleEntity(
        final RouteEntity route,
        final TransportEntity transport,
        final Direction direction,
        final boolean isHoliday,
        final String departureTime) {
        this.route = route;
        this.transport = transport;
        this.direction = direction;
        this.isHoliday = isHoliday;

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

}
