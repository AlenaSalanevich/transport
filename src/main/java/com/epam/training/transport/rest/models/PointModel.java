package com.epam.training.transport.rest.models;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class PointModel {

    @Length(max = 100, message = "Name of point must contain 100 or less symbols!")
    @NotEmpty(message = "Name could not be empty!")
    @ApiModelProperty(value = "Name of point", required = true, example = "ABCDE")
    private String name;

    public PointModel(final String name) {
        this.name = name;
    }

    public PointModel() {
    }

    public String getName() {
        return name;
    }
}
