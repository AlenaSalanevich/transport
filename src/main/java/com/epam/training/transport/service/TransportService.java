package com.epam.training.transport.service;

import com.epam.training.transport.model.TransportType;
import com.epam.training.transport.model.db.entity.TransportEntity;

import java.util.List;

public interface TransportService {

    TransportEntity create(final String LP, final boolean noFunctionally, final TransportType transportType);

    TransportEntity load(final String LP);

    TransportEntity load(final long id);

    List<TransportEntity> loadAll();

    void delete(final long id);

    void delete (String LP);

    TransportEntity update(final String LP, final String newLP);
}
