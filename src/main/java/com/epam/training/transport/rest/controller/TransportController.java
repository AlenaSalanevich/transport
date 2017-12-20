package com.epam.training.transport.rest.controller;

import com.epam.training.transport.utils.Routes;

import com.epam.training.transport.rest.params.TransportCreateParams;
import com.epam.training.transport.rest.params.TransportParams;
import com.epam.training.transport.model.TransportType;
import com.epam.training.transport.model.db.entity.TransportEntity;
import com.epam.training.transport.service.TransportService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Api(tags = "Transport controller")
@Controller
@RequestMapping(path = "/" + Routes.API_TRANSPORTS)
public class TransportController {

    public TransportController() {
    }

    @Autowired
    TransportService transportService;

    public TransportController(final TransportService transportService) {
        this.transportService = transportService;
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public TransportEntity create(@RequestBody TransportCreateParams params) {

        return transportService.create(params.getRegistrationNumber(), params.isNoFunctionally(), params.getTransportType());
    }

    @PutMapping(value = "/update")
    @ResponseBody
    public TransportEntity update(@RequestBody TransportParams params) {

        final long id = params.getId();
        final String number =
            params.getRegistrationNumber()
                .trim();
        final TransportType type = params.getTransportType();
        final boolean noFunctionally = params.isNoFunctionally();
        return transportService.update(id, number, noFunctionally, type);
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
    public List<TransportEntity> loadAll(@RequestParam
    final Optional<TransportType> transportType, @RequestParam
    final Optional<Boolean> noFunctionally) {

        return transportService.loadAll(transportType, noFunctionally);
    }

}
