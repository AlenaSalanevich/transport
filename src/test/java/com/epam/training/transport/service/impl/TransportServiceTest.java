package com.epam.training.transport.service.impl;

import com.epam.training.transport.model.TransportType;
import com.epam.training.transport.model.db.entity.TransportEntity;
import com.epam.training.transport.model.db.repository.TransportRepository;
import com.epam.training.transport.service.TransportService;
import com.epam.training.transport.service.exceptions.ServiceException;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * @author Alena_Salanevich
 */

@ContextConfiguration(classes = { TransportServiceTest.TransportServiceConfig.class})
public class TransportServiceTest extends AbstractTestNGSpringContextTests {

    @Configuration
    static class TransportServiceConfig {

        @Bean
        public TransportService transportService() {
            return new TransportServiceImpl();
        }

        @Bean
        public TransportRepository transportRepository() {
            return mock(TransportRepository.class);
        }
    }

    @Autowired
    TransportRepository transportRepository;

    @Autowired
    TransportService transportService;

    TransportEntity bus, tram, trolleybus;

    List<TransportEntity> transports;

    @BeforeMethod
    public void setUp() throws Exception {
        transports = new ArrayList<>();
        bus = new TransportEntity(1l, "1111", TransportType.BUS, true);
        tram = new TransportEntity(2l, "5555", TransportType.TRAM, false);
        trolleybus = new TransportEntity(3l, "8888", TransportType.TROLLEYBUS, true);
        transports.add(bus);
        transports.add(tram);
        transports.add(trolleybus);

        when(transportRepository.findAll()).thenReturn(Arrays.asList(bus, tram, trolleybus));
        when(transportRepository.findOne(eq(3l))).thenReturn(trolleybus);
        when(transportRepository.findAllByTransportType(TransportType.BUS)).thenReturn(Arrays.asList(bus));
        when(transportRepository.findAllByTransportType(Mockito.any(TransportType.class))).thenAnswer(
            (Answer<List<TransportEntity>>) invocation -> {

                List<TransportEntity> optTransports = new ArrayList<>();

                TransportType type = (TransportType) invocation.getArguments()[0];
                if (bus.getTransportType()
                    .equals(type)) {
                    optTransports.add(bus);
                }
                if (tram.getTransportType()
                    .equals(type)) {
                    optTransports.add(tram);
                }
                if (trolleybus.getTransportType()
                    .equals(type)) {
                    optTransports.add(trolleybus);
                }
                return optTransports;
            });

        when(transportRepository.findAllByFunctionality(anyBoolean())).thenAnswer((Answer<List<TransportEntity>>) invocation -> {

            List<TransportEntity> optTransports = new ArrayList<>();

            Boolean noFunctionally = (Boolean) invocation.getArguments()[0];
            if (bus.isFunctionality() == noFunctionally) {
                optTransports.add(bus);
            }
            if (tram.isFunctionality() == noFunctionally) {
                optTransports.add(tram);
            }
            if (trolleybus.isFunctionality() == noFunctionally) {
                optTransports.add(trolleybus);
            }
            return optTransports;
        });

        when(transportRepository.findAllByTransportTypeAndFunctionality(any(TransportType.class), anyBoolean())).thenAnswer(
            invocation -> {
                List<TransportEntity> optTransports = new ArrayList<>();
                Boolean noFunctionally = (Boolean) invocation.getArguments()[1];
                TransportType type = (TransportType) invocation.getArguments()[0];
                if ((bus.isFunctionality() == noFunctionally)
                    && (bus.getTransportType()
                        .equals(type))) {
                    optTransports.add(bus);
                }
                if ((tram.isFunctionality() == noFunctionally)
                    && (tram.getTransportType()
                        .equals(type))) {
                    optTransports.add(tram);
                }
                if ((trolleybus.isFunctionality() == noFunctionally)
                    && (trolleybus.getTransportType()
                        .equals(type))) {
                    optTransports.add(trolleybus);
                }
                return optTransports;
            });
when(transportRepository.findByRegistrationNumber(anyString())).thenReturn(bus);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        Mockito.reset(transportRepository);
    }

