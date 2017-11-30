package com.epam.training.transport.controller;

import com.epam.training.transport.Routes;

import com.epam.training.transport.model.db.repository.TransportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/" + Routes.API_TRANSPORTS)
public class TransportController {

    public TransportController() {
            }

    @Autowired
    TransportRepository transportRepository;

    @GetMapping
    @ResponseBody
    String getString() {
        return "I'm alive!";
    }


}
