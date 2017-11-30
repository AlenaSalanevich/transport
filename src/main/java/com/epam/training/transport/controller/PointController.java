package com.epam.training.transport.controller;

import com.epam.training.transport.Routes;
import com.epam.training.transport.controller.params.PointParams;
import com.epam.training.transport.controller.params.PointUpdateParams;
import com.epam.training.transport.controller.response.ErrorResponse;
import com.epam.training.transport.model.db.entity.PointEntity;
import com.epam.training.transport.service.PointService;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PersistenceException;

@Controller
@RequestMapping(path = "/" + Routes.API_POINTS)
public class PointController {

    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(PointController.class);

    @Autowired
    PointService pointService;

    @PostMapping(value = "/add")
    @ResponseBody
    public PointEntity create(@RequestBody
    final PointParams params) {
        return pointService.create(params.getName());
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<?> delete(@RequestBody
    final PointParams params) {
        pointService.delete(params.getName());
        return ResponseEntity.ok("Point is deleted!");
    }

    @PostMapping(value = "/update")
    public ResponseEntity<?> update(@RequestBody
    final PointUpdateParams params) {
        pointService.update(params.getName(), params.getNewName());
        return ResponseEntity.ok("The point is updated!");
    }

    @PostMapping(value = "/load")
    public ResponseEntity<?> load(@RequestBody
    final PointParams params) {
        return ResponseEntity.ok(pointService.load(params.getName()));
    }

    @GetMapping(value = "/load/all")
    @ResponseBody
    public Iterable<PointEntity> loadAll() {

        return pointService.loadAll();
    }
}
