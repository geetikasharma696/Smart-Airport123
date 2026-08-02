package com.smartairport.dao;


import com.smartairport.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class AdminDAO {


    public boolean login(String username, String password) {


        boolean status = false;


        String query =
                "SELECT * FROM admin WHERE username=? AND password=?";



        try {


            Connection con =
                    DBConnection.getConnection();



            PreparedStatement ps =
                    con.prepareStatement(query);



            ps.setString(1, username);

            ps.setString(2, password);



            ResultSet rs =
                    ps.executeQuery();




            if(rs.next()) {


                status = true;


            }



        }

        catch(Exception e) {


            System.out.println(
                    "Login Error : "
                            + e.getMessage()
            );


        }



        return status;


    }


}