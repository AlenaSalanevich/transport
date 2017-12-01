package com.epam.training.transport.controller;

import com.epam.training.transport.Routes;

import com.epam.training.transport.controller.params.TransportParams;
import com.epam.training.transport.controller.params.TransportUpdateParams;
import com.epam.training.transport.model.TransportType;
import com.epam.training.transport.model.db.entity.TransportEntity;
import com.epam.training.transport.model.db.repository.TransportRepository;
import com.epam.training.transport.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.plugin2.message.transport.Transport;

import java.util.List;

@Controller
@RequestMapping(path = "/" + Routes.API_TRANSPORTS)
public class TransportController {

    public TransportController() {
    }

    @Autowired
    TransportService transportService;

    @PostMapping(value = "/add")
    @ResponseBody
    public TransportEntity create(@RequestBody TransportParams params) {

        return transportService.create(params.getLP(), params.isNoFunctionally(), params.getTransportType());
    }

    @PostMapping(value = "/update")
    @ResponseBody
    public TransportEntity update (@RequestBody TransportUpdateParams params){
        return transportService.update(transportService.load(params.getId()).getLP(),params.getNewLP());
    }

    @PostMapping(value = "/load")
    @ResponseBody
    public TransportEntity load (@RequestBody TransportParams params){
        return transportService.load(params.getLP());
    }

    @PostMapping(value = "/delete")
    @ResponseBody
    public ResponseEntity<?> delete (@RequestBody TransportParams params){
        transportService.delete(params.getLP());
        return ResponseEntity.ok("Transport is deleted!");
    }

    @GetMapping(value = "/load/all")
    @ResponseBody
    public List<TransportEntity> loadAll (){
        return  transportService.loadAll();
    }

}
