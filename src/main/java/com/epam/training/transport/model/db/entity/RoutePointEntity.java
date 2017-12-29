package com.epam.training.transport.model.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ROUTE_POINT", uniqueConstraints = { @UniqueConstraint(columnNames = { "point_id"})})
public class RoutePointEntity extends BaseEntity implements Serializable, Comparable<RoutePointEntity> {

    @Column(name = "sequence", nullable = false, length = 10)
    private int sequence;

    @Column(name = "departure_time)", nullable = false, length = 5)
    private String departureTime;

    @ManyToOne
    @JoinColumn(name = "point_id")
    private PointEntity point;

    @ManyToOne
    @JoinColumn(name = "route_id")
    @JsonIgnore
    private RouteEntity route;



    public RoutePointEntity() {
    }

    public RoutePointEntity(
        final long id,
        final PointEntity point,
        final RouteEntity route,
        final int sequence,
        final String departureTime) {
        super(id);
        this.point = point;
        this.route = route;
        this.sequence = sequence;
        this.departureTime = departureTime;
    }

    public RoutePointEntity(final RouteEntity route, final PointEntity point, final int sequence, final String departureTime) {
        this.route = route;
        this.point = point;
        this.sequence = sequence;
        this.departureTime = departureTime;
    }

    public PointEntity getPoint() {
        return point;
    }

    public void setPoint(final PointEntity point) {
        this.point = point;
    }

    public RouteEntity getRoute() {
        return route;
    }

    public void setRoute(final RouteEntity route) {
        this.route = route;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(final int sequence) {
        this.sequence = sequence;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(final String departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;

        final RoutePointEntity that = (RoutePointEntity) o;

        if (sequence != that.sequence)
            return false;
        if (point != null ? !point.equals(that.point) : that.point != null)
            return false;
        if (route != null ? !route.equals(that.route) : that.route != null)
            return false;
        return departureTime != null ? departureTime.equals(that.departureTime) : that.departureTime == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + sequence;
        result = 31 * result + (point != null ? point.hashCode() : 0);
        result = 31 * result + (route != null ? route.hashCode() : 0);
        result = 31 * result + (departureTime != null ? departureTime.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(@NotNull
    final RoutePointEntity o) {
        return this.sequence - o.getSequence();
    }
}
