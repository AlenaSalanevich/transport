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
import java.util.Optional;

/**
 * @author Alena_Salanevich
 */

@Transactional
@Service("transportService")
public class TransportServiceImpl implements TransportService {

    @Autowired
    TransportRepository transportRepository;

    @Override
    public TransportEntity create(
            final String registrationNumber,

            final TransportType transportType, final boolean functionality) {

        final TransportEntity transport = new TransportEntity(registrationNumber, transportType, functionality);

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
            final Optional<Boolean> optFunctionality) {

        return optTransportType.map(transportType -> optFunctionality.map(functionality -> transportRepository
                .findAllByTransportTypeAndFunctionality(transportType, functionality))
                .orElseGet(() -> transportRepository.findAllByTransportType(transportType)))
                .orElseGet(() -> optFunctionality.map(functionality -> transportRepository.findAllByFunctionality(functionality))
                        .orElseGet(() -> transportRepository.findAll()));
    }

    @Override
    public void delete(final long id) {
        transportRepository.delete(id);
    }

    @Override
    public TransportEntity update(final long id, final TransportEntity transportEntity) {

        /*
         * final TransportEntity transport = load(id);
         *
         * transport.setRegistrationNumber(upTransport.getRegistrationNumber());
         * transport.setFunctionality(upTransport.isFunctionality());
         * transport.setTransportType(upTransport.getTransportType());
         */
        try {
            transportRepository.save(transportEntity);
        } catch (final DataIntegrityViolationException e) {
            throw new ServiceException(ErrorCode.NAME_ALREADY_EXISTS, e);
        }
        return transportEntity;
    }
}
