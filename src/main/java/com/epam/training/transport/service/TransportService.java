package com.epam.training.transport.service;

import com.epam.training.transport.model.TransportType;
import com.epam.training.transport.model.db.entity.TransportEntity;

import java.util.List;

public interface TransportService {

    TransportEntity create(final String registrationNumber, final boolean noFunctionally, final TransportType transportType);

    TransportEntity load(final String registrationNumber);

    TransportEntity load(final long id);

    List<TransportEntity> loadAll();

    void delete(final long id);

    TransportEntity update(final long id, final String registrationNumber, final boolean noFunctionally, final TransportType transportType);
}
