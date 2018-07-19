package com.epam.training.transport.rest.controller;

import static com.epam.training.transport.rest.controller.AbstractController.API_POINTS;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

import com.epam.training.transport.model.db.entity.PointEntity;
import com.epam.training.transport.rest.models.PointModel;
import com.epam.training.transport.service.PointService;
import com.epam.training.transport.utils.validators.PointModelValidator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author Alena_Salanevich
 */

@Api(tags = "Point controller to create, update and delete points")
@Controller
@RequestMapping(path = "/" + API_POINTS)
public class PointController extends AbstractController {

    @Autowired
    PointService pointService;

    @InitBinder({ "pointModel"})
    private void initBinder(WebDataBinder binder) {
        binder.addValidators(new PointModelValidator());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("Create new PointEntity")
    @ResponseBody
    public PointEntity create(@Valid
    @RequestBody
    final PointModel pointModel) {

        return pointService.create(pointModel.getName()
            .trim()
            .toUpperCase());
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete point by id")
    public ResponseEntity delete(@PathVariable
    final long id) {
        pointService.delete(id);

        return ResponseEntity.ok("Point is deleted!");
    }

    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
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

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("Load point by id")
    @ResponseBody
    public PointEntity load(@PathVariable
    final long id) {
        return pointService.load(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("Load all points by default. Load points by name likes same chars")
    @ResponseBody
    public List<PointEntity> loadAll(@ApiParam(value = "Search point by same symbols")
    @RequestParam(required = false)
    final String likeChars) {
        return pointService.loadAll(Optional.ofNullable(likeChars));
    }
}
