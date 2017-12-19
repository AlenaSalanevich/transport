package com.epam.training.transport.rest.controller;

import com.epam.training.transport.model.db.entity.RoutePointEntity;
import com.epam.training.transport.rest.params.RoutePointDeleteParams;
import com.epam.training.transport.utils.Routes;
import com.epam.training.transport.rest.params.RouteCreateParams;
import com.epam.training.transport.rest.params.RoutePointParams;
import com.epam.training.transport.model.db.entity.PointEntity;
import com.epam.training.transport.model.db.entity.RouteEntity;
import com.epam.training.transport.service.PointService;
import com.epam.training.transport.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/" + Routes.API_ROUTES)
public class RouteController {

    @Autowired
    RouteService routeService;
    @Autowired
    PointService pointService;

    RouteController(final RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public RouteEntity create(@RequestBody RouteCreateParams params) {
        String number =
            params.getNumber()
                .trim();
        if (number.isEmpty()) {
            throw new NullPointerException();
        }
        return routeService.create(params.getNumber(), params.getDescription());
    }

    @PostMapping(value = "/add/point")
    @ResponseBody
    public RouteEntity addPointToRoute(@RequestBody RoutePointParams routePointParams) {

        RouteEntity route = routeService.load(routePointParams.getRouteId());
        PointEntity point = pointService.load(routePointParams.getPointId());
        int sequence = routePointParams.getSequence();
        if (sequence == 0) {
            throw new NullPointerException();
        }
        routeService.addPointToRoute(route, point, sequence);

        return route;
    }

    @PostMapping(value = "/delete/point")
    @ResponseBody
    public RouteEntity deletePointFromRoute(@RequestBody RoutePointDeleteParams params) {
        final long routeId = params.getRouteId();
        final long pointId = params.getPointId();
        return routeService.deletePointFromRoute(routeId, pointId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable
    final long id) {
        routeService.delete(id);
        return ResponseEntity.ok("Route is deleted!");
    }

    @GetMapping()
    @ResponseBody
    public List<RouteEntity> loadAll() {
        return routeService.loadAll().stream().sorted().collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public RouteEntity load(@PathVariable
    final long id) {
        return routeService.load(id);
    }

}
