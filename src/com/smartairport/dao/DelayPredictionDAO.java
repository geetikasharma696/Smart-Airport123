package com.smartairport.dao;


import com.smartairport.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DelayPredictionDAO {


    // Save Delay Prediction

    public void saveDelayPrediction(int delayId,
                                    String flightNumber,
                                    String weather,
                                    int passengerCount,
                                    int delayScore,
                                    String prediction) {


        try {


            Connection con =
                    DBConnection.getConnection();



            String query =
                    "INSERT INTO flight_delay_prediction VALUES(?,?,?,?,?,?)";



            PreparedStatement ps =
                    con.prepareStatement(query);



            ps.setInt(1, delayId);

            ps.setString(2, flightNumber);

            ps.setString(3, weather);

            ps.setInt(4, passengerCount);

            ps.setInt(5, delayScore);

            ps.setString(6, prediction);



            ps.executeUpdate();



            System.out.println(
                    "Delay Prediction Saved Successfully!"
            );



        }
        catch(Exception e) {


            System.out.println(
                    "Delay Save Error : "
                            + e.getMessage()
            );


        }


    }




    // Display Delay Prediction


    public void getAllDelayPrediction() {


        try {


            Connection con =
                    DBConnection.getConnection();



            String query =
                    "SELECT * FROM flight_delay_prediction";



            PreparedStatement ps =
                    con.prepareStatement(query);



            ResultSet rs =
                    ps.executeQuery();




            while(rs.next()) {


                System.out.println(
                        "\n===== FLIGHT DELAY DATABASE ====="
                );



                System.out.println(
                        "Delay ID : "
                                + rs.getInt("delayId")
                );


                System.out.println(
                        "Flight Number : "
                                + rs.getString("flightNumber")
                );


                System.out.println(
                        "Weather : "
                                + rs.getString("weather")
                );


                System.out.println(
                        "Passenger Count : "
                                + rs.getInt("passengerCount")
                );


                System.out.println(
                        "Delay Score : "
                                + rs.getInt("delayScore")
                );


                System.out.println(
                        "Prediction : "
                                + rs.getString("prediction")
                );


                System.out.println(
                        "----------------------------"
                );


            }


        }
        catch(Exception e) {


            System.out.println(
                    "Display Delay Error : "
                            + e.getMessage()
            );


        }


    }


}