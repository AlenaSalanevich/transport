package com.epam.training.transport.rest.controller;

import static com.epam.training.transport.rest.controller.AbstractController.API_TRANSPORTS;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.epam.training.transport.model.TransportType;
import com.epam.training.transport.model.db.entity.TransportEntity;
import com.epam.training.transport.rest.models.TransportModel;
import com.epam.training.transport.service.TransportService;
import com.epam.training.transport.utils.validators.TransportModelValidator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author Alena_Salanevich
 */

@Api(tags = "Transport controller to create, update and delete transport")
@Controller
@RequestMapping(path = "/" + API_TRANSPORTS)
public class TransportController extends AbstractController {

    public TransportController() {
    }

    @Autowired
    TransportService transportService;

    @InitBinder({ "transportModel"})
    private void initBinder(WebDataBinder binder) {
        binder.addValidators(new TransportModelValidator());
    }

    public TransportController(final TransportService transportService) {
        this.transportService = transportService;
    }

    @PostMapping()
    @ApiOperation("Create new transport")
    @ResponseBody
    public TransportEntity create(@RequestBody TransportModel transportModel) {
        return transportService.create(transportModel.getRegistrationNumber(), transportModel.getTransportType(), transportModel
            .isFunctionality());
    }

    @PutMapping(value = "{id}")
    @ApiOperation("Update transport by id with same parameters")
    @ResponseBody
    public TransportEntity update(@PathVariable
    final long id, @RequestBody TransportModel transportModel) {

        return transportService.update(id, new TransportEntity(id, transportModel.getRegistrationNumber()
            .trim(), transportModel.getTransportType(), transportModel.isFunctionality()));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete transport by id")
    @ResponseBody
    public ResponseEntity delete(@PathVariable
    final long id) {
        transportService.delete(id);

        return ResponseEntity.ok("Transport is deleted!");
    }

    @GetMapping("/{id}")
    @ApiOperation("Load transport by id")
    @ResponseBody
    public TransportEntity load(@PathVariable
    final long id) {

        return transportService.load(id);
    }

    @GetMapping()
    @ApiOperation("Load all transports by default. Load transports by parameters: transport type or functionality")
    @ResponseBody
    public List<TransportEntity> loadAll(
        @ApiParam(value = "Select the transport type, for example BUS", allowableValues = "BUS, TRAM, TROLLEYBUS")
        @RequestParam(required = false)
        final Optional<TransportType> type,
        @ApiParam(value = "Select true or false", allowableValues = "true, false")
        @RequestParam(required = false)
        final Optional<Boolean> functionality) {
        return transportService.loadAll(type, functionality);
    }
}
