package com.smartairport.gui;


import com.smartairport.dao.PassengerDAO;
import com.smartairport.model.Passenger;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;



public class PassengerListFrame extends JFrame {



    JTable table;

    DefaultTableModel model;

    JButton refreshButton;




    public PassengerListFrame() {



        setTitle("Passenger Details");


        setSize(1000,500);


        setLocationRelativeTo(null);


        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );



        setLayout(
                new BorderLayout()
        );





        JLabel title =
                new JLabel(
                        "PASSENGER MANAGEMENT LIST",
                        SwingConstants.CENTER
                );


        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18
                )
        );


        add(
                title,
                BorderLayout.NORTH
        );







        String[] columns = {


                "ID",

                "Name",

                "Flight Number",

                "Destination",

                "Age",

                "Email",

                "Passport",

                "Nationality",

                "Baggage",

                "Seat"


        };





        model =
                new DefaultTableModel(
                        columns,
                        0
                );




        table =
                new JTable(model);



        table.setRowHeight(25);



        JScrollPane scrollPane =
                new JScrollPane(table);



        add(
                scrollPane,
                BorderLayout.CENTER
        );







        refreshButton =
                new JButton(
                        "REFRESH"
                );



        add(
                refreshButton,
                BorderLayout.SOUTH
        );






        refreshButton.addActionListener(e -> {


            loadPassengers();


        });






        loadPassengers();




        setVisible(true);



    }









    private void loadPassengers() {



        model.setRowCount(0);



        PassengerDAO dao =
                new PassengerDAO();




        List<Passenger> passengers =
                dao.getPassengerList();






        for(Passenger p : passengers) {



            model.addRow(

                    new Object[]{


                            p.getId(),

                            p.getName(),

                            p.getFlightNumber(),

                            p.getDestination(),

                            p.getAge(),

                            p.getEmail(),

                            p.getPassportNumber(),

                            p.getNationality(),

                            p.getBaggageWeight(),

                            p.getSeatNumber()


                    }

            );



        }



    }



}