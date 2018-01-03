package com.epam.training.transport.rest.models;

import com.epam.training.transport.model.TransportType;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class TransportModel {

    @Length(min = 9, max = 20, message = "Transport register number must contain 9 or more symbols!")
    @NotEmpty(message = "Transport register number could not be empty!")
    @ApiModelProperty(value = "Transport register number", required = true, example = "1212 KH-4")
    private String registrationNumber;

    @NotEmpty(message = "Transport functionality could not be empty!")
    @ApiModelProperty(value = "Transport functionality", required = true, example = "true")
    private boolean noFunctionally;

    @Length(min = 3, max = 30, message = "Transport type must contain 3 or more symbols!")
    @NotEmpty(message = "Transport type could not be empty!")
    @ApiModelProperty(value = "Transport type", required = true)
    private TransportType transportType;

    public TransportModel() {
    }

    public TransportModel(final String registrationNumber, final boolean noFunctionally, final TransportType transportType) {
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
