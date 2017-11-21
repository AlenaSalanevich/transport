package com.epam.training.transport.model.db.entity;

import com.epam.training.transport.model.Direction;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "SCHEDULE")
public class ScheduleEntity extends BaseEntity {


    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "route_id")
    private RouteEntity route;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "transport_id")
    private TransportEntity  transport;


    @Column(name = "direction", nullable = false)
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
}
