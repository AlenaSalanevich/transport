package com.epam.training.transport.rest.models;

import com.epam.training.transport.model.Direction;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Alena_Salanevich
 */

public class AssignmentModel {

    @NotEmpty(message = "Direction not be empty!")
    @Length(min = 6, max = 7)
    @ApiModelProperty(value = "Direction of route", required = true, example = "DIRECT")
    private Direction direction;

    @NotEmpty(message = "Is holiday not be empty!")
    @ApiModelProperty(value = "Is holiday", required = true, example = "false")
    private boolean isHoliday;

    @NotEmpty
    @Min(1)
    @ApiModelProperty(value = "The transport id", required = true, example = "1")
    private long transportId;

    @NotEmpty
    @Min(1)
    @ApiModelProperty(value = "The route id", required = true, example = "1")
    private long routeId;


    @ApiModelProperty(value = "The list of the points with the departure time")
    private List<ScheduleModel> scheduleModelList = new ArrayList<>();

    public AssignmentModel() {
    }

    public AssignmentModel(
        final long transportId,
        final long routeId,
        final Direction direction,
        final boolean isHoliday,
        final List<ScheduleModel> scheduleModelList) {
        this.transportId = transportId;
        this.routeId = routeId;
        this.direction = direction;
        this.isHoliday = isHoliday;
        this.scheduleModelList = scheduleModelList;
    }

    public AssignmentModel(final long transportId, final long routeId, final Direction direction, final boolean isHoliday) {
        this.transportId = transportId;
        this.routeId = routeId;
        this.direction = direction;
        this.isHoliday = isHoliday;
    }
    public AssignmentModel(final Direction direction, final boolean isHoliday) {
        this.direction = direction;
        this.isHoliday = isHoliday;
    }

    public long getTransportId() {
        return transportId;
    }

    public void setTransportId(final long transportId) {
        this.transportId = transportId;
    }

    public long getRouteId() {
        return routeId;
    }

    public void setRouteId(final long routeId) {
        this.routeId = routeId;
    }

    public List<ScheduleModel> getScheduleModelList() {
        return scheduleModelList;
    }

    public void setScheduleModelList(final List<ScheduleModel> scheduleModelList) {
        this.scheduleModelList = scheduleModelList;
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
