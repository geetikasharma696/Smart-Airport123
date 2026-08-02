package com.smartairport.service;

import com.smartairport.model.Passenger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class AirportService {

    private List<Passenger> passengers = new ArrayList<>();

    // Check-In Passenger
    public void checkInPassenger(Passenger passenger) {

        passengers.add(passenger);

        System.out.println("\nPassenger Checked In Successfully!");
        passenger.displayPassenger();
    }

    // Display All Passengers
    public void displayAllPassengers() {

        System.out.println("\n========== ALL PASSENGERS ==========");

        for (Passenger passenger : passengers) {
            passenger.displayPassenger();
            System.out.println("------------------------------------");
        }
    }

    // Search Passenger
    public void searchPassengerById(int id) {

        for (Passenger passenger : passengers) {

            if (passenger.getId() == id) {

                System.out.println("\nPassenger Found!");
                passenger.displayPassenger();
                return;
            }
        }

        System.out.println("Passenger Not Found!");
    }

    // Delete Passenger
    public void deletePassengerById(int id) {

        Iterator<Passenger> iterator = passengers.iterator();

        while (iterator.hasNext()) {

            Passenger passenger = iterator.next();

            if (passenger.getId() == id) {

                iterator.remove();
                System.out.println("Passenger Deleted Successfully!");
                return;
            }
        }

        System.out.println("Passenger Not Found!");
    }

    // Manual Seat Assignment
    public void assignSeat(Passenger passenger, String seatNumber) {

        passenger.setSeatNumber(seatNumber);

        System.out.println("Seat " + seatNumber + " assigned to " + passenger.getName());
    }

    // Automatic Seat Assignment
    public void autoAssignSeat(Passenger passenger) {

        Random random = new Random();

        int row = random.nextInt(30) + 1;

        char seatLetter = (char) ('A' + random.nextInt(6));

        String seatNumber = row + "" + seatLetter;

        passenger.setSeatNumber(seatNumber);

        System.out.println("Auto Assigned Seat : "
                + seatNumber
                + " for "
                + passenger.getName());
    }
}