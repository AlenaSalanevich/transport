package com.epam.training.transport.rest.models;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class RouteModel {

    @Length(max = 20, message = "Number of route must contain 20 or less symbols!")
    @NotEmpty(message = "Number could not be empty!")
    @ApiModelProperty(value = "Number of route", required = true, example = "11")
    private String number;

    @Length(max = 200, message = "Description of route must contain 200 or less symbols!")
    @ApiModelProperty(value = "Description of route", example = "from ABC to BDC")
    private String description;


    public RouteModel() {
    }

    public RouteModel(final String number, final String description) {
        this.number = number;
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }
}
