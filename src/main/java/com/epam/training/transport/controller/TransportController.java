package com.epam.training.transport.controller;

import com.epam.training.transport.Routes;
import com.epam.training.transport.model.TransportType;
import com.epam.training.transport.model.db.entity.TransportEntity;
import com.epam.training.transport.model.db.repository.TransportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = Routes.API_TRANSPORTS)
public class TransportController {

    public TransportController() {
   System.out.print("hahahah");
    }
@Autowired
    TransportRepository transportRepository;

    @GetMapping
    @ResponseBody
    String getString(){
        TransportEntity transportEntity = new TransportEntity();
        transportEntity.setTransportType(TransportType.BUS);
        transportEntity.setLP("kdvfhj");
        transportRepository.save(transportEntity);
        return "I'm alive!";
    }


}
