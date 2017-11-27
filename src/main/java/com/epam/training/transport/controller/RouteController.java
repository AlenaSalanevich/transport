package com.epam.training.transport.controller;

import com.epam.training.transport.Routes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/"+ Routes.API_ROUTES)
public class RouteController {
}
