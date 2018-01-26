package com.epam.training.transport.rest.controller;

import com.epam.training.transport.model.db.entity.PointEntity;
import com.epam.training.transport.rest.models.PointModel;
import com.epam.training.transport.service.PointService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;

import static org.hamcrest.Matchers.is;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.testng.Assert.*;

import static org.mockito.Mockito.*;

@WebMvcTest(secure = false, controllers = PointController.class)
public class PointControllerTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private MockMvc mvc;

    @Autowired
    @MockBean
    private PointService pointService;

    PointEntity pointEntity;

    @BeforeMethod
    public void setUp() throws Exception {
        initMocks(this);
        reset(pointService);
        clearInvocations(pointService);
        pointEntity = new PointEntity(1, "ABC");
    }

    @AfterMethod
    public void tearDown() throws Exception {
    }

    @Test
    public void testCreate() throws Exception {
        Mockito.when(pointService.create(anyString()))
            .thenReturn(pointEntity);
        PointModel pointModel = new PointModel("ABC");
        mvc.perform(post("/api/points")
            .content(new ObjectMapper().writeValueAsString(pointModel))
            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(status().isOk())
           /*     .andExpect(model().size(1))*/
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(jsonPath("$.pointEntity.id", is(pointEntity.getId())))
            .andExpect(jsonPath("$.pointEntity.name", is(pointEntity.getName())))
            .andReturn();

        verify(pointService).create(anyString());
    }

    @Test
    public void testDelete() throws Exception {
    }

    @Test
    public void testUpdate() throws Exception {
    }

    @Test
    public void testLoad() throws Exception {
    }

    @Test
    public void testLoadAll() throws Exception {
    }
}
