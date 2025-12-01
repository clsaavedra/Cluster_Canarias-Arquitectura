package com.astrobookings.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.astrobookings.persistence.models.Booking;

public class BookingRepository {
  private static final Map<String, Booking> bookings = new HashMap<>();
  private static int nextId = 1;

  static {
    var flightId = "10000000-0000-0000-0000-000000000001";
    // Pre-load bookings on the scheduled flight
    var booking1Id = "20000000-0000-0000-0000-000000000001";
    Booking booking1 = new Booking(booking1Id, flightId, "John Doe", 1000.0, "TXN-123456");
    bookings.put(booking1Id, booking1);

    var booking2Id = "20000000-0000-0000-0000-000000000002";
    Booking booking2 = new Booking(booking2Id, flightId, "Jane Smith", 1000.0, "TXN-123457");
    bookings.put(booking2Id, booking2);

  }

  public List<Booking> findAll() {
    return new ArrayList<>(bookings.values());
  }

  public List<Booking> findByFlightId(String flightId) {
    return bookings.values().stream()
        .filter(booking -> booking.getFlightId().equals(flightId))
        .collect(Collectors.toList());
  }

  public List<Booking> findByPassengerName(String passengerName) {
    return bookings.values().stream()
        .filter(booking -> booking.getPassengerName().equalsIgnoreCase(passengerName))
        .collect(Collectors.toList());
  }

  public Booking save(Booking booking) {
    if (booking.getId() == null) {
      booking.setId("b" + nextId++);
    }
    bookings.put(booking.getId(), booking);
    return booking;
  }
}