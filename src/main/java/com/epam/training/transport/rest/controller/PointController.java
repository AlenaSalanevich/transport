package com.epam.training.transport.rest.controller;

import com.epam.training.transport.utils.Routes;
import com.epam.training.transport.rest.params.PointCreateParams;
import com.epam.training.transport.rest.params.PointParams;
import com.epam.training.transport.model.db.entity.PointEntity;
import com.epam.training.transport.service.PointService;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Point controller")
@Controller
@RequestMapping(path = "/" + Routes.API_POINTS)
public class PointController {

    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(PointController.class);

    @Autowired
    PointService pointService;

    @PostMapping(value = "/add")
    @ResponseBody
    public PointEntity create(@RequestBody final PointCreateParams params) {

        return pointService.create(params.getName());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable final long id) {
        pointService.delete(id);

        return ResponseEntity.ok("Point is deleted!");
    }

    @PutMapping(value = "/update")
    @ResponseBody
    public PointEntity update(@RequestBody final PointParams updateParams) {
        String name =
                updateParams.getName()
                        .trim();
        if ((name.isEmpty()) || (name.equals(""))) {
            return pointService.load(updateParams.getId());
        }
        return pointService.update(updateParams.getId(), name);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public PointEntity load(@PathVariable final long id) {

        return pointService.load(id);
    }

    @GetMapping()
    @ResponseBody
    public List<PointEntity> loadAll() {

        return pointService.loadAll();
    }
}
