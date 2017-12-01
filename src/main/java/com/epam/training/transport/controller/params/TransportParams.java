package com.epam.training.transport.controller.params;

import com.epam.training.transport.model.TransportType;

public class TransportParams {

    private String LP;

    private boolean noFunctionally;

    private TransportType transportType;

    public String getLP() {
        return LP;
    }

    public boolean isNoFunctionally() {
        return noFunctionally;
    }

    public TransportType getTransportType() {
        return transportType;
    }
}
