package com.epam.training.transport.service.impl;

import com.epam.training.transport.model.TransportType;
import com.epam.training.transport.model.db.entity.TransportEntity;
import com.epam.training.transport.model.db.repository.TransportRepository;
import com.epam.training.transport.service.TransportService;
import com.epam.training.transport.service.exceptions.ErrorCode;
import com.epam.training.transport.service.exceptions.ServiceException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.unitils.reflectionassert.util.HibernateUtil;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

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

        return optTransportType.map(transportType -> optNoFunctionally.map(noFunctionally -> transportRepository
            .findAllByTransportTypeAndNoFunctionally(transportType, noFunctionally))
            .orElseGet(() -> transportRepository.findAllByTransportType(transportType)))
            .orElseGet(() -> optNoFunctionally.map(noFunctionally -> transportRepository.findAllByNoFunctionally(noFunctionally))
                .orElseGet(() -> transportRepository.findAll()));
    }

    @Override
    public void delete(final long id) {
        transportRepository.delete(id);
    }

    @Override
    public TransportEntity update(final long id, final TransportEntity upTransport) {

        /*
         * final TransportEntity transport = load(id);
         * 
         * transport.setRegistrationNumber(upTransport.getRegistrationNumber());
         * transport.setNoFunctionally(upTransport.isNoFunctionally());
         * transport.setTransportType(upTransport.getTransportType());
         */
        try {
            transportRepository.save(upTransport);
        } catch (final DataIntegrityViolationException e) {
            throw new ServiceException(ErrorCode.NAME_ALREADY_EXISTS, e);
        }
        return upTransport;
    }

    @Override
    public List<TransportEntity> loadLike(final String registrationNumber) {
        return transportRepository.findAllByRegistrationNumberContains(registrationNumber);
    }
}
