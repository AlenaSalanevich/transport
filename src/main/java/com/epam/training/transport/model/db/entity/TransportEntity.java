package com.epam.training.transport.model.db.entity;

import com.epam.training.transport.model.TransportType;

import javax.persistence.*;

@Entity
@Table(name = "TRANSPORT")
public class TransportEntity extends BaseEntity {

    @Column(name = "type", nullable = false)
    private TransportType transportType;

    private String LP;

    @Column(name = "no_functionally", nullable = false)
    private boolean noFunctionally;

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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;

        TransportEntity that = (TransportEntity) o;

        if (noFunctionally != that.noFunctionally)
            return false;
        if (transportType != that.transportType)
            return false;
        return LP != null ? LP.equals(that.LP) : that.LP == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (transportType != null ? transportType.hashCode() : 0);
        result = 31 * result + (LP != null ? LP.hashCode() : 0);
        result = 31 * result + (noFunctionally ? 1 : 0);
        return result;
    }
}
