package com.epam.training.transport.rest.controller;

import com.epam.training.transport.rest.params.RoutePointDeleteParams;
import com.epam.training.transport.service.exceptions.ErrorCode;
import com.epam.training.transport.service.exceptions.ServiceException;
import com.epam.training.transport.utils.Routes;
import com.epam.training.transport.rest.params.RouteCreateParams;
import com.epam.training.transport.rest.params.RoutePointParams;
import com.epam.training.transport.model.db.entity.RouteEntity;
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

    RouteController(final RouteService routeService, final PointService pointService) {
        this.routeService = routeService;
        this.pointService = pointService;
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public RouteEntity create(@RequestBody RouteCreateParams params) {
        final String number =
            params.getNumber()
                .trim();
        if (number.isEmpty()) {
            throw new ServiceException(ErrorCode.REQUIRED_FIELD);
        }
        return routeService.create(number, params.getDescription());
    }

    @PostMapping(value = "/add/point")
    @ResponseBody
    public RouteEntity addPointToRoute(@RequestBody RoutePointParams routePointParams) {

        final long routeId = routePointParams.getRouteId();
        final long pointId = routePointParams.getPointId();
        final int sequence = routePointParams.getSequence();

        if (sequence == 0) {
            throw new ServiceException(ErrorCode.REQUIRED_FIELD);
        }

        return routeService.addPointToRoute(routeId, pointId, sequence);
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
        return routeService.loadAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public RouteEntity load(@PathVariable
    final long id) {
        return routeService.load(id);
    }

}
