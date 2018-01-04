package com.epam.training.transport.rest.controller;

import com.epam.training.transport.model.db.entity.AssignmentEntity;
import com.epam.training.transport.rest.models.RoutePointModel;
import com.epam.training.transport.rest.models.AssignmentModel;
import com.epam.training.transport.service.PointService;
import com.epam.training.transport.service.RouteService;
import com.epam.training.transport.service.AssignmentService;
import com.epam.training.transport.utils.Routes;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Alena_Salanevich
 */

@Controller
@RequestMapping(path = "/" + Routes.API_ASSIGNMENTS)
public class AssignmentController {

    @Autowired
    RouteService routeService;
    @Autowired
    PointService pointService;
    @Autowired
    AssignmentService assignmentService;

    public AssignmentController() {
    }

    public AssignmentController(
            final RouteService routeService,
            final PointService pointService,
            final AssignmentService assignmentService) {
        this.pointService = pointService;
        this.assignmentService = assignmentService;
        this.routeService = routeService;
    }

    @GetMapping()
    @ResponseBody
    public List<AssignmentEntity> loadAll(@RequestParam final Optional<Boolean> optIsHoliday) {
        return assignmentService.loadAll(optIsHoliday);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public AssignmentEntity load(@PathVariable final long id) {
        return assignmentService.load(id);
    }

    @PostMapping(value = "{routeId}/{transportId}")
    @ApiOperation("Create new Assignment entity")
    @ResponseBody
    public AssignmentEntity create(@PathVariable final long routeId, @PathVariable final long transportId, @RequestBody final AssignmentModel model) {

        return assignmentService.create(routeId, transportId, model.getDirection(), model.isHoliday());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable final long id) {

        return ResponseEntity.ok("Assignment is deleted!");
    }
}