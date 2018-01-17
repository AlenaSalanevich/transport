package com.epam.training.transport.rest.controller;

import com.epam.training.transport.model.db.entity.AssignmentEntity;
import com.epam.training.transport.rest.models.AssignmentModel;
import com.epam.training.transport.service.PointService;
import com.epam.training.transport.service.RouteService;
import com.epam.training.transport.service.AssignmentService;
import com.epam.training.transport.utils.routes.Routes;
import io.swagger.annotations.Api;
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
@Api(tags = "Controller for assignment transport, route and departure time to schedule")
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
    @ApiOperation("Load all assignments ")
    public List<AssignmentEntity> loadAll(@RequestParam
    final Optional<Boolean> optIsHoliday) {
        return assignmentService.loadAll(optIsHoliday);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public AssignmentEntity load(@PathVariable
    final long id) {
        return assignmentService.load(id);
    }

    @PostMapping()
    @ApiOperation("Create new Assignment entity")
    @ResponseBody
    public AssignmentEntity create(@RequestBody
    final AssignmentModel assignmentModel) {

        return assignmentService.create(assignmentModel.getTransportId(), assignmentModel.getRouteId(), assignmentModel
            .getDirection(), assignmentModel.isHoliday(), assignmentModel.getScheduleModelList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable
    final long id) {
assignmentService.delete(id);
        return ResponseEntity.ok("Assignment is deleted!");
    }
}
