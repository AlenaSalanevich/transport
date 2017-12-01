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
@Service ("transportService")
public class TransportServiceImpl implements TransportService {

    @Autowired
    TransportRepository transportRepository;

    @Override
    public TransportEntity create(final String LP, final boolean noFunctionally, final TransportType transportType) {
        TransportEntity transport = new TransportEntity();
        transport.setLP(LP);
        transport.setNoFunctionally(noFunctionally);
        transport.setTransportType(transportType);
        transportRepository.save(transport);
        return transport;
    }

    @Override
    public TransportEntity load(final String LP) {
        return transportRepository.findByLP(LP);
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
    public void delete(final String LP) {
        transportRepository.deleteByLP(LP);
    }

    @Override
    public TransportEntity update(final String LP, final String newLP) {
        TransportEntity transport = transportRepository.findByLP(LP);
        transport.setLP(newLP);
        transportRepository.save(transport);
        return transport;
    }
}
