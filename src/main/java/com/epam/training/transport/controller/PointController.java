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
        public ResponseEntity<?> create(@RequestBody
    final PointParams params) {

        String name = params.getName();
        if (name.isEmpty()) {
            LOGGER.warn(params);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Parameter name couldn't be empty!");
        }
        PointEntity point = null;
        try {point = pointService.create(name);}
        catch (RuntimeException e){
            LOGGER.error(e.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());

        }
        return ResponseEntity.ok(point);
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<?> delete(@RequestBody
    final PointParams params) {
        String name = params.getName();
        if (name.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("The parameter name can't be empty!");
        }
        try {
            pointService.delete(name);
        } catch (RuntimeException e) {
            LOGGER.error(e.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(e.getLocalizedMessage()));
        }
        return ResponseEntity.ok("Point is deleted!");
    }

    @PostMapping(value = "/update")
    public ResponseEntity<?> update(@RequestBody
    final PointUpdateParams params) {
        String oldName = params.getOldName();
        String newName = params.getNewName();
        if (oldName.isEmpty() || newName.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("The parameters can't be nullable!");
        }
        pointService.update(oldName, newName);
        return (ResponseEntity<?>) ResponseEntity.ok("The point is updated!");
    }

    @PostMapping(value = "/load")
    public ResponseEntity<?> load(@RequestBody
    final PointParams params) {
        String name = params.getName();
        if (name.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("The parameter name can't be empty!");
        }
        return ResponseEntity.ok(pointService.load(name));
    }

    @GetMapping(value = "/load/all")
    @ResponseBody
    public Iterable<PointEntity> loadAll() {

        return pointService.loadAll();
    }
}
