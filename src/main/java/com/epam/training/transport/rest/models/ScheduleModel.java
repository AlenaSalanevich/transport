package com.epam.training.transport.rest.models;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class ScheduleModel {

    @NotEmpty(message = "Departure time must not be empty!")
    @Length(min=5, max = 5, message = "Departure time have incorrect format")
    @ApiModelProperty(value = "Departure time", required = true, example = "14:30")
    private String departureTime;

    @NotEmpty
    @ApiModelProperty(value = "The point id", required = true, example = "1")
    private long pointId;

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public long getPointId() {
        return pointId;
    }

    public void setPointId(long pointId) {
        this.pointId = pointId;
    }

    public ScheduleModel(String departureTime, long pointId) {
        this.departureTime = departureTime;
        this.pointId = pointId;
    }

    public ScheduleModel() {
    }
}
