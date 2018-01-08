package com.epam.training.transport.model.db.entity;

import com.epam.training.transport.model.Direction;

import javax.persistence.*;
import java.util.List;

/**
 * @author Alena_Salanevich
 */

@Entity
@Table(name = "ASSIGMENT")
public class AssignmentEntity extends BaseEntity {

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

    public AssignmentEntity() {
    }

    public AssignmentEntity(
        final long id,
        final RouteEntity route,
        final TransportEntity transport,
        final Direction direction,
        final boolean isHoliday) {
        super(id);
        this.route = route;
        this.transport = transport;
        this.direction = direction;
        this.isHoliday = isHoliday;

    }

    public AssignmentEntity(
        final RouteEntity route,
        final TransportEntity transport,
        final Direction direction,
        final boolean isHoliday) {
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

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;

        final AssignmentEntity that = (AssignmentEntity) o;

        if (isHoliday != that.isHoliday)
            return false;
        if (!route.equals(that.route))
            return false;
        if (!transport.equals(that.transport))
            return false;
        return direction == that.direction;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + route.hashCode();
        result = 31 * result + transport.hashCode();
        result = 31 * result + direction.hashCode();
        result = 31 * result + (isHoliday ? 1 : 0);
        return result;
    }
}
