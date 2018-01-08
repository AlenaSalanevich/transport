package com.epam.training.transport.rest.models;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;

/**
 * @author Alena_Salanevich
 */

public class AddPointModel {

    @NotEmpty
    @Min(1)
    @ApiModelProperty(value = "Point id", example = "1", required = true)
    long pointId;

    @NotEmpty
    @Min(1)
    @ApiModelProperty(value = "sequence of the point int the route", example = "1", required = true)
    int sequence;

    public AddPointModel(final long pointId, final int sequence) {
        this.pointId = pointId;
        this.sequence = sequence;
    }

    public AddPointModel() {
    }

    public long getPointId() {
        return pointId;
    }

    public void setPointId(final long pointId) {
        this.pointId = pointId;
    }

    public int getSequense() {
        return sequence;
    }

    public void setSequense(final int sequense) {
        this.sequence = sequense;
    }

}
