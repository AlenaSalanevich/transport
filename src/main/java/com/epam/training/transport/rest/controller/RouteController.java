package com.epam.training.transport.rest.controller;

import com.epam.training.transport.rest.models.RouteModel;

import com.epam.training.transport.utils.RouteModelValidator;
import com.epam.training.transport.utils.RoutePointModelValidator;
import com.epam.training.transport.utils.Routes;
import com.epam.training.transport.rest.models.RoutePointModel;
import com.epam.training.transport.model.db.entity.RouteEntity;
import com.epam.training.transport.service.PointService;
import com.epam.training.transport.service.RouteService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path = "/" + Routes.API_ROUTES)
public class RouteController {

    @Autowired
    RouteService routeService;
    @Autowired
    PointService pointService;

/*    @InitBinder ()
    private void initBinder(WebDataBinder binder) {
        binder.addValidators(new RouteModelValidator(), new RoutePointModelValidator());
    }*/

    RouteController(final RouteService routeService, final PointService pointService) {
        this.routeService = routeService;
        this.pointService = pointService;
    }

    @PostMapping(value = "/add")
    @ApiOperation("Create new RouteEntity")
    @ResponseBody
    public RouteEntity create(@RequestBody RouteModel model) {

        return routeService.create(model.getNumber(), model.getDescription());
    }

    @PostMapping(value = "/add/point/{routeId}/{pointId}")
    @ApiOperation("Add new point to the route")
    @ResponseBody
    public RouteEntity addPointToRoute(@PathVariable final long routeId, @PathVariable final long pointId, @RequestBody RoutePointModel routePointModel) {

        return routeService.addPointToRoute(routeId, pointId, routePointModel.getSequence(), routePointModel
            .getDepartureTime());
    }

    /*
     * @PutMapping("/{id}")
     * 
     * @ResponseBody public RouteEntity update(@PathVariable final long id, @RequestBody RouteModel
     * model){ return routeService.update(id, model); }
     */

    @DeleteMapping(value = "/{routeId}/{pointId}")
    @ApiOperation("Delete point by id from the route")
    @ResponseBody
    public RouteEntity deletePointFromRoute(@PathVariable
    final long routeId, @PathVariable
    final long pointId) {
        return routeService.deletePointFromRoute(routeId, pointId);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete route by id")
    public ResponseEntity<?> delete(@PathVariable
    final long id) {
        routeService.delete(id);
        return ResponseEntity.ok("Route is deleted!");
    }

    @GetMapping()
    @ApiOperation("Load all routes  by default. Optionally can load routes by same description")
    @ResponseBody
    public List<RouteEntity> loadAll() {
        return routeService.loadAll();
    }

    @GetMapping("/{id}")
    @ApiOperation("Load route by id")
    @ResponseBody
    public RouteEntity load(@PathVariable
    final long id) {
        return routeService.load(id);
    }

}
