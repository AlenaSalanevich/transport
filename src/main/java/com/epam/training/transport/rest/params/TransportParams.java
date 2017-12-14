package com.epam.training.transport.rest.params;

import com.epam.training.transport.model.TransportType;

public class TransportParams {

    private long id;

    private String registrationNumber;

    private boolean noFunctionally;

    private TransportType transportType;

    public TransportParams() {
    }

    public TransportParams(
        final long id,
        final String registrationNumber,
        final boolean noFunctionally,
        final TransportType transportType) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.noFunctionally = noFunctionally;
        this.transportType = transportType;
    }

    public long getId() {
        return id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public boolean isNoFunctionally() {
        return noFunctionally;
    }

    public TransportType getTransportType() {
        return transportType;
    }
}
