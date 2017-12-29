package com.epam.training.transport.rest.controller;

import com.epam.training.transport.utils.Routes;
import com.epam.training.transport.rest.params.TransportModel;

import com.epam.training.transport.model.TransportType;
import com.epam.training.transport.model.db.entity.TransportEntity;
import com.epam.training.transport.service.TransportService;
import com.epam.training.transport.utils.TransportModelValidator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api(tags = "Transport controller")
@Controller
@RequestMapping(path = "/" + Routes.API_TRANSPORTS)
public class TransportController {

    public TransportController() {
    }

    @Autowired
    TransportService transportService;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.addValidators(new TransportModelValidator());
    }

    public TransportController(final TransportService transportService) {
        this.transportService = transportService;
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public TransportEntity create(@RequestBody TransportModel model) {

        return transportService.create(model.getRegistrationNumber(), model.isNoFunctionally(), model.getTransportType());
    }

    @PutMapping(value = "/update/{id}")
    @ResponseBody
    public TransportEntity update(@PathVariable
    final long id, @RequestBody TransportModel model) {

        return transportService.update(id, new TransportEntity(model.getRegistrationNumber()
            .trim(), model.getTransportType(), model.isNoFunctionally()));
    }

    @GetMapping("/{id}")
    @ResponseBody
    public TransportEntity load(@PathVariable
    final long id) {

        return transportService.load(id);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> delete(@PathVariable
    final long id) {
        transportService.delete(id);

        return ResponseEntity.ok("Transport is deleted!");
    }

    @GetMapping()
    @ResponseBody
    public List<TransportEntity> loadAll(@ApiParam (name = "Transport type", value = "Transport type in UPPER CASE, for example BUS") @RequestParam
    final Optional<TransportType> type, @ApiParam (name = "Transport functionality", value = " Insert true or false") @RequestParam
    final Optional<Boolean> noFunctionally) {

        return transportService.loadAll(type, noFunctionally);
    }

}
