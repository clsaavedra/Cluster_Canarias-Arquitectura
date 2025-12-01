package com.astrobookings.persistence;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.astrobookings.persistence.models.Flight;
import com.astrobookings.persistence.models.FlightStatus;

public class FlightRepository {
  private static final Map<String, Flight> flights = new HashMap<>();
  private static int nextId = 1;

  public List<Flight> findAll() {
    LocalDateTime now = LocalDateTime.now();
    return flights.values().stream()
        .filter(flight -> flight.getDepartureDate().isAfter(now))
        .collect(Collectors.toList());
  }

  public List<Flight> findByStatus(String status) {
    try {
      FlightStatus flightStatus = FlightStatus.valueOf(status.toUpperCase());
      LocalDateTime now = LocalDateTime.now();
      return flights.values().stream()
          .filter(flight -> flight.getDepartureDate().isAfter(now) && flight.getStatus() == flightStatus)
          .collect(Collectors.toList());
    } catch (IllegalArgumentException e) {
      return new ArrayList<>();
    }
  }

  public Flight save(Flight flight) {
    if (flight.getId() == null) {
      flight.setId("f" + nextId++);
    }
    flights.put(flight.getId(), flight);
    return flight;
  }
}