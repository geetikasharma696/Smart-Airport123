package com.smartairport.gui;


import javax.swing.*;
import java.awt.*;
import com.smartairport.gui.AnalyticsDashboard;

public class Dashboard extends JFrame {


    JButton passengerButton;
    JButton passengerListButton;

    JButton flightButton;
    JButton flightListButton;

    JButton aiButton;
    JButton boardingButton;
    JButton logoutButton;
    JButton exitButton;
    JButton analyticsButton;

    public Dashboard() {


        setTitle("Smart Airport Management System");


        setSize(600,600);


        setLayout(null);


        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );


        setLocationRelativeTo(null);





        JLabel title =
                new JLabel(
                        "✈ SMART AIRPORT MANAGEMENT SYSTEM ✈",
                        SwingConstants.CENTER
                );


        title.setBounds(
                50,
                30,
                500,
                35
        );


        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18
                )
        );


        add(title);






        JLabel admin =
                new JLabel(
                        "Welcome Admin"
                );


        admin.setBounds(
                250,
                75,
                200,
                25
        );


        admin.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );


        add(admin);








        passengerButton =
                new JButton(
                        "Add Passenger"
                );


        passengerButton.setBounds(
                80,
                130,
                180,
                40
        );


        add(passengerButton);






        passengerListButton =
                new JButton(
                        "Passenger List"
                );


        passengerListButton.setBounds(
                330,
                130,
                180,
                40
        );


        add(passengerListButton);








        flightButton =
                new JButton(
                        "Add Flight"
                );


        flightButton.setBounds(
                80,
                200,
                180,
                40
        );


        add(flightButton);






        flightListButton =
                new JButton(
                        "Flight List"
                );


        flightListButton.setBounds(
                330,
                200,
                180,
                40
        );


        add(flightListButton);








        aiButton =
                new JButton(
                        "AI Intelligence"
                );


        aiButton.setBounds(
                80,
                270,
                430,
                40
        );


        add(aiButton);









        boardingButton =
                new JButton(
                        "Generate Boarding Pass"
                );


        boardingButton.setBounds(
                80,
                340,
                430,
                40
        );


        add(boardingButton);


        analyticsButton =
                new JButton(
                        "Analytics Dashboard"
                );


        analyticsButton.setBounds(
                80,
                330,
                370,
                40
        );


        add(analyticsButton);





        logoutButton =
                new JButton(
                        "LOGOUT"
                );


        logoutButton.setBounds(
                120,
                430,
                150,
                40
        );


        add(logoutButton);







        exitButton =
                new JButton(
                        "EXIT"
                );


        exitButton.setBounds(
                320,
                430,
                150,
                40
        );


        add(exitButton);









        // ============== BUTTON ACTIONS ==============


        passengerButton.addActionListener(e -> {

            new PassengerForm();

        });




        passengerListButton.addActionListener(e -> {

            new PassengerListFrame();

        });





        flightButton.addActionListener(e -> {

            new FlightForm();

        });





        flightListButton.addActionListener(e -> {

            new FlightListFrame();

        });





        aiButton.addActionListener(e -> {

            new AIDashboard();

        });





        boardingButton.addActionListener(e -> {

            new BoardingPassGUI();

        });

        analyticsButton.addActionListener(e -> {

            new AnalyticsDashboard();

        });





        logoutButton.addActionListener(e -> {


            dispose();


            new LoginFrame();


        });







        exitButton.addActionListener(e -> {


            System.exit(0);


        });







        setVisible(true);


    }


}