    @Test
    public void create() {
        transportService.create("5555", TransportType.TRAM, false);
        ArgumentCaptor<TransportEntity> captor = ArgumentCaptor.forClass(TransportEntity.class);
        verify(transportRepository, times(1)).save(captor.capture());
        assertEquals("5555", captor.getValue()
            .getRegistrationNumber());
        assertEquals(TransportType.TRAM, captor.getValue()
            .getTransportType());
        assertFalse(captor.getValue()
            .isFunctionality());
    }

    @Test(expectedExceptions = ServiceException.class)
    public void createThrowException() {
        when(transportRepository.save(any(TransportEntity.class))).thenThrow(DataIntegrityViolationException.class);
        transportService.create("5555", TransportType.TRAM, false);
    }

    @Test
    public void load() {
        TransportEntity transport = transportService.load(3l);
        assertEquals("8888", transport.getRegistrationNumber());
        assertTrue(transport.isFunctionality());
        assertEquals(TransportType.TROLLEYBUS, transport.getTransportType());
        verify(transportRepository, times(1)).findOne(anyLong());
    }

    @Test
    public void loadAll() {
        List<TransportEntity> transportEntities = transportService.loadAll(Optional.empty(), Optional.empty());
        assertEquals(3l, transportEntities.size());
        assertEquals(transports, transportEntities);
        verify(transportRepository, times(1)).findAll();
    }

    @Test
    public void loadAllByTransportType() {
        List<TransportEntity> transportByType = transportService.loadAll(Optional.of(TransportType.BUS), Optional.empty());
        assertEquals(1l, transportByType.size());
        assertEquals(bus, transportByType.get(0));
        verify(transportRepository, times(1)).findAllByTransportType(TransportType.BUS);
    }

    @Test
    public void loadAllByFunctionality() {
        List<TransportEntity> transportByNoFunctionally = transportService.loadAll(Optional.empty(), Optional.of(Boolean.TRUE));
        assertEquals(2l, transportByNoFunctionally.size());
        assertEquals(bus, transportByNoFunctionally.get(0));
        assertEquals(trolleybus, transportByNoFunctionally.get(1));
        verify(transportRepository, times(1)).findAllByFunctionality(true);
    }

    @Test
    public void loadAllByTransportTypeAndFunctionality() {
        List<TransportEntity> transportByTypeAndNoFunctionally =
            transportService.loadAll(Optional.of(TransportType.BUS), Optional.of(Boolean.TRUE));
        assertEquals(1l, transportByTypeAndNoFunctionally.size());
        assertEquals(bus, transportByTypeAndNoFunctionally.get(0));
        verify(transportRepository, times(1)).findAllByTransportTypeAndFunctionality(TransportType.BUS, true);
    }

    @Test
    public void delete() {
        transportService.delete(1l);
        verify(transportRepository, times(1)).delete(anyLong());
    }

    @Test(expectedExceptions = ServiceException.class)
    public void deleteThrowException() {
        doAnswer(invocation -> {
            throw new EmptyResultDataAccessException(1);
        }).when(transportRepository)
            .delete(anyLong());
        transportService.delete(1l);
    }

    @Test
    public void update() {
        TransportEntity upTransport = transportService.update(1l, new TransportEntity(1l, "3333", TransportType.BUS, false));
        ArgumentCaptor<TransportEntity> captor = ArgumentCaptor.forClass(TransportEntity.class);

        verify(transportRepository, times(1)).save(captor.capture());
        assertEquals(TransportType.BUS, captor.getValue()
            .getTransportType());
        assertFalse(captor.getValue()
            .isFunctionality());
        assertEquals(1l, captor.getValue()
            .getId());
        assertEquals("3333", captor.getValue()
            .getRegistrationNumber());
    }

    @Test(expectedExceptions = ServiceException.class)
    public void updateThrowException() {
        when(transportRepository.save(any(TransportEntity.class))).thenThrow(DataIntegrityViolationException.class);
        transportService.update(1l, new TransportEntity(1l, "3333", TransportType.BUS, false));
    }

    @Test
    public void loadLike() {
        TransportEntity transport = transportService.load("1111");
        assertEquals("1111", transport.getRegistrationNumber());
        assertTrue(transport.isFunctionality());
        assertEquals(TransportType.BUS, transport.getTransportType());
        verify(transportRepository, times(1)).findByRegistrationNumber(anyString());}
}
