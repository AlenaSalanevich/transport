package com.epam.training.transport.rest.controller;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.clearInvocations;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.training.transport.model.db.entity.PointEntity;
import com.epam.training.transport.rest.models.PointModel;
import com.epam.training.transport.service.PointService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(secure = false, controllers = PointController.class)
public class PointControllerTest extends AbstractTestNGSpringContextTests {

    private static final Long ID = 1l;
    private static final String NAME = "ABC";
    public static final String UP_NAME = NAME.concat("_UPDATE");

    @Autowired
    private MockMvc mvc;

    @Autowired
    @MockBean
    private PointService pointService;

    private PointEntity pointEntity;
    private PointModel pointModel;

    @BeforeMethod
    public void setUp() throws Exception {
        initMocks(this);
        reset(pointService);
        clearInvocations(pointService);
        pointEntity = new PointEntity(ID, NAME);
        pointModel = new PointModel(NAME);
    }

    @AfterMethod
    public void tearDown() throws Exception {
    }

    @Test
    public void testCreate() throws Exception {
        Mockito.when(pointService.create(anyString()))
            .thenReturn(pointEntity);
        mvc.perform(post("/api/points").content(new ObjectMapper().writeValueAsString(pointModel))
            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(jsonPath("$.id", is(ID.intValue())))
            .andExpect(jsonPath("$.name", is(NAME)))
            .andReturn();
        verify(pointService).create(anyString());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testDelete() throws Exception {
        mvc.perform(delete("/api/points/".concat(ID.toString())))
            .andDo(print())
            .andExpect(status().isOk())
            .andReturn();
        verify(pointService).delete(anyLong());
    }

    @Test
    public void testUpdate() throws Exception {
        pointEntity.setName(UP_NAME);
        pointModel.setName(UP_NAME);
        Mockito.when(pointService.update(anyLong(), any(PointEntity.class)))
            .thenReturn(pointEntity);
        mvc.perform(put("/api/points/".concat(ID.toString())).content(new ObjectMapper().writeValueAsString(pointModel))
            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(jsonPath("$.id", is(ID.intValue())))
            .andExpect(jsonPath("$.name", is(UP_NAME)))
            .andReturn();
        verify(pointService).update(anyLong(), any(PointEntity.class));
    }

    @Test
    public void testLoad() throws Exception {
        Mockito.when(pointService.load(anyLong()))
            .thenReturn(pointEntity);
        mvc.perform(get("/api/points/".concat(ID.toString())))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(jsonPath("$.id", is(ID.intValue())))
            .andExpect(jsonPath("$.name", is(NAME)))
            .andReturn();
        verify(pointService).load(anyLong());
    }

    @Test
    public void testLoadAll() throws Exception {

        Mockito.when(pointService.loadAll(any()))
            .thenReturn(Collections.singletonList(pointEntity));
        mvc.perform(get("/api/points"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(jsonPath("$.[0]id", is(ID.intValue())))
            .andExpect(jsonPath("$.[0]name", is(NAME)))
            .andReturn();
        verify(pointService).loadAll(any());
    }
}
