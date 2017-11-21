package com.epam.training.transport.model.db.entity;

import com.epam.training.transport.model.TransportType;

import javax.persistence.*;

@Entity
@Table(name = "TRANSPORT_ENTITY")
public class TransportEntity extends BaseEntity {

    @Column(name = "type", nullable = false)
    private TransportType transportType;

    private String LP;

    @Column(name = "no_functionally", nullable = false)
    private boolean noFunctionally;

    @Column(name = "is_on_road", nullable = false)
    private boolean isOnRoad;

    public TransportEntity() {
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public String getLP() {
        return LP;
    }

    public void setLP(String LP) {
        this.LP = LP;
    }

    public boolean isNoFunctionally() {
        return noFunctionally;
    }

    public void setNoFunctionally(boolean noFunctionally) {
        this.noFunctionally = noFunctionally;
    }

    public boolean isOnRoad() {
        return isOnRoad;
    }

    public void setOnRoad(boolean onRoad) {
        isOnRoad = onRoad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        TransportEntity that = (TransportEntity) o;

        if (noFunctionally != that.noFunctionally) return false;
        if (isOnRoad != that.isOnRoad) return false;
        if (transportType != that.transportType) return false;
        return LP != null ? LP.equals(that.LP) : that.LP == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (transportType != null ? transportType.hashCode() : 0);
        result = 31 * result + (LP != null ? LP.hashCode() : 0);
        result = 31 * result + (noFunctionally ? 1 : 0);
        result = 31 * result + (isOnRoad ? 1 : 0);
        return result;
    }
}