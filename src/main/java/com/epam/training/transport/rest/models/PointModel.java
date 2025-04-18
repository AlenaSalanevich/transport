package com.epam.training.transport.rest.models;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Alena_Salanevich
 */

public class PointModel {

    @Length(max = 100, message = "Name of point must contain 100 or less symbols!")
    @NotEmpty(message = "Name could not be empty!")
    @ApiModelProperty(value = "The name of the point", required = true, example = "ABCDE")
    private String name;

    public PointModel(final String name) {
        this.name = name;
    }

    public PointModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
