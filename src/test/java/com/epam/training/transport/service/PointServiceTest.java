package com.epam.training.transport.service;

import com.epam.training.transport.model.db.entity.PointEntity;
import com.epam.training.transport.model.db.repository.PointRepository;
import com.epam.training.transport.service.impl.PointServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PointServiceTest.PointServiceTestConfig.class})
public class PointServiceTest {

    @Configuration
    static class PointServiceTestConfig {
        @Bean
        public PointService pointService() {
            return new PointServiceImpl();
        }

        @Bean
        public PointRepository pointRepository() {
            return Mockito.mock(PointRepository.class);
        }
    }

    @Autowired
    PointService pointService;
    @Autowired
    PointRepository pointRepository;

    PointEntity point, point1;

    List<PointEntity> points;

    @Before
    public void setUp() throws Exception {
        point = new PointEntity();
        point.setId(1);
        point.setName("AAA");
        point1 = new PointEntity();
        point1.setId(2);
        point1.setName("DDD");
        points = new ArrayList<>();
        points.add(point);
        points.add(point1);

        Mockito.when(pointRepository.findByName(Mockito.eq("AAA")))
            .thenReturn(point);
        Mockito.when(pointRepository.findAll())
            .thenReturn(Arrays.asList(point, point1));
    }

    @After
    public void tearDown() throws Exception {
        Mockito.reset(pointRepository);
    }

    @Test
    public void create() throws Exception {

        pointService.create("BBB");
        ArgumentCaptor<PointEntity> captor = ArgumentCaptor.forClass(PointEntity.class);
        Mockito.verify(pointRepository, Mockito.times(1))
            .save(captor.capture());
        assertEquals(captor.getValue()
            .getName(), "BBB");
    }

    @Test
    public void delete() throws Exception {
        pointService.delete("BBB");
        Mockito.verify(pointRepository, Mockito.times(1))
            .deleteByName(Mockito.eq("BBB"));
    }

    @Test
    public void loadAll() throws Exception {
        List<PointEntity> en = pointService.loadAll();
        assertEquals(en.size(), 2l);
        assertEquals(en, points);
    }

    @Test
    public void load() throws Exception {
        PointEntity point = pointService.load("AAA");
        assertEquals("AAA", point.getName());
    }

    @Test
    public void update() throws Exception {
        pointService.update("AAA", "CCC");
        ArgumentCaptor<PointEntity> captor = ArgumentCaptor.forClass(PointEntity.class);
        Mockito.verify(pointRepository, Mockito.times(1))
            .save(captor.capture());
        assertEquals(captor.getValue()
            .getName(), "CCC");
    }
}
