package com.epam.training.transport.service.impl;

import com.epam.training.transport.model.TransportType;
import com.epam.training.transport.model.db.entity.TransportEntity;
import com.epam.training.transport.model.db.repository.TransportRepository;
import com.epam.training.transport.service.TransportService;
import com.epam.training.transport.service.exceptions.ErrorCode;
import com.epam.training.transport.service.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

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
        final TransportEntity transport = new TransportEntity(registrationNumber, transportType, noFunctionally);

        try {
            transportRepository.save(transport);
        } catch (final DataIntegrityViolationException e) {
            throw new ServiceException(ErrorCode.NAME_ALREADY_EXISTS, e);
        }

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
    public List<TransportEntity> loadAll(
        final Optional<TransportType> optTransportType,
               final Optional<Boolean> optNoFunctionally) {

        if (optNoFunctionally.isPresent()) {
            if (optNoFunctionally.get()) {
                return transportRepository.findAll()
                        .stream()
                        .filter(transportEntity -> transportEntity.isNoFunctionally() == true)
                        .sorted()
                        .collect(Collectors.toList());

            }
            return transportRepository.findAll()
                    .stream()
                    .filter(transportEntity -> transportEntity.isNoFunctionally() == false)
                    .sorted()
                    .collect(Collectors.toList());
        }

        if (optTransportType.isPresent()) {
            switch (optTransportType.get()) {
                case BUS: {
                    return transportRepository.findAll()
                            .stream()
                            .filter(transportEntity -> transportEntity.getTransportType()
                                    .equals(TransportType.BUS))
                            .collect(Collectors.toList());
                }
                case TRAM: {
                    return transportRepository.findAll()
                            .stream()
                            .filter(transportEntity -> transportEntity.getTransportType()
                                    .equals(TransportType.TRAM))
                            .collect(Collectors.toList());
                }
                case TROLLEYBUS: {
                    return transportRepository.findAll()
                            .stream()
                            .filter(transportEntity -> transportEntity.getTransportType()
                                    .equals(TransportType.TROLLEYBUS))
                            .collect(Collectors.toList());

                }
            }
        }
                return transportRepository.findAll()
                        .stream()
                        .sorted()
                        .collect(Collectors.toList());
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

        final TransportEntity transport = load(id);
        transport.setRegistrationNumber(registrationNumber);
        transport.setNoFunctionally(noFunctionally);
        transport.setTransportType(transportType);

        try {
            transportRepository.save(transport);
        } catch (final DataIntegrityViolationException e) {
            throw new ServiceException(ErrorCode.NAME_ALREADY_EXISTS, e);
        }
        return transport;
    }
}
