package com.epam.training.transport.rest.controller;

import com.epam.training.transport.model.db.entity.PointEntity;
import com.epam.training.transport.model.db.entity.RouteEntity;
import com.epam.training.transport.model.db.entity.ScheduleEntity;
import com.epam.training.transport.rest.params.RouteCreateParams;
import com.epam.training.transport.rest.params.RoutePointParams;
import com.epam.training.transport.rest.params.ScheduleCreateParams;
import com.epam.training.transport.service.PointService;
import com.epam.training.transport.service.RouteService;
import com.epam.training.transport.service.ScheduleService;
import com.epam.training.transport.utils.Routes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/" + Routes.API_SCHEDULES)
public class ScheduleController {

    public static final String API_GET_ALL = "/" + Routes.API_SCHEDULES;

    @Autowired
    RouteService routeService;
    @Autowired
    PointService pointService;
    @Autowired
    ScheduleService scheduleService;

    ScheduleController() {
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public ScheduleEntity create(@RequestBody ScheduleCreateParams params) {

        return scheduleService.create(params.getRouteId(), params.getTransportId(), params.getDirection(), params.isHoliday(),
            params.getStartTime(), params.getEndTime());
    }

    @PostMapping(value = "/add/transport")
    @ResponseBody
    public ScheduleEntity addTransportToSchedule(@RequestBody RoutePointParams routePointParams) {

        return null;
    }

    @PostMapping(value = "/add/route")
    @ResponseBody
    public ScheduleEntity addRouteToSchedule(@RequestBody RoutePointParams routePointParams) {

        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable
    final long id) {

        return ResponseEntity.ok("Route is deleted!");
    }

    @GetMapping()
    @ResponseBody
    public List<ScheduleEntity> loadAll() {
        return scheduleService.loadAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ScheduleEntity load(@PathVariable
    final long id) {
        return scheduleService.load(id);
    }
}
