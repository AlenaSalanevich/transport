package com.epam.training.transport.rest.models;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;

/**
 * @author Alena_Salanevich
 * @deprecated
 */

public class RoutePointModel {

    @ApiModelProperty(value = "Point sequence", required = true, example = "1")
    @NotEmpty
    @Min(1)
    private int sequence;

    public RoutePointModel() {
    }

    public RoutePointModel(final int sequence) {
        this.sequence = sequence;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(final int sequence) {
        this.sequence = sequence;
    }
}
