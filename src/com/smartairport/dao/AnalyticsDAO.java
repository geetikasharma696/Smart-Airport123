
package com.smartairport.dao;


import com.smartairport.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class AnalyticsDAO {



    public int getTotalPassengers(){


        int count = 0;


        try{


            Connection con =
                    DBConnection.getConnection();


            PreparedStatement ps =
                    con.prepareStatement(
                            "SELECT COUNT(*) FROM passengers"
                    );


            ResultSet rs =
                    ps.executeQuery();



            if(rs.next()){


                count =
                        rs.getInt(1);


            }



        }
        catch(Exception e){


            System.out.println(
                    "Passenger Count Error : "
                            +e.getMessage()
            );


        }


        return count;


    }






    public int getTotalFlights(){



        int count = 0;



        try{


            Connection con =
                    DBConnection.getConnection();



            PreparedStatement ps =
                    con.prepareStatement(
                            "SELECT COUNT(*) FROM flights"
                    );



            ResultSet rs =
                    ps.executeQuery();



            if(rs.next()){


                count =
                        rs.getInt(1);


            }


        }
        catch(Exception e){


            System.out.println(
                    "Flight Count Error : "
                            +e.getMessage()
            );


        }



        return count;


    }




}