package com.epam.training.transport.controller;

import com.epam.training.transport.Routes;
import com.epam.training.transport.controller.params.RouteCreateParams;
import com.epam.training.transport.controller.params.RouteParams;
import com.epam.training.transport.controller.params.RoutePointParams;
import com.epam.training.transport.controller.params.views.RouteView;
import com.epam.training.transport.model.db.entity.PointEntity;
import com.epam.training.transport.model.db.entity.RouteEntity;
import com.epam.training.transport.model.db.entity.RoutePointEntity;
import com.epam.training.transport.service.PointService;
import com.epam.training.transport.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return routeService.create(params.getNumber(), params.getDescription());
    }

    @PostMapping(value = "/add/point")
    @ResponseBody
    public RouteView addPointToRoute(@RequestBody RoutePointParams routePointParams) {

        RouteEntity route = routeService.load(routePointParams.getRouteId());
        PointEntity point = pointService.load(routePointParams.getPointId());
        String sequence = routePointParams.getSequence();
        routeService.addPointToRoute(route, point, sequence);

        RouteView routeView = new RouteView(route.getId(), route.getNumber(), route.getDescription(), route.getRoutePoints());
        return routeView;
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<?> delete(@RequestBody RouteParams params) {
        routeService.delete(params.getId());
        return ResponseEntity.ok("Route is deleted!");
    }

    @GetMapping(value = "/load/all")
    @ResponseBody
    public List<RouteEntity> loadAll() {
        return routeService.loadAll();
    }

    @PostMapping(value = "/load")
    @ResponseBody
    public RouteEntity load(@RequestBody RouteParams params) {
        return routeService.load(params.getId());
    }
}
