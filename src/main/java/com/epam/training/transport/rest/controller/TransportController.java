package com.epam.training.transport.rest.controller;

import com.epam.training.transport.utils.Routes;
import com.epam.training.transport.rest.models.TransportModel;

import com.epam.training.transport.model.TransportType;
import com.epam.training.transport.model.db.entity.TransportEntity;
import com.epam.training.transport.service.TransportService;
import com.epam.training.transport.utils.TransportModelValidator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Alena_Salanevich
 */

@Api(tags = "Transport controller to create, update and delete transport")
@Controller
@RequestMapping(path = "/" + Routes.API_TRANSPORTS)
public class TransportController {

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
    public ResponseEntity<?> delete(@PathVariable
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
    /*
     * @GetMapping("/load")
     * 
     * @ApiOperation("Load transports by registration number")
     * 
     * @ResponseBody public List<TransportEntity> load(@ApiParam(value =
     * "load transports by same number", example = "1214")
     * 
     * @RequestParam final String registrationNumber) {
     * 
     * return transportService.loadLike(registrationNumber); }
     */

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
