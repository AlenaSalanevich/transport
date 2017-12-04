package com.epam.training.transport.service.impl;

import com.epam.training.transport.model.TransportType;
import com.epam.training.transport.model.db.entity.TransportEntity;
import com.epam.training.transport.model.db.repository.TransportRepository;
import com.epam.training.transport.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service("transportService")
public class TransportServiceImpl implements TransportService {

    @Autowired
    TransportRepository transportRepository;

    @Override
    public TransportEntity create(
        final String registrationNumber,
        final boolean noFunctionally,
        final TransportType transportType) {
        TransportEntity transport = new TransportEntity();
        transport.setRegistrationNumber(registrationNumber);
        transport.setNoFunctionally(noFunctionally);
        transport.setTransportType(transportType);
        transportRepository.save(transport);
        return transport;
    }

    @Override
    public TransportEntity load(final String registrationNumber) {
        return transportRepository.findByRegistrationNumber(registrationNumber);
    }

    @Override
    public TransportEntity load(final long id) {
        return transportRepository.findOne(id);
    }

    @Override
    public List<TransportEntity> loadAll() {
        return transportRepository.findAll();
    }

    @Override
    public void delete(final long id) {
        transportRepository.delete(id);
    }

    @Override
    public TransportEntity update(
        final long id,
        final String registrationNumber,
        final boolean noFunctionally,
        final TransportType transportType) {
        TransportEntity transport = transportRepository.findOne(id);
        if (!registrationNumber.isEmpty() || registrationNumber.equals("")) {
            if (!transport.getRegistrationNumber()
                .equals(registrationNumber)) {
                transport.setRegistrationNumber(registrationNumber);
            }
        }
        if (!transport.isNoFunctionally() == noFunctionally) {
            transport.setNoFunctionally(noFunctionally);
        }
        if (!transport.getTransportType()
            .equals(transportType)) {
            transport.setTransportType(transportType);
        }
        transportRepository.save(transport);
        return transport;
    }
}
