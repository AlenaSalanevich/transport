package com.epam.training.transport.service;

import com.epam.training.transport.model.TransportType;
import com.epam.training.transport.model.db.entity.TransportEntity;
import com.epam.training.transport.model.db.repository.TransportRepository;
import com.epam.training.transport.service.impl.TransportServiceImpl;
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

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * @author Alena_Salanevich
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TransportServiceTest.TransportServiceConfig.class})
public class TransportServiceTest {

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

    List<TransportEntity> transports = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        bus = new TransportEntity(1l, "1111", TransportType.BUS, true);
        tram = new TransportEntity(2l, "5555", TransportType.TRAM, false);
        trolleybus = new TransportEntity(3l, "8888", TransportType.TROLLEYBUS, true);
        transports.add(bus);
        transports.add(tram);
        transports.add(trolleybus);

        when(transportRepository.findAll()).thenReturn(Arrays.asList(bus, tram, trolleybus));
        when(transportRepository.findOne(eq(3l))).thenReturn(trolleybus);
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

        when(transportRepository.findAllByNoFunctionally(anyBoolean())).thenAnswer((Answer<List<TransportEntity>>) invocation -> {

            List<TransportEntity> optTransports = new ArrayList<>();

            Boolean noFunctionally = (Boolean) invocation.getArguments()[0];
            if (bus.isNoFunctionally() == noFunctionally) {
                optTransports.add(bus);
            }
            if (tram.isNoFunctionally() == noFunctionally) {
                optTransports.add(tram);
            }
            if (trolleybus.isNoFunctionally() == noFunctionally) {
                optTransports.add(trolleybus);
            }
            return optTransports;
        });

        when(transportRepository.findAllByTransportTypeAndNoFunctionally(any(TransportType.class), anyBoolean())).thenAnswer(
            invocation -> {
                List<TransportEntity> optTransports = new ArrayList<>();
                Boolean noFunctionally = (Boolean) invocation.getArguments()[1];
                TransportType type = (TransportType) invocation.getArguments()[0];
                if ((bus.isNoFunctionally() == noFunctionally)
                    && (bus.getTransportType()
                        .equals(type))) {
                    optTransports.add(bus);
                }
                if ((tram.isNoFunctionally() == noFunctionally)
                    && (tram.getTransportType()
                        .equals(type))) {
                    optTransports.add(tram);
                }
                if ((trolleybus.isNoFunctionally() == noFunctionally)
                    && (trolleybus.getTransportType()
                        .equals(type))) {
                    optTransports.add(trolleybus);
                }
                return optTransports;
            });

    }

    @After
    public void tearDown() throws Exception {
        Mockito.reset(transportRepository);
    }

    @Test
    public void create() {
        transportService.create("5555", TransportType.TRAM, false);
        ArgumentCaptor<TransportEntity> captor = ArgumentCaptor.forClass(TransportEntity.class);
        verify(transportRepository, times(1)).save(captor.capture());
        assertEquals(captor.getValue()
            .getRegistrationNumber(), "5555");
        assertEquals(captor.getValue()
            .getTransportType(), TransportType.TRAM);
        assertFalse(captor.getValue()
            .isNoFunctionally());
    }

    @Test
    public void load() {
        TransportEntity transport = transportService.load(3l);
        assertEquals(transport.getRegistrationNumber(), "8888");
        assertTrue(transport.isNoFunctionally());
        assertEquals(transport.getTransportType(), TransportType.TROLLEYBUS);
        verify(transportRepository, times(1)).findOne(3l);
    }

    @Test
    public void loadAll() {
        List<TransportEntity> transportEntities = transportService.loadAll(Optional.empty(), Optional.empty());
        assertEquals(transportEntities.size(), 3l);
        assertEquals(transportEntities, transports);
        verify(transportRepository, times(1)).findAll();

        List<TransportEntity> transportByType = transportService.loadAll(Optional.of(TransportType.BUS), Optional.empty());
        assertEquals(transportByType.size(), 1l);
        assertEquals(transportByType.get(0), bus);
        verify(transportRepository, times(1)).findAllByTransportType(TransportType.BUS);

        List<TransportEntity> transportByNoFunctionally = transportService.loadAll(Optional.empty(), Optional.of(Boolean.TRUE));
        assertEquals(transportByNoFunctionally.size(), 2l);
        assertEquals(transportByNoFunctionally.get(0), bus);
        assertEquals(transportByNoFunctionally.get(1), trolleybus);
        verify(transportRepository, times(1)).findAllByNoFunctionally(true);

        List<TransportEntity> transportByTypeAndNoFunctionally =
            transportService.loadAll(Optional.of(TransportType.BUS), Optional.of(Boolean.TRUE));
        assertEquals(transportByTypeAndNoFunctionally.size(), 1l);
        assertEquals(transportByTypeAndNoFunctionally.get(0), bus);
        verify(transportRepository, times(1)).findAllByTransportTypeAndNoFunctionally(TransportType.BUS, true);

    }

    @Test
    public void delete() {
        transportService.delete(1l);
        verify(transportRepository, times(1)).delete(1l);
    }

    @Test
    public void update() {
        TransportEntity upTransport = transportService.update(1l, new TransportEntity(1l, "3333", TransportType.BUS, false));
        ArgumentCaptor<TransportEntity> captor = ArgumentCaptor.forClass(TransportEntity.class);

        verify(transportRepository, times(1)).save(captor.capture());
        assertEquals(captor.getValue()
            .getTransportType(), TransportType.BUS);
        assertFalse(captor.getValue()
            .isNoFunctionally());
        assertEquals(captor.getValue()
            .getId(), 1l);
        assertEquals(captor.getValue()
            .getRegistrationNumber(), "3333");
    }

    @Test
    public void loadLike() {
    }
}
