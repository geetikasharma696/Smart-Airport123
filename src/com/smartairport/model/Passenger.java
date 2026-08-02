package com.smartairport.model;

public class Passenger {

    private int id;
    private String name;
    private String flightNumber;
    private String destination;
    private int age;
    private String email;
    private String passportNumber;
    private String nationality;
    private double baggageWeight;
    private String seatNumber;

    public Passenger(int id, String name, String flightNumber,
                     String destination, int age, String email,
                     String passportNumber, String nationality,
                     double baggageWeight) {

        this.id = id;
        this.name = name;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.age = age;
        this.email = email;
        this.passportNumber = passportNumber;
        this.nationality = nationality;
        this.baggageWeight = baggageWeight;
    }

    // ================= Getters =================

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public double getBaggageWeight() {
        return baggageWeight;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    // ================= Setters =================

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    // ================= Display Method =================

    public void displayPassenger() {

        System.out.println("Passenger ID      : " + id);
        System.out.println("Name              : " + name);
        System.out.println("Flight Number     : " + flightNumber);
        System.out.println("Destination       : " + destination);
        System.out.println("Age               : " + age);
        System.out.println("Email             : " + email);
        System.out.println("Passport Number   : " + passportNumber);
        System.out.println("Nationality       : " + nationality);
        System.out.println("Baggage Weight    : " + baggageWeight + " kg");

        if (seatNumber != null) {
            System.out.println("Seat Number       : " + seatNumber);
        }
    }
}