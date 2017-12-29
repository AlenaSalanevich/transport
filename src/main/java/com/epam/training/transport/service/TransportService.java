package com.epam.training.transport.service;

import com.epam.training.transport.model.TransportType;
import com.epam.training.transport.model.db.entity.TransportEntity;

import java.util.List;
import java.util.Optional;

public interface TransportService {

    TransportEntity create(final String registrationNumber, final boolean noFunctionally, final TransportType transportType);

    TransportEntity load(final String registrationNumber);

    TransportEntity load(final long id);

    List<TransportEntity> loadAll(final Optional<TransportType> optTransportType, final Optional<Boolean> optNoFunctionally);

    void delete(final long id);

    TransportEntity update(
        final long id,
       final TransportEntity transport);
}
