package com.smartairport.model;

public class Flight {

    private String flightNumber;
    private String airline;
    private String source;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private String gateNumber;


    public Flight(String flightNumber,
                  String airline,
                  String source,
                  String destination,
                  String departureTime,
                  String arrivalTime) {

        this.flightNumber = flightNumber;
        this.airline = airline;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;

    }


    // ================= GETTERS =================


    public String getFlightNumber() {
        return flightNumber;
    }


    public String getAirline() {
        return airline;
    }


    public String getSource() {
        return source;
    }


    public String getDestination() {
        return destination;
    }


    public String getDepartureTime() {
        return departureTime;
    }


    public String getArrivalTime() {
        return arrivalTime;
    }


    public String getGateNumber() {
        return gateNumber;
    }



    // ================= SETTER =================


    public void setGateNumber(String gateNumber) {

        this.gateNumber = gateNumber;

    }



    // ================= DISPLAY =================


    public void displayFlight() {


        System.out.println("\n===== FLIGHT DETAILS =====");


        System.out.println("Flight Number : " + flightNumber);

        System.out.println("Airline : " + airline);

        System.out.println("Source : " + source);

        System.out.println("Destination : " + destination);

        System.out.println("Departure Time : " + departureTime);

        System.out.println("Arrival Time : " + arrivalTime);

        System.out.println("Gate Number : " + gateNumber);


    }

}