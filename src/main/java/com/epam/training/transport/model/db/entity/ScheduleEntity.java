package com.epam.training.transport.model.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Alena_Salanevich
 */

@Entity
@Table(name = "SCHEDULE", uniqueConstraints = @UniqueConstraint(columnNames = { "assignment_id", "departure_time"}))
public class ScheduleEntity extends BaseEntity implements Comparable<ScheduleEntity>{

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JsonIgnore
    @JoinColumn(name = "assignment_id")
    private AssignmentEntity assignment;

    @ManyToOne
    @JoinColumn(name = "route_point_id")
    RoutePointEntity routePointEntity;

    @Column(name = "departure_time", nullable = false)
    private int departureTime;

    public ScheduleEntity(
        final long id,
        final AssignmentEntity assignment,
        final RoutePointEntity routePointEntity,
        final int departureTime) {
        super(id);
        this.assignment = assignment;
        this.routePointEntity = routePointEntity;
        this.departureTime = departureTime;
    }

    public ScheduleEntity(final AssignmentEntity assignment, final RoutePointEntity routePointEntity, final int departureTime) {
        this.assignment = assignment;
        this.routePointEntity = routePointEntity;
        this.departureTime = departureTime;
    }

    public ScheduleEntity(final RoutePointEntity routePointEntity, final int departureTime) {
        this.routePointEntity = routePointEntity;
        this.departureTime = departureTime;
    }

    public ScheduleEntity() {
    }

    public AssignmentEntity getAssignment() {
        return assignment;
    }

    public void setAssignment(final AssignmentEntity assignment) {
        this.assignment = assignment;
    }

    public RoutePointEntity getRoutePointEntity() {
        return routePointEntity;
    }

    public void setRoutePointEntity(final RoutePointEntity routePointEntity) {
        this.routePointEntity = routePointEntity;
    }

    public  int getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(final int departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public int compareTo(@NotNull final ScheduleEntity o) {
            return this.departureTime - o.getDepartureTime();
        }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
       final ScheduleEntity that = (ScheduleEntity) o;
        return departureTime == that.departureTime &&
                Objects.equals(assignment, that.assignment) &&
                Objects.equals(routePointEntity, that.routePointEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), assignment, routePointEntity, departureTime);
    }

}

