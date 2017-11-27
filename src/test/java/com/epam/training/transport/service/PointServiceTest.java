
package com.epam.training.transport.service;

import com.epam.training.transport.model.db.entity.PointEntity;
import com.epam.training.transport.model.db.repository.PointRepository;
import com.epam.training.transport.service.impl.PointServiceImpl;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

//@SpringBootTest
@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = PointServiceTest.TestConfig.class)
public class PointServiceTest  {

    @TestConfiguration
    public static class TestConfig {

        @Bean
        public PointService pointService() {
            return new PointServiceImpl();
        }
    }

    @Autowired
    private PointService pointService;

    @Autowired
    private PointEntity pointEntity;

    @MockBean
    private PointRepository pointRepository;

    @BeforeMethod
    public void setUp() throws Exception {
        PointEntity pointEntity = new PointEntity(1, "1");
        System.out.println(pointEntity);
        System.out.println(pointRepository);
        System.out.println(pointService);
        Mockito.when(pointService.load(pointEntity.getName())).thenReturn(pointEntity);
    }

    @AfterMethod
    public void tearDown() throws Exception {
    }

    @Test
    public void testCreate() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {
    }

    @Test
    public void testLoadAll() throws Exception {
    }

    @Test
    public void testLoad() throws Exception {
        String name = "1";
        PointEntity point = pointService.load("name");
        assertThat(point.getName()
            .equals(name));
    }

    @Test
    public void testUpdate() throws Exception {
    }

}
// @DataJpaTest
// @EnableJpaRepositories (basePackages = {"com.epam.training.transport.model.db.repository"})
//extends AbstractTestNGSpringContextTests