package com.smartairport.dao;


import com.smartairport.model.Passenger;
import com.smartairport.utils.DBConnection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;



public class PassengerDAO {



    // ================= ADD PASSENGER =================


    public void addPassenger(Passenger passenger) {



        String checkQuery =
                "SELECT id FROM passengers WHERE id=?";


        String insertQuery =
                "INSERT INTO passengers(id,name,flightNumber,destination,age,email,passportNumber,nationality,baggageWeight,seatNumber) VALUES (?,?,?,?,?,?,?,?,?,?)";



        try {


            Connection con =
                    DBConnection.getConnection();



            PreparedStatement check =
                    con.prepareStatement(checkQuery);



            check.setInt(
                    1,
                    passenger.getId()
            );



            ResultSet rs =
                    check.executeQuery();




            if(rs.next()) {


                System.out.println(
                        "Passenger already exists!"
                );


            }
            else {



                PreparedStatement ps =
                        con.prepareStatement(insertQuery);



                ps.setInt(1, passenger.getId());

                ps.setString(2, passenger.getName());

                ps.setString(3, passenger.getFlightNumber());

                ps.setString(4, passenger.getDestination());

                ps.setInt(5, passenger.getAge());

                ps.setString(6, passenger.getEmail());

                ps.setString(7, passenger.getPassportNumber());

                ps.setString(8, passenger.getNationality());

                ps.setDouble(9, passenger.getBaggageWeight());

                ps.setString(10, passenger.getSeatNumber());



                ps.executeUpdate();



                System.out.println(
                        "Passenger Saved Successfully!"
                );

            }



        }
        catch(Exception e){

            System.out.println(
                    "Add Error : "
                            + e.getMessage()
            );

        }


    }







    // ================= GET PASSENGER LIST FOR GUI =================



    public List<Passenger> getPassengerList(){



        List<Passenger> list =
                new ArrayList<>();



        String query =
                "SELECT * FROM passengers";



        try {



            Connection con =
                    DBConnection.getConnection();



            PreparedStatement ps =
                    con.prepareStatement(query);



            ResultSet rs =
                    ps.executeQuery();



            while(rs.next()){



                Passenger p =
                        new Passenger(

                                rs.getInt("id"),

                                rs.getString("name"),

                                rs.getString("flightNumber"),

                                rs.getString("destination"),

                                rs.getInt("age"),

                                rs.getString("email"),

                                rs.getString("passportNumber"),

                                rs.getString("nationality"),

                                rs.getDouble("baggageWeight")

                        );



                p.setSeatNumber(
                        rs.getString("seatNumber")
                );



                list.add(p);



            }



        }
        catch(Exception e){


            System.out.println(
                    "List Error : "
                            + e.getMessage()
            );


        }



        return list;


    }









    // ================= SEARCH PASSENGER =================



    public Passenger getPassengerById(int id){



        Passenger passenger = null;



        String query =
                "SELECT * FROM passengers WHERE id=?";



        try {



            Connection con =
                    DBConnection.getConnection();



            PreparedStatement ps =
                    con.prepareStatement(query);



            ps.setInt(
                    1,
                    id
            );



            ResultSet rs =
                    ps.executeQuery();




            if(rs.next()){



                passenger =
                        new Passenger(

                                rs.getInt("id"),

                                rs.getString("name"),

                                rs.getString("flightNumber"),

                                rs.getString("destination"),

                                rs.getInt("age"),

                                rs.getString("email"),

                                rs.getString("passportNumber"),

                                rs.getString("nationality"),

                                rs.getDouble("baggageWeight")

                        );



                passenger.setSeatNumber(
                        rs.getString("seatNumber")
                );



            }



        }
        catch(Exception e){


            System.out.println(
                    "Search Error : "
                            + e.getMessage()
            );


        }



        return passenger;


    }









    // ================= DELETE PASSENGER =================



    public void deletePassenger(int id){



        String query =
                "DELETE FROM passengers WHERE id=?";



        try {



            Connection con =
                    DBConnection.getConnection();



            PreparedStatement ps =
                    con.prepareStatement(query);



            ps.setInt(
                    1,
                    id
            );



            int result =
                    ps.executeUpdate();




            if(result>0){


                System.out.println(
                        "Passenger Deleted!"
                );


            }
            else{


                System.out.println(
                        "Passenger Not Found!"
                );


            }



        }
        catch(Exception e){


            System.out.println(
                    "Delete Error : "
                            + e.getMessage()
            );


        }



    }









    // ================= UPDATE PASSENGER =================



    public void updatePassenger(Passenger passenger){



        String query =
                "UPDATE passengers SET name=?, flightNumber=?, destination=?, age=?, email=?, passportNumber=?, nationality=?, baggageWeight=?, seatNumber=? WHERE id=?";



        try {



            Connection con =
                    DBConnection.getConnection();



            PreparedStatement ps =
                    con.prepareStatement(query);




            ps.setString(1, passenger.getName());

            ps.setString(2, passenger.getFlightNumber());

            ps.setString(3, passenger.getDestination());

            ps.setInt(4, passenger.getAge());

            ps.setString(5, passenger.getEmail());

            ps.setString(6, passenger.getPassportNumber());

            ps.setString(7, passenger.getNationality());

            ps.setDouble(8, passenger.getBaggageWeight());

            ps.setString(9, passenger.getSeatNumber());

            ps.setInt(10, passenger.getId());




            int result =
                    ps.executeUpdate();




            if(result>0){


                System.out.println(
                        "Passenger Updated Successfully!"
                );


            }
            else{


                System.out.println(
                        "Passenger Not Found!"
                );


            }



        }
        catch(Exception e){


            System.out.println(
                    "Update Error : "
                            + e.getMessage()
            );


        }



    }


// ================= GET PASSENGER COUNT BY FLIGHT =================

    public int getPassengerCountByFlight(String flightNumber) {


        int count = 0;


        String query =
                "SELECT COUNT(*) FROM passengers WHERE flightNumber=?";


        try {


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



            if(rs.next()) {


                count =
                        rs.getInt(1);


            }


        }
        catch(Exception e) {


            System.out.println(
                    "Passenger Count Error : "
                            + e.getMessage()
            );


        }


        return count;


    }
}