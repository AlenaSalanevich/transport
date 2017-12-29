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
import java.util.Optional;

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
        point.setId(1l);
        point.setName("AAA");
        point1 = new PointEntity();
        point1.setId(2l);
        point1.setName("DDD");
        points = new ArrayList<>();
        points.add(point);
        points.add(point1);

        Mockito.when(pointRepository.findByNameIgnoreCase(Mockito.eq("AAA")))
            .thenReturn(point);
        Mockito.when(pointRepository.findOne(Mockito.eq(1l)))
            .thenReturn(point);
        Mockito.when(pointRepository.findAll())
            .thenReturn(Arrays.asList(point, point1));
      // Mockito.when(pointRepository.findAllByNameStartsWith(Mockito.any(String.class))).thenAnswer();
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
        pointService.delete(2l);
        Mockito.verify(pointRepository, Mockito.times(1))
            .delete(Mockito.eq(2l));
    }

    @Test
    public void loadAll() throws Exception {

        List<PointEntity> en = pointService.loadAll(Optional.of("a"));
        assertEquals(en.size(), 1l);
        assertEquals(en, points);
    }

    /*
     * @Test public void load() throws Exception { PointEntity point = pointService.load("AAA");
     * assertEquals("AAA", point.getName()); }
     */

    @Test
    public void load() throws Exception {
        PointEntity point = pointService.load(1l);
        assertEquals(1l, point.getId());
    }

   /* @Test
    public void update() throws Exception {
        pointService.update(1l, "CCC");
        ArgumentCaptor<PointEntity> captor = ArgumentCaptor.forClass(PointEntity.class);
        Mockito.verify(pointRepository, Mockito.times(1))
            .save(captor.capture());
        assertEquals(captor.getValue()
            .getName(), "CCC");
    }*/
}
