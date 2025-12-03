package com.astrobookings.fleet.domain.ports;

import java.util.List;

import com.astrobookings.fleet.domain.model.Rocket;

public interface RocketRepositoryPort {
    List<Rocket> findAll();
    Rocket save(Rocket rocket);
}