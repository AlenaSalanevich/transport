package com.epam.training.transport.controller;

import com.epam.training.transport.Routes;
import com.epam.training.transport.controller.params.PointCreateParams;
import com.epam.training.transport.controller.params.PointParams;
import com.epam.training.transport.model.db.entity.PointEntity;
import com.epam.training.transport.service.PointService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/" + Routes.API_POINTS)
public class PointController {

    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(PointController.class);

    @Autowired
    PointService pointService;

    @PostMapping(value = "/add")
    @ResponseBody
    public PointEntity create(@RequestBody
    final PointCreateParams params) {

        return pointService.create(params.getName());
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<?> delete(@RequestBody
    final PointParams params) {
        pointService.delete(params.getId());

        return ResponseEntity.ok("Point is deleted!");
    }

    @PostMapping(value = "/update")
    @ResponseBody
    public PointEntity update(@RequestBody
    final PointParams updateParams) {

        return pointService.update(updateParams.getId(), updateParams.getName());
    }

    @PostMapping(value = "/load")
    @ResponseBody
    public PointEntity load(@RequestBody
    final PointParams params) {

        return pointService.load(params.getId());
    }

    @GetMapping(value = "/load/all")
    @ResponseBody
    public List<PointEntity> loadAll() {

        return pointService.loadAll();
    }
}
