package com.epam.training.transport.rest.models;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class RoutePointModel {

   /* @Length(max = 10, message = "Point sequence must contain 10 or less symbols!")*/
 /*   @NotEmpty(message = "Point sequence could not be empty!")*/
    @ApiModelProperty(value = "Point sequence", required = true, example = "1")
    private int sequence;

    @Length(max = 5, message = "Departure time must contain 5 or less symbols!")
    @NotEmpty(message = "Departure time could not be empty!")
    @ApiModelProperty(value = "Departure time", required = true, example = "18:30")
    private String departureTime;

    public RoutePointModel() {
    }

    public RoutePointModel(final int sequence, final String departureTime) {

        this.sequence=sequence;
        this.departureTime = departureTime;

    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(final int sequence) {
        this.sequence = sequence;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(final String departureTime) {
        this.departureTime = departureTime;
    }
}
