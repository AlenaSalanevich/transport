package com.epam.training.transport.rest.models;

import com.epam.training.transport.model.Direction;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class AssignmentModel {


    @NotEmpty(message = "Direction not be empty!")
    @ApiModelProperty(value = "Direction of route", required = true, example = "DIRECT")
    private Direction direction;

    @NotEmpty(message = "Is holiday not be empty!")
    @ApiModelProperty(value = "Is holiday", required = true, example = "false")
    private boolean isHoliday;

    public AssignmentModel(final Direction direction, final boolean isHoliday) {
        this.direction = direction;
        this.isHoliday = isHoliday;
    }

    public AssignmentModel() {
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean isHoliday() {
        return isHoliday;
    }

    public void setDirection(final Direction direction) {
        this.direction = direction;
    }

    public void setHoliday(final boolean holiday) {
        isHoliday = holiday;
    }
}