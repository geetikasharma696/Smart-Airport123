
    package com.smartairport.dao;

import com.smartairport.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


    public class FraudDetectionDAO {


        // Save Fraud Data

        public void saveFraud(int fraudId,
                              int passengerId,
                              int fraudScore,
                              String fraudStatus,
                              String reason) {


            try {


                Connection con =
                        DBConnection.getConnection();


                String query =
                        "INSERT INTO fraud_detection VALUES(?,?,?,?,?)";


                PreparedStatement ps =
                        con.prepareStatement(query);


                ps.setInt(1, fraudId);

                ps.setInt(2, passengerId);

                ps.setInt(3, fraudScore);

                ps.setString(4, fraudStatus);

                ps.setString(5, reason);


                ps.executeUpdate();


                System.out.println(
                        "Fraud Data Saved Successfully!"
                );


            }
            catch(Exception e) {


                System.out.println(
                        "Fraud Save Error : "
                                + e.getMessage()
                );


            }


        }




        // Display Fraud Data

        public void getAllFraud() {


            try {


                Connection con =
                        DBConnection.getConnection();


                String query =
                        "SELECT * FROM fraud_detection";


                PreparedStatement ps =
                        con.prepareStatement(query);


                ResultSet rs =
                        ps.executeQuery();



                while(rs.next()) {


                    System.out.println(
                            "\n===== FRAUD DATABASE ====="
                    );


                    System.out.println(
                            "Fraud ID : "
                                    + rs.getInt("fraudId")
                    );


                    System.out.println(
                            "Passenger ID : "
                                    + rs.getInt("passengerId")
                    );


                    System.out.println(
                            "Fraud Score : "
                                    + rs.getInt("fraudScore")
                    );


                    System.out.println(
                            "Status : "
                                    + rs.getString("fraudStatus")
                    );


                    System.out.println(
                            "Reason : "
                                    + rs.getString("reason")
                    );


                    System.out.println(
                            "----------------------------"
                    );


                }


            }
            catch(Exception e) {


                System.out.println(
                        "Display Fraud Error : "
                                + e.getMessage()
                );


            }


        }


    }

