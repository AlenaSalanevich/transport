package com.epam.training.transport.model.db.entity;

import com.epam.training.transport.model.TransportType;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

/**
 * @author Alena_Salanevich
 */

@Entity
@Table(name = "TRANSPORT")
public class TransportEntity extends BaseEntity implements Comparable<TransportEntity> {

    @Column(name = "registration_number", unique = true, nullable = false, length = 20)
    private String registrationNumber;

    @Column(name = "type", nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    private TransportType transportType;

    @Column(name = "no_functionally", nullable = false)
    private boolean noFunctionally;

    public TransportEntity() {
    }

    public TransportEntity(
        final long id,
        final String registrationNumber,
        final TransportType transportType,
        final boolean noFunctionally) {
        super(id);
        this.transportType = transportType;
        this.registrationNumber = registrationNumber;
        this.noFunctionally = noFunctionally;
    }

    public TransportEntity(final String registrationNumber, final TransportType transportType, final boolean noFunctionally) {
        this.transportType = transportType;
        this.registrationNumber = registrationNumber;
        this.noFunctionally = noFunctionally;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(final TransportType transportType) {
        this.transportType = transportType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(final String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public boolean isNoFunctionally() {
        return noFunctionally;
    }

    public void setNoFunctionally(final boolean noFunctionally) {
        this.noFunctionally = noFunctionally;
    }


    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;

        final TransportEntity that = (TransportEntity) o;

        if (noFunctionally != that.noFunctionally)
            return false;
        if (transportType != that.transportType)
            return false;
        return registrationNumber != null ? registrationNumber.equals(that.registrationNumber) : that.registrationNumber == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (transportType != null ? transportType.hashCode() : 0);
        result = 31 * result + (registrationNumber != null ? registrationNumber.hashCode() : 0);
        result = 31 * result + (noFunctionally ? 1 : 0);
        return result;
    }

    @Override
    public int compareTo(@NotNull final TransportEntity o) {
        return this.getRegistrationNumber()
            .toLowerCase()
            .compareTo(o.getRegistrationNumber()
                .toLowerCase());
    }

}
