package com.epam.training.transport.rest.controller;

import com.epam.training.transport.utils.PointModelValidator;
import com.epam.training.transport.utils.Routes;
import com.epam.training.transport.rest.models.PointModel;
import com.epam.training.transport.model.db.entity.PointEntity;
import com.epam.training.transport.service.PointService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Api(tags = "Point controller")
@Controller
@RequestMapping(path = "/" + Routes.API_POINTS)
public class PointController {

    @Autowired
    PointService pointService;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.addValidators(new PointModelValidator());
    }

    @PostMapping(value = "/add")
    @ApiOperation("Create new PointEntity")
    @ResponseBody
    public PointEntity create(@Valid
    @RequestBody
    final PointModel model) {

        return pointService.create(model.getName()
            .trim()
            .toUpperCase());
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete point by id")
    public ResponseEntity<?> delete(@PathVariable
    final long id) {
        pointService.delete(id);

        return ResponseEntity.ok("Point is deleted!");
    }

    @PutMapping(value = "/update/{id}")
    @ApiOperation("Update point by id  with same parameters")
    @ResponseBody
    public PointEntity update(@PathVariable
    final long id, @RequestBody
    @Valid
    final PointModel model) {

        return pointService.update(id, new PointEntity(id, model.getName()
            .trim()
            .toUpperCase()));
    }

    @GetMapping("/{id}")
    @ApiOperation("Load point by id")
    @ResponseBody
    public PointEntity load(@PathVariable
    final long id) {

        return pointService.load(id);
    }

    @GetMapping()
    @ApiOperation("Load all points by default. Load points by name like same chars")
    @ResponseBody
    public List<PointEntity> loadAll(@ApiParam (value = "Search point by same symbols") @RequestParam (required = false)
    final String likeChars) {
               return pointService.loadAll( Optional.ofNullable(likeChars));
    }

    @GetMapping("/load")
    @ApiOperation("Load point by the name")
    @ResponseBody
    public PointEntity loadByName(@RequestParam
    final String name) {
        return pointService.load(name.trim());
    }
}
