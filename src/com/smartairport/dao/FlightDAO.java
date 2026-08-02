package com.smartairport.dao;


import com.smartairport.model.Flight;
import com.smartairport.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class FlightDAO {



    // ================= ADD FLIGHT =================

    public void addFlight(Flight flight) {


        String checkQuery =
                "SELECT flightNumber FROM flights WHERE flightNumber=?";


        String insertQuery =
                "INSERT INTO flights(flightId, flightNumber, airline, source, destination, departureTime, arrivalTime, status) VALUES (?,?,?,?,?,?,?,?)";


        try {


            Connection con =
                    DBConnection.getConnection();



            PreparedStatement check =
                    con.prepareStatement(checkQuery);



            check.setString(
                    1,
                    flight.getFlightNumber()
            );



            ResultSet rs =
                    check.executeQuery();



            if(rs.next()) {


                System.out.println(
                        "Flight already exists!"
                );


                return;

            }



            PreparedStatement ps =
                    con.prepareStatement(insertQuery);



            int flightId =
                    (int)(Math.random()*9000)+1000;



            ps.setInt(1, flightId);

            ps.setString(2, flight.getFlightNumber());

            ps.setString(3, flight.getAirline());

            ps.setString(4, flight.getSource());

            ps.setString(5, flight.getDestination());

            ps.setString(6, flight.getDepartureTime());

            ps.setString(7, flight.getArrivalTime());

            ps.setString(8, "ON TIME");



            ps.executeUpdate();



            System.out.println(
                    "Flight Added Successfully!"
            );


        }
        catch(Exception e){


            System.out.println(
                    "Add Flight Error : "
                            + e.getMessage()
            );

        }


    }







    // ================= GET ALL FLIGHTS =================


    public List<Flight> getFlightList(){



        List<Flight> list =
                new ArrayList<>();



        String query =
                "SELECT * FROM flights";



        try{


            Connection con =
                    DBConnection.getConnection();



            PreparedStatement ps =
                    con.prepareStatement(query);



            ResultSet rs =
                    ps.executeQuery();




            while(rs.next()){



                Flight flight =
                        new Flight(

                                rs.getString("flightNumber"),

                                rs.getString("airline"),

                                rs.getString("source"),

                                rs.getString("destination"),

                                rs.getString("departureTime"),

                                rs.getString("arrivalTime")

                        );



                list.add(flight);



            }



        }
        catch(Exception e){


            System.out.println(
                    "Flight List Error : "
                            + e.getMessage()
            );


        }



        return list;


    }








    // ================= SEARCH FLIGHT =================


    public Flight searchFlightByNumber(String flightNumber){



        Flight flight = null;



        String query =
                "SELECT * FROM flights WHERE flightNumber=?";



        try{


            Connection con =
                    DBConnection.getConnection();



            PreparedStatement ps =
                    con.prepareStatement(query);



            ps.setString(
                    1,
                    flightNumber
            );



            ResultSet rs =
                    ps.executeQuery();



            if(rs.next()){



                flight =
                        new Flight(

                                rs.getString("flightNumber"),

                                rs.getString("airline"),

                                rs.getString("source"),

                                rs.getString("destination"),

                                rs.getString("departureTime"),

                                rs.getString("arrivalTime")

                        );



            }



        }
        catch(Exception e){


            System.out.println(
                    "Search Flight Error : "
                            + e.getMessage()
            );


        }



        return flight;


    }








    // ================= UPDATE FLIGHT =================


    public void updateFlight(Flight flight){



        String query =
                "UPDATE flights SET airline=?, source=?, destination=?, departureTime=?, arrivalTime=? WHERE flightNumber=?";



        try{


            Connection con =
                    DBConnection.getConnection();



            PreparedStatement ps =
                    con.prepareStatement(query);



            ps.setString(1, flight.getAirline());

            ps.setString(2, flight.getSource());

            ps.setString(3, flight.getDestination());

            ps.setString(4, flight.getDepartureTime());

            ps.setString(5, flight.getArrivalTime());

            ps.setString(6, flight.getFlightNumber());



            ps.executeUpdate();



            System.out.println(
                    "Flight Updated Successfully!"
            );



        }
        catch(Exception e){


            System.out.println(
                    "Update Flight Error : "
                            + e.getMessage()
            );


        }


    }








    // ================= DELETE FLIGHT =================


    public void deleteFlight(String flightNumber){



        String query =
                "DELETE FROM flights WHERE flightNumber=?";



        try{


            Connection con =
                    DBConnection.getConnection();



            PreparedStatement ps =
                    con.prepareStatement(query);



            ps.setString(
                    1,
                    flightNumber
            );



            ps.executeUpdate();



            System.out.println(
                    "Flight Deleted Successfully!"
            );



        }
        catch(Exception e){


            System.out.println(
                    "Delete Flight Error : "
                            + e.getMessage()
            );


        }


    }






    // ================= GET FLIGHT BY NUMBER (AI) =================


    public Flight getFlightByNumber(String flightNumber){


        return searchFlightByNumber(flightNumber);


    }



}