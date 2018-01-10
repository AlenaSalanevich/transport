package com.epam.training.transport.service;

import com.epam.training.transport.model.TransportType;
import com.epam.training.transport.model.db.entity.TransportEntity;

import java.util.List;
import java.util.Optional;

/**
 * @author Alena_Salanevich
 */

public interface TransportService {

    TransportEntity create(final String registrationNumber,  final TransportType transportType, final boolean functionality);

    TransportEntity load(final String registrationNumber);

    TransportEntity load(final long id);

    List<TransportEntity> loadAll(final Optional<TransportType> transportType, final Optional<Boolean> functionality);

    void delete(final long id);

    TransportEntity update(final long id, final TransportEntity transportEntity);
}
