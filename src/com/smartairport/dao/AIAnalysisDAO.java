package com.smartairport.dao;

import com.smartairport.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AIAnalysisDAO {


    // SAVE AI ANALYSIS

    public void saveAnalysis(int analysisId,
                             int passengerId,
                             int riskScore,
                             String riskLevel,
                             String analysisResult) {


        try {


            Connection con = DBConnection.getConnection();


            String query =
                    "INSERT INTO ai_analysis(analysisId, passengerId, riskScore, riskLevel, analysisResult) VALUES(?,?,?,?,?)";


            PreparedStatement ps =
                    con.prepareStatement(query);


            ps.setInt(1, analysisId);

            ps.setInt(2, passengerId);

            ps.setInt(3, riskScore);

            ps.setString(4, riskLevel);

            ps.setString(5, analysisResult);


            ps.executeUpdate();


            System.out.println("AI Analysis Saved Successfully!");


        }
        catch(Exception e) {


            System.out.println("AI Analysis Error : " + e.getMessage());


        }

    }



    // DISPLAY AI ANALYSIS

    public void getAllAnalysis() {


        try {


            Connection con =
                    DBConnection.getConnection();


            String query =
                    "SELECT * FROM ai_analysis";


            PreparedStatement ps =
                    con.prepareStatement(query);


            ResultSet rs =
                    ps.executeQuery();



            while(rs.next()) {


                System.out.println("\n===== AI ANALYSIS =====");


                System.out.println ("Analysis ID : " + rs.getInt("analysisId"));


                System.out.println("Passenger ID : " + rs.getInt("passengerId"));


                System.out.println("Risk Score : " + rs.getInt("riskScore"));


                System.out.println("Risk Level : " + rs.getString("riskLevel")
                );


                System.out.println("Result : " + rs.getString("analysisResult")
                );


            }


        }
        catch(Exception e) {


            System.out.println("Display Error : " + e.getMessage());


        }


    }

}