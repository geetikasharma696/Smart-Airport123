package com.smartairport.dao;

import com.smartairport.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class CheckinDAO {


    // ADD CHECK-IN DATA

    public void addCheckin(int checkinId,
                           int passengerId,
                           String flightNumber,
                           String checkinTime,
                           String baggageStatus) {


        String query =
                "INSERT INTO checkin(checkinId, passengerId, flightNumber, checkinTime, baggageStatus) VALUES(?,?,?,?,?)";


        try {


            Connection con = DBConnection.getConnection();


            PreparedStatement ps =
                    con.prepareStatement(query);


            ps.setInt(1, checkinId);

            ps.setInt(2, passengerId);

            ps.setString(3, flightNumber);

            ps.setString(4, checkinTime);

            ps.setString(5, baggageStatus);


            ps.executeUpdate();


            System.out.println("Check-In Saved Successfully!");


        }
        catch(Exception e) {


            System.out.println("Check-In Error : " + e.getMessage());


        }

    }



    // DISPLAY ALL CHECK-IN


    public void getAllCheckins() {


        String query =
                "SELECT * FROM checkin";


        try {


            Connection con =
                    DBConnection.getConnection();


            PreparedStatement ps =
                    con.prepareStatement(query);


            ResultSet rs =
                    ps.executeQuery();



            while(rs.next()) {


                System.out.println("\n===== CHECK-IN DETAILS =====");


                System.out.println(
                        "Check-In ID : "
                                + rs.getInt("checkinId")
                );


                System.out.println(
                        "Passenger ID : "
                                + rs.getInt("passengerId")
                );


                System.out.println(
                        "Flight Number : "
                                + rs.getString("flightNumber")
                );


                System.out.println(
                        "Check-In Time : "
                                + rs.getString("checkinTime")
                );


                System.out.println(
                        "Baggage Status : "
                                + rs.getString("baggageStatus")
                );


                System.out.println("----------------------------");


            }


        }
        catch(Exception e) {


            System.out.println(
                    "Display Error : "
                            + e.getMessage()
            );


        }


    }

}