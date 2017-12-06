
package com.epam.training.transport.service;

import com.epam.training.transport.model.db.entity.PointEntity;
import com.epam.training.transport.model.db.entity.RoutePointEntity;

public interface RoutePointService {

RoutePointEntity create (final PointEntity point, final int sequence);
}

