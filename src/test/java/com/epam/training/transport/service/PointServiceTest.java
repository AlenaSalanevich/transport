package com.epam.training.transport.service;

import com.epam.training.transport.model.db.entity.PointEntity;
import com.epam.training.transport.model.db.repository.PointRepository;
import com.epam.training.transport.service.exceptions.ServiceException;
import com.epam.training.transport.service.impl.PointServiceImpl;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

/**
 * @author Alena_Salanevich
 */

@ContextConfiguration(classes = { PointServiceTest.PointServiceTestConfig.class})
public class PointServiceTest extends AbstractTestNGSpringContextTests {

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

    PointService pointService;

    @Autowired
    PointRepository pointRepository;

    PointEntity pointA, pointB, pointC;

    List<PointEntity> points;

    @BeforeMethod
    public void setUp() throws Exception {

        pointService = new PointServiceImpl(pointRepository);

        pointA = new PointEntity(1l, "AAA");
        pointB = new PointEntity(2l, "BAB");
        pointC = new PointEntity(3l, "CCC");
        points = new ArrayList<>();
        points.add(pointA);
        points.add(pointB);
        points.add(pointC);

        when(pointRepository.findByNameLike(eq("ccc"))).thenReturn(pointC);

        when(pointRepository.findOne(eq(1l))).thenReturn(pointA);

        when(pointRepository.findAll()).thenReturn(Arrays.asList(pointA, pointB, pointC));

        when(pointRepository.findAllByNameContains(any(String.class))).thenAnswer((Answer<List<PointEntity>>) invocation -> {

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

    @AfterMethod
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

    @Test(expectedExceptions = ServiceException.class)
    public void createThrowException() throws Exception {
        when(pointRepository.save(any(PointEntity.class))).thenThrow(DataIntegrityViolationException.class);
        pointService.create("BAB");
    }

    @Test
    public void delete() throws Exception {
        pointService.delete(2l);
        verify(pointRepository, times(1)).delete(Mockito.eq(2l));
    }

    @Test(expectedExceptions = ServiceException.class)
    public void deleteThrowException() throws Exception {
        doAnswer(invocation -> {
            throw new EmptyResultDataAccessException(1);
        }).when(pointRepository)
            .delete(anyLong());
        pointService.delete(2l);
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

    @Test
    public void loadByName() throws Exception {
        String name = "ccc";
        PointEntity pointByName = pointService.load(name);
        assertEquals("CCC", pointByName.getName());
        Mockito.verify(pointRepository, Mockito.times(1))
            .findByNameLike(name);
    }

    @Test
    public void update() throws Exception {
        pointService.update(1l, new PointEntity(1l, "ABC"));
        ArgumentCaptor<PointEntity> captor = ArgumentCaptor.forClass(PointEntity.class);
        verify(pointRepository, times(1)).save(captor.capture());
        assertEquals("ABC", captor.getValue()
            .getName());
        assertEquals(1l, captor.getValue()
            .getId());
    }

    @Test(expectedExceptions = ServiceException.class)
    public void updateThrowException() throws Exception {
        when(pointRepository.save(any(PointEntity.class))).thenThrow(DataIntegrityViolationException.class);
        pointService.update(1l, new PointEntity(1l, "ABC"));
    }

    @Test
    public void loadByListId() {
        List<PointEntity> pointEntityList = pointService.loadByListId(Arrays.asList(1l, 2l));
        assertEquals(2, pointEntityList.size());
        assertEquals(pointA, pointEntityList.stream()
            .findFirst()
            .get());
        Mockito.verify(pointRepository, Mockito.times(2))
            .findOne(anyLong());
    }

}
