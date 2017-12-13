package com.epam.training.transport.model.db.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ROUTE_POINT")
public class RoutePointEntity extends BaseEntity implements Serializable {

    @Column(name = "sequence", nullable = false)
    private String sequence;

    @ManyToOne
    @JoinColumn(name = "point_id")
    private PointEntity point;

   @ManyToOne
    @JoinColumn(name = "route_id")
    private RouteEntity route;


    public RoutePointEntity() {
    }

    public RoutePointEntity(final long id, final PointEntity point, /*final RouteEntity route,*/ final String sequence) {
        super(id);
        this.point = point;
      /*  this.route = route;*/
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

        public String getSequence() {
        return sequence;
    }

    public void setSequence(final String sequence) {
        this.sequence = sequence;
    }

}
