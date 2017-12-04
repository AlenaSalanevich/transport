package com.epam.training.transport.controller.params;

import com.epam.training.transport.model.TransportType;

public class TransportCreateParams {

    private String registrationNumber;

    private boolean noFunctionally;

    private TransportType transportType;

    public TransportCreateParams(){
    }

    public TransportCreateParams(final String registrationNumber, final boolean noFunctionally,final TransportType transportType) {
        this.registrationNumber = registrationNumber;
        this.noFunctionally = noFunctionally;
        this.transportType = transportType;
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
