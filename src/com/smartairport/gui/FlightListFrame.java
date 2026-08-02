package com.smartairport.gui;


import com.smartairport.dao.FlightDAO;
import com.smartairport.model.Flight;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;



public class FlightListFrame extends JFrame {



    JTable table;

    DefaultTableModel model;

    JButton refreshButton;




    public FlightListFrame() {



        setTitle("Flight Details");


        setSize(900,500);


        setLocationRelativeTo(null);


        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );



        setLayout(
                new BorderLayout()
        );





        JLabel title =
                new JLabel(
                        "FLIGHT MANAGEMENT LIST",
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


                "Flight Number",

                "Airline",

                "Source",

                "Destination",

                "Departure Time",

                "Arrival Time"


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


            loadFlights();


        });






        loadFlights();




        setVisible(true);


    }








    private void loadFlights() {



        model.setRowCount(0);



        FlightDAO dao =
                new FlightDAO();




        List<Flight> flights =
                dao.getFlightList();






        for(Flight f : flights) {



            model.addRow(

                    new Object[]{


                            f.getFlightNumber(),


                            f.getAirline(),


                            f.getSource(),


                            f.getDestination(),


                            f.getDepartureTime(),


                            f.getArrivalTime()


                    }

            );



        }



    }




}