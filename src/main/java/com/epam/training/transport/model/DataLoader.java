package com.epam.training.transport.model;

import com.epam.training.transport.model.db.entity.PointEntity;
import com.epam.training.transport.model.db.entity.RouteEntity;
import com.epam.training.transport.model.db.entity.TransportEntity;
import com.epam.training.transport.model.db.repository.PointRepository;
import com.epam.training.transport.model.db.repository.RouteRepository;
import com.epam.training.transport.model.db.repository.TransportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    @Autowired
    private PointRepository pointRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private TransportRepository transportRepository;

    public DataLoader(
        final PointRepository pointRepository,
        final RouteRepository routeRepository,
        final TransportRepository transportRepository) {
        this.pointRepository = pointRepository;
        this.routeRepository = routeRepository;
        this.transportRepository = transportRepository;
        loadPoints();
       loadRoutes();
        loadTransports();
    }

    private void loadPoints() {
        pointRepository.save(new PointEntity("ABC"));
        pointRepository.save(new PointEntity("BCD"));
        pointRepository.save(new PointEntity("CDE"));
        pointRepository.save(new PointEntity("DEF"));
        pointRepository.save(new PointEntity("EFG"));
        pointRepository.save(new PointEntity("HIK"));
        pointRepository.save(new PointEntity("LMN"));
        pointRepository.save(new PointEntity("OPQ"));
        pointRepository.save(new PointEntity("RST"));
        pointRepository.save(new PointEntity("UVW"));
    }

    private void loadRoutes() {
        routeRepository.save(new RouteEntity("60", "From ABC to CDE"));
        routeRepository.save(new RouteEntity("200", "From BCD to CDE"));
        routeRepository.save(new RouteEntity("600", "From DEF to ABC"));
        routeRepository.save(new RouteEntity("6", "From ABC to EFG"));
        routeRepository.save(new RouteEntity("210", "From BCD to CDE"));
        routeRepository.save(new RouteEntity("1100", "From BCD to CDE"));
        routeRepository.save(new RouteEntity("10", "From BCD to CDE"));
    }

    public void loadTransports() {
        transportRepository.save(new TransportEntity("1212 AB-4", TransportType.BUS, false));
        transportRepository.save(new TransportEntity("1313 CD-4", TransportType.BUS, false));
        transportRepository.save(new TransportEntity("1414 EF-4", TransportType.TRAM, false));
        transportRepository.save(new TransportEntity("1515 GH-4", TransportType.BUS, false));
        transportRepository.save(new TransportEntity("1616 IJ-4", TransportType.TRAM, true));
        transportRepository.save(new TransportEntity("1717 KL-4", TransportType.BUS, true));
        transportRepository.save(new TransportEntity("1817 MN-4", TransportType.TROLLEYBUS, true));
    }
}
