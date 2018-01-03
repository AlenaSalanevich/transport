package com.epam.training.transport.rest.controller;

import com.epam.training.transport.model.db.entity.ScheduleEntity;
import com.epam.training.transport.rest.models.RoutePointModel;
import com.epam.training.transport.rest.models.ScheduleModel;
import com.epam.training.transport.service.PointService;
import com.epam.training.transport.service.RouteService;
import com.epam.training.transport.service.ScheduleService;
import com.epam.training.transport.utils.Routes;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/" + Routes.API_SCHEDULES)
public class ScheduleController {

    @Autowired
    RouteService routeService;
    @Autowired
    PointService pointService;
    @Autowired
    ScheduleService scheduleService;

    public ScheduleController() {
    }

    public ScheduleController(
        final RouteService routeService,
        final PointService pointService,
        final ScheduleService scheduleService) {
        this.pointService = pointService;
        this.scheduleService = scheduleService;
        this.routeService = routeService;
    }

    @PostMapping(value = "/add/{routeId}/{transportId}")
    @ApiOperation("Create new Schedule entity")
    @ResponseBody
    public ScheduleEntity create(@PathVariable final long routeId, @PathVariable final long transportId, @RequestBody final ScheduleModel model) {

        return scheduleService.create(routeId, transportId, model.getDirection(), model.isHoliday());
    }

    @PostMapping(value = "/add/transport")
    @ResponseBody
    public ScheduleEntity addTransportToSchedule(@RequestBody RoutePointModel routePointParams) {

        return null;
    }

    @PostMapping(value = "/add/route")
    @ResponseBody
    public ScheduleEntity addRouteToSchedule(@RequestBody RoutePointModel routePointParams) {

        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable
    final long id) {

        return ResponseEntity.ok("Route is deleted!");
    }

    @GetMapping()
    @ResponseBody
    public List<ScheduleEntity> loadAll(@RequestParam
    final Optional<Boolean> optIsHoliday) {
        return scheduleService.loadAll(optIsHoliday);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ScheduleEntity load(@PathVariable
    final long id) {
        return scheduleService.load(id);
    }
}
