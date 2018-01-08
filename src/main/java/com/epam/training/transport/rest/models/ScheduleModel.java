package com.epam.training.transport.rest.models;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ScheduleModel {

    @NotEmpty
    @Min(1)
    @Max(1439)
    @ApiModelProperty(value = "Departure time in minutes by 00:00, for example 08:30 = 8*60 + 30 = 510 minutes",
                      required = true,
                      example = "30")
    private int departureTime;

    @NotEmpty
    @Min(1)
    @ApiModelProperty(value = "The point id", required = true, example = "1")
    private long pointId;

    public int getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(final int departureTime) {
        this.departureTime = departureTime;
    }

    public long getPointId() {
        return pointId;
    }

    public void setPointId(final long pointId) {
        this.pointId = pointId;
    }

    public ScheduleModel(final int departureTime, final long pointId) {
        this.departureTime = departureTime;
        this.pointId = pointId;
    }

    public ScheduleModel() {
    }
}
