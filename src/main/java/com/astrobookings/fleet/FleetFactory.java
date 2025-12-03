package com.astrobookings.fleet;

import com.astrobookings.fleet.domain.ports.FlightRepositoryPort;
import com.astrobookings.fleet.domain.ports.RocketRepositoryPort;
import com.astrobookings.fleet.infrastructure.FlightAdapterRepositoryInMemory;
import com.astrobookings.fleet.infrastructure.RocketAdapterRepositoryInMemory;

public class FleetFactory {
    private static FlightRepositoryPort flightRepositoryInstance = new FlightAdapterRepositoryInMemory();
    private static RocketRepositoryPort rocketRepositoryInstance = new RocketAdapterRepositoryInMemory();

    public static FlightRepositoryPort getFlightInstance() {
        return flightRepositoryInstance;
    }

    public static RocketRepositoryPort getRocketInstance() {
        return rocketRepositoryInstance;
    }
}
