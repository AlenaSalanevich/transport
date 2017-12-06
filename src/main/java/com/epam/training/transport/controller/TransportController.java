package com.epam.training.transport.controller;

import com.epam.training.transport.Routes;

import com.epam.training.transport.controller.params.TransportCreateParams;
import com.epam.training.transport.controller.params.TransportParams;
import com.epam.training.transport.model.TransportType;
import com.epam.training.transport.model.db.entity.TransportEntity;
import com.epam.training.transport.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping(value = "/update")
    @ResponseBody
    public TransportEntity update(@RequestBody TransportParams params) {
        long id = params.getId();
        TransportEntity transport = transportService.load(id);
        String number =
            params.getRegistrationNumber()
                .trim();
        TransportType type = params.getTransportType();
        boolean noFunctionally = params.isNoFunctionally();
       return transportService.update(id, number, noFunctionally, type);
    }

    @PostMapping(value = "/load")
    @ResponseBody
    public TransportEntity load(@RequestBody TransportParams params) {
        return transportService.load(params.getId());
    }

    @PostMapping(value = "/delete")
    @ResponseBody
    public ResponseEntity<?> delete(@RequestBody TransportParams params) {
        transportService.delete(params.getId());
        return ResponseEntity.ok("Transport is deleted!");
    }

    @GetMapping()
    @ResponseBody
    public List<TransportEntity> loadAll() {
        return transportService.loadAll();
    }

}
