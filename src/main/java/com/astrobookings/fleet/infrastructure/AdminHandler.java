package com.astrobookings.fleet.infrastructure;

import java.io.IOException;

import com.astrobookings.fleet.FleetFactory;
import com.astrobookings.fleet.domain.CancellationService;
import com.astrobookings.sales.SalesFactory;
import com.astrobookings.share.BaseHandler;
import com.sun.net.httpserver.HttpExchange;

public class AdminHandler extends BaseHandler {
  private final CancellationService cancellationService;

  public AdminHandler() {
    this.cancellationService = new CancellationService(FleetFactory.getFlightInstance(), SalesFactory.getBookingInstance());
  }

  @Override
  public void handle(HttpExchange exchange) throws IOException {
    String method = exchange.getRequestMethod();

    if ("POST".equals(method)) {
      handlePost(exchange);
    } else {
      this.handleMethodNotAllowed(exchange);
    }
  }

  private void handlePost(HttpExchange exchange) throws IOException {
    String response = "";
    int statusCode = 200;

    try {
      response = cancellationService.cancelFlights();
    } catch (Exception e) {
      statusCode = 500;
      response = "{\"error\": \"Internal server error\"}";
    }

    sendResponse(exchange, statusCode, response);
  }
}