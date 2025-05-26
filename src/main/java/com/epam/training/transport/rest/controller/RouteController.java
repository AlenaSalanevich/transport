package com.epam.training.transport.rest.controller;

import static com.epam.training.transport.rest.controller.AbstractController.API_ROUTES;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epam.training.transport.model.db.entity.RouteEntity;
import com.epam.training.transport.model.db.entity.RoutePointEntity;
import com.epam.training.transport.rest.models.AddPointModel;
import com.epam.training.transport.rest.models.RouteModel;
import com.epam.training.transport.rest.models.RouteHashMapModel;
import com.epam.training.transport.service.PointService;
import com.epam.training.transport.service.RouteService;
import com.epam.training.transport.utils.validators.RouteModelValidator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Alena_Salanevich
 */

@Api(tags = "Route controller to create, update and delete routes")
@Controller
@RequestMapping(path = "/" + API_ROUTES)
public class RouteController extends AbstractController {

    @Autowired
    RouteService routeService;
    @Autowired
    PointService pointService;

    @InitBinder({ "routeModel"})
    private void initBinder(WebDataBinder binder) {
        binder.addValidators(new RouteModelValidator());
    }

    RouteController(final RouteService routeService, final PointService pointService) {
        this.routeService = routeService;
        this.pointService = pointService;
    }

    @PostMapping()
    @ApiOperation("Create new route")
    @ResponseBody
    public RouteEntity create(@RequestBody RouteModel routeModel) {
        return routeService.create(routeModel.getNumber(), routeModel.getDescription());
    }

    @PostMapping("/hashmap")
    @ApiOperation("Create new route from hashmap")
    @ResponseBody
    public RouteEntity createFromHashMap(@RequestBody RouteHashMapModel model) {
        String number = model.getProperties().get("number");
        String description = model.getProperties().get("description");
        return routeService.create(number, description);
    }

    @PutMapping(value = "{routeId}/points/{pointId}")
    @ApiOperation("Insert the point to the route")
    @ResponseBody
    public RouteEntity insertPoint(@PathVariable
    final long routeId, @PathVariable
    final long pointId, @RequestParam
    final int sequence) {
        return routeService.insertPoint(routeId, pointId, sequence);
    }

    @PutMapping(value = "{routeId}/points")
    @ApiOperation("Insert list of points to the route")
    @ResponseBody
    public RouteEntity insertPoints(@PathVariable
    final long routeId, @RequestBody
    final List<AddPointModel> points) {
        return routeService.insertPoints(routeId, points);
    }

    @PostMapping(value = "{routeId}/points/{pointId}")
    @ApiOperation("Add the point to the route")
    @ResponseBody
    public RouteEntity addPoint(@PathVariable
    final long routeId, @PathVariable
    final long pointId) {
        return routeService.addPoint(routeId, pointId);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update route by id")
    @ResponseBody
    public RouteEntity update(@PathVariable
    final long id, @RequestBody
    final RouteEntity routeEntity) {
        return routeService.update(id, routeEntity);
    }

    @DeleteMapping(value = "{routeId}/points/{pointId}")
    @ApiOperation("Delete the point from the route")
    @ResponseBody
    public RouteEntity deletePoint(@PathVariable
    final long routeId, @PathVariable
    final long pointId) {
        return routeService.deletePoint(routeId, pointId);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete route by id")
    public ResponseEntity delete(@PathVariable
    final long id) {
        routeService.delete(id);
        return ResponseEntity.ok("Route is deleted!");
    }

    @DeleteMapping(value = "{routeId}/points")
    @ApiOperation("Delete all points from the route")
    @ResponseBody
    public RouteEntity deletePoints(@PathVariable
    final long routeId) {
        return routeService.deletePoints(routeId);
    }

    @GetMapping()
    @ApiOperation("Load all routes by default. Optionally can load routes by same description")
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

    @GetMapping(value = "{routeId}/points")
    @ApiOperation("Load all points from the route")
    @ResponseBody
    public List<RoutePointEntity> loadAllPoints(@PathVariable
    final long routeId) {
        return routeService.loadPoints(routeId);
    }
}