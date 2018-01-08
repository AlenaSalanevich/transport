package com.epam.training.transport.model.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * @author Alena_Salanevich
 */

@Entity
@Table(name = "SCHEDULE", uniqueConstraints = @UniqueConstraint(columnNames = { "assignment_id", "departure_time"}))
public class ScheduleEntity extends BaseEntity {

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JsonIgnore
    @JoinColumn(name = "assignment_id")
    private AssignmentEntity assignment;

    @ManyToOne
    @JsonIgnore
    @JoinColumn (name = "route_point_id")
    RoutePointEntity routePointEntity;

    @Column(name = "departure_time",  nullable = false)
    private String departureTime;

    public ScheduleEntity(
        final long id,
        final AssignmentEntity assignment,
        final RoutePointEntity routePointEntity,
        final String departureTime) {
        super(id);
        this.assignment = assignment;
        this.routePointEntity = routePointEntity;
        this.departureTime = departureTime;
    }

    public ScheduleEntity(
        final AssignmentEntity assignment,
        final RoutePointEntity routePointEntity,
        final String departureTime) {
        this.assignment = assignment;
        this.routePointEntity = routePointEntity;
        this.departureTime = departureTime;
    }
    public ScheduleEntity(
          final RoutePointEntity routePointEntity,
            final String departureTime) {
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

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(final String departureTime) {
        this.departureTime = departureTime;
    }
}
