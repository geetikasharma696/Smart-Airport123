package com.smartairport.service;

import com.smartairport.model.Flight;
import java.util.ArrayList;
import java.util.List;

public class FlightService {

    private List<Flight> flights = new ArrayList<>();

    // Add Flight
    public void addFlight(Flight flight) {

        flights.add(flight);

        System.out.println("\nFlight Added Successfully!");
    }

    // Display All Flights
    public void displayAllFlights() {

        System.out.println("\n========== ALL FLIGHTS ==========");

        for (Flight flight : flights) {
            flight.displayFlight();
            System.out.println("--------------------------------");
        }
    }

    // Search Flight
    public void searchFlight(String flightNumber) {

        for (Flight flight : flights) {

            if (flight.getFlightNumber().equals(flightNumber)) {

                System.out.println("\n===== FLIGHT FOUND =====");
                flight.displayFlight();
                return;
            }
        }

        System.out.println("Flight Not Found!");
    }

    // Assign Gate
    public void assignGate(Flight flight, String gateNumber) {

        flight.setGateNumber(gateNumber);

        System.out.println("Gate " + gateNumber +
                " assigned to Flight " +
                flight.getFlightNumber());
    }
}