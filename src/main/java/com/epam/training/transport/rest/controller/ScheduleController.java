package com.epam.training.transport.rest.controller;

import com.epam.training.transport.model.db.entity.ScheduleEntity;
import com.epam.training.transport.service.ScheduleService;
import com.epam.training.transport.utils.routes.Routes;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Alena_Salanevich
 *
 * @deprecated
 */


@Controller
@RequestMapping(path = "/" + Routes.API_SCHEDULES)
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    public ScheduleController() {
    }

    @GetMapping()
    @ResponseBody
    @ApiOperation("Load all schedules")
    public List<ScheduleEntity> loadAll() {
        return scheduleService.loadAll();
    }

}
