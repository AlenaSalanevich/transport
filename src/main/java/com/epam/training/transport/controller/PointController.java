package com.epam.training.transport.controller;

import com.epam.training.transport.Routes;
import com.epam.training.transport.controller.params.PointCreateParams;
import com.epam.training.transport.model.db.entity.PointEntity;
import com.epam.training.transport.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/" + Routes.API_POINTS)
public class PointController {

    @Autowired
    PointService pointService;
@PostMapping(value = "/add")
  public ResponseEntity<?> create (@RequestBody final PointCreateParams pointParams) {
    String name = pointParams.getName();
    PointEntity point;
    try {
        point = pointService.getOrCreate(name);
    } catch (final RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The point is not added!");
    }
    return ResponseEntity.ok("The point is added!");

}

}
