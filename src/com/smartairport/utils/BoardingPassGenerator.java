package com.smartairport.utils;

import com.smartairport.model.Passenger;
import com.smartairport.model.Flight;

public class BoardingPassGenerator {


    public String generateBoardingPass(Passenger passenger, Flight flight) {


        String pass =

                "================================\n" +
                        "     SMART AIRPORT BOARDING PASS\n" +
                        "================================\n\n" +

                        "Passenger Name : "
                        + passenger.getName() + "\n" +

                        "Passenger ID   : "
                        + passenger.getId() + "\n" +

                        "Flight Number  : "
                        + flight.getFlightNumber() + "\n" +

                        "Destination    : "
                        + flight.getDestination() + "\n" +

                        "Seat Number    : "
                        + passenger.getSeatNumber() + "\n" +

                        "Boarding Time  : "
                        + flight.getDepartureTime() + "\n\n" +

                        "Have a Safe Journey ✈️";


        System.out.println(pass);


        return pass;

    }

}