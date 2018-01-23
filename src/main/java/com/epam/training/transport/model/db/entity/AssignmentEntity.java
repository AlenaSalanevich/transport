package com.epam.training.transport.model.db.entity;

import com.epam.training.transport.model.Direction;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Alena_Salanevich
 */

@Entity
@Table(name = "ASSIGNMENT", uniqueConstraints = {@UniqueConstraint(columnNames = {"route_id", "direction"})})
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AssignmentEntity extends BaseEntity {

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "route_id")
    private RouteEntity route;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "transport_id")
    private TransportEntity transport;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JoinColumn(name = "user_id")
    private UserEntity user = null;


    @Column(name = "direction", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private Direction direction;

    @Column(name = "is_holiday", nullable = false)
    private boolean isHoliday;

    @OneToMany(mappedBy = "assignment", cascade = CascadeType.ALL)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ScheduleEntity> scheduleEntities = new ArrayList<>();

    public AssignmentEntity() {
    }

    public AssignmentEntity(
            final long id,
            final RouteEntity route,
            final TransportEntity transport,
            final Direction direction,
            final boolean isHoliday, final List<ScheduleEntity> scheduleEntities, UserEntity user) {
        super(id);
        this.route = route;
        this.transport = transport;
        this.direction = direction;
        this.isHoliday = isHoliday;
        this.scheduleEntities = scheduleEntities;
        this.user = user;
    }

    public AssignmentEntity(
            final RouteEntity route,
            final TransportEntity transport,
            final Direction direction,
            final boolean isHoliday, final List<ScheduleEntity> scheduleEntities, UserEntity user) {
        this.route = route;
        this.transport = transport;
        this.direction = direction;
        this.isHoliday = isHoliday;
        this.scheduleEntities = scheduleEntities;
        this.user = user;
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

    public List<ScheduleEntity> getScheduleEntities() {
        return scheduleEntities;
    }

    public void setScheduleEntities(final List<ScheduleEntity> scheduleEntities) {
        this.scheduleEntities = scheduleEntities;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(final UserEntity user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AssignmentEntity that = (AssignmentEntity) o;
        return isHoliday == that.isHoliday &&
                Objects.equals(route, that.route) &&
                Objects.equals(transport, that.transport) &&
                Objects.equals(user, that.user) &&
                direction == that.direction &&
                Objects.equals(scheduleEntities, that.scheduleEntities);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), route, transport, user, direction, isHoliday, scheduleEntities);
    }
}
