package com.smartairport.gui;


import com.smartairport.dao.AnalyticsDAO;


import javax.swing.*;
import java.awt.*;



public class AnalyticsDashboard extends JFrame {



    JLabel passengerLabel;

    JLabel flightLabel;



    public AnalyticsDashboard(){



        setTitle("Airport Analytics Dashboard");


        setSize(500,350);


        setLayout(null);


        setLocationRelativeTo(null);



        JLabel title =
                new JLabel(
                        "SMART AIRPORT ANALYTICS"
                );


        title.setBounds(
                120,
                40,
                300,
                30
        );


        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18
                )
        );


        add(title);






        AnalyticsDAO dao =
                new AnalyticsDAO();




        passengerLabel =
                new JLabel(
                        "Total Passengers : "
                                +dao.getTotalPassengers()
                );



        passengerLabel.setBounds(
                100,
                120,
                300,
                30
        );



        add(passengerLabel);






        flightLabel =
                new JLabel(
                        "Total Flights : "
                                +dao.getTotalFlights()
                );



        flightLabel.setBounds(
                100,
                170,
                300,
                30
        );


        add(flightLabel);






        setVisible(true);



    }



}