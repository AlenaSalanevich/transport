package com.epam.training.transport.model.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Alena_Salanevich
 */

@Entity
@Table(name = "ROUTE_POINT", uniqueConstraints = {@UniqueConstraint(columnNames = {"route_id", "point_id"})})
public class RoutePointEntity extends BaseEntity implements Comparable<RoutePointEntity> {

    @Column(name = "sequence", nullable = false, length = 10)
    private int sequence;

    @ManyToOne
    @JoinColumn(name = "point_id")
    private PointEntity point;

    @ManyToOne
    @JoinColumn(name = "route_id")
    @JsonIgnore
    private RouteEntity route;

    public RoutePointEntity() {
    }

    public RoutePointEntity(final long id, final RouteEntity route, final PointEntity point, final int sequence) {
        super(id);
        this.point = point;
        this.route = route;
        this.sequence = sequence;
    }

    public RoutePointEntity(final RouteEntity route, final PointEntity point, final int sequence) {
        this.route = route;
        this.point = point;
        this.sequence = sequence;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RoutePointEntity that = (RoutePointEntity) o;
        return sequence == that.sequence &&
                Objects.equals(point, that.point) &&
                Objects.equals(route, that.route);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), sequence, point, route);
    }

    @Override
    public int compareTo(@NotNull final RoutePointEntity o) {
        return this.sequence - o.getSequence();
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
