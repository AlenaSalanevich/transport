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
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * @author Alena_Salanevich
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PointServiceTest.PointServiceTestConfig.class})
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

    PointEntity pointA, pointB, pointC;

    List<PointEntity> points;

    @Before
    public void setUp() throws Exception {
        pointA = new PointEntity(1l, "AAA");
        pointB = new PointEntity(2l, "BAB");
        pointC = new PointEntity(3l, "CCC");
        points = new ArrayList<>();
        points.add(pointA);
        points.add(pointB);
        points.add(pointC);

        when(pointRepository.findByNameIgnoreCase(eq("ccc"))).thenReturn(pointC);

        when(pointRepository.findOne(eq(1l))).thenReturn(pointA);

        when(pointRepository.findAll()).thenReturn(Arrays.asList(pointA, pointB, pointC));

        when(pointRepository.findAllByNameContains(any(String.class))).thenAnswer(
                (Answer<List<PointEntity>>) invocation -> {

                    List<PointEntity> optPoints = new ArrayList<>();

                    String likeChar = (String) invocation.getArguments()[0];
                    if (pointA.getName()
                            .contains(likeChar)) {
                        optPoints.add(pointA);
                    }
                    if (pointB.getName()
                            .contains(likeChar)) {
                        optPoints.add(pointB);
                    }
                    if (pointC.getName()
                            .contains(likeChar)) {
                        optPoints.add(pointC);
                    }
                    return optPoints;
                });
    }

    @After
    public void tearDown() throws Exception {
        Mockito.reset(pointRepository);
    }

    @Test
    public void create() throws Exception {

        pointService.create("BAB");
        ArgumentCaptor<PointEntity> captor = ArgumentCaptor.forClass(PointEntity.class);
        verify(pointRepository, times(1)).save(captor.capture());
        assertEquals("BAB", captor.getValue()
                .getName());
    }

    @Test
    public void delete() throws Exception {
        pointService.delete(2l);
        verify(pointRepository, times(1)).delete(Mockito.eq(2l));
    }

    @Test
    public void loadAll() throws Exception {

        List<PointEntity> pointEntityListByCharA = pointService.loadAll(Optional.of("A"));
        assertEquals(2l, pointEntityListByCharA.size());
        verify(pointRepository, times(1)).findAllByNameContains("A");

        List<PointEntity> pointEntityListAll = pointService.loadAll(Optional.empty());
        assertEquals(points, pointEntityListAll);
        assertEquals(3l, pointEntityListAll.size());
        verify(pointRepository, times(2)).findAll();
    }

    @Test
    public void load() throws Exception {
        PointEntity pointById = pointService.load(1l);
        assertEquals(1l, pointById.getId());
        verify(pointRepository, times(1)).findOne(1l);
    }
    /*
     * @Test public void load() throws Exception { String name = "ccc"; PointEntity pointByName =
     * pointService.load(name); assertEquals("CCC", pointByName.getName());
     * Mockito.verify(pointRepository, Mockito.times(1)).findByNameIgnoreCase(name); }
     */

    @Test
    public void update() throws Exception {
        pointService.update(1l, new PointEntity(1l, "ABC"));
        ArgumentCaptor<PointEntity> captor = ArgumentCaptor.forClass(PointEntity.class);
        verify(pointRepository, times(1)).save(captor.capture());
        assertEquals("ABC",captor.getValue()
                .getName());
        assertEquals(1l, captor.getValue()
                .getId());
    }
}
