package com.epam.training.transport.model.db.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ROUTE_POINT")
public class RoutePointEntity extends BaseEntity implements Serializable {

      @Column(name = "sequence")
    private int sequence;

    @ManyToOne
    @JoinColumn(name = "point_id")
    private PointEntity pointEntity;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private RouteEntity routeEntity;


    public RoutePointEntity() {
    }

    public RoutePointEntity(final long id, final PointEntity pointEntity, final RouteEntity routeEntity, final int sequence) {
        super(id);
        this.pointEntity = pointEntity;
        this.routeEntity = routeEntity;
        this.sequence = sequence;
    }


    public PointEntity getPointEntity() {
        return pointEntity;
    }

    public void setPointEntity(final PointEntity pointEntity) {
        this.pointEntity = pointEntity;
    }

      public RouteEntity getRouteEntity() {
        return routeEntity;
    }

    public void setRouteEntity(final RouteEntity routeEntity) {
        this.routeEntity = routeEntity;
    }

        public int getSequence() {
        return sequence;
    }

    public void setSequence(final int sequence) {
        this.sequence = sequence;
    }

}
