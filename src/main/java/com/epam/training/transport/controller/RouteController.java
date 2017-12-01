package com.epam.training.transport.controller;

import com.epam.training.transport.Routes;
import com.epam.training.transport.controller.params.RouteParams;
import com.epam.training.transport.controller.params.RouteUpdateParams;
import com.epam.training.transport.model.db.entity.RouteEntity;
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

    RouteController(final RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public RouteEntity create(@RequestBody RouteParams params) {
        return routeService.create(params.getNumber(), params.getDescription());
    }

    @PostMapping(value = "/update")
    @ResponseBody
    public RouteEntity update(@RequestBody RouteUpdateParams updateParams) {
        return routeService.update(updateParams.getNewNumber(), updateParams.getNewNumber());
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<?> delete(@RequestBody RouteParams params) {
        routeService.delete(params.getNumber());
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
        return routeService.load(params.getNumber());
    }
}
