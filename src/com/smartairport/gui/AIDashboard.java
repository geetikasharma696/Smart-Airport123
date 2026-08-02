package com.smartairport.gui;


import com.smartairport.ai.FraudDetectionAI;
import com.smartairport.ai.FlightDelayAI;
import com.smartairport.dao.PassengerDAO;
import com.smartairport.dao.FlightDAO;
import com.smartairport.model.Passenger;
import com.smartairport.model.Flight;


import javax.swing.*;
import java.awt.*;



public class AIDashboard extends JFrame {



    JButton fraudButton;
    JButton delayButton;
    JButton exitButton;



    public AIDashboard(){



        setTitle("AI Intelligence Dashboard");


        setSize(500,400);


        setLayout(null);


        setLocationRelativeTo(null);


        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );





        JLabel title =
                new JLabel(
                        "AI AIRPORT INTELLIGENCE SYSTEM"
                );


        title.setBounds(
                100,
                40,
                350,
                30
        );


        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        16
                )
        );


        add(title);







        fraudButton =
                new JButton(
                        "AI Security Fraud Detection"
                );


        fraudButton.setBounds(
                100,
                120,
                300,
                40
        );


        add(fraudButton);







        delayButton =
                new JButton(
                        "Flight Delay Prediction"
                );


        delayButton.setBounds(
                100,
                190,
                300,
                40
        );


        add(delayButton);







        exitButton =
                new JButton(
                        "EXIT"
                );


        exitButton.setBounds(
                190,
                270,
                100,
                35
        );


        add(exitButton);









        // FRAUD AI


        fraudButton.addActionListener(e -> {



            try {



                String id =
                        JOptionPane.showInputDialog(
                                "Enter Passenger ID"
                        );



                PassengerDAO dao =
                        new PassengerDAO();



                Passenger passenger =
                        dao.getPassengerById(
                                Integer.parseInt(id)
                        );



                if(passenger != null){



                    FraudDetectionAI ai =
                            new FraudDetectionAI();



                    JOptionPane.showMessageDialog(
                            null,
                            ai.analyzePassenger(passenger)
                    );


                }

                else{


                    JOptionPane.showMessageDialog(
                            null,
                            "Passenger Not Found"
                    );


                }



            }
            catch(Exception ex){


                JOptionPane.showMessageDialog(
                        null,
                        "Invalid ID"
                );


            }



        });









        // DELAY AI


        delayButton.addActionListener(e -> {



            try {



                String flightNumber =
                        JOptionPane.showInputDialog(
                                "Enter Flight Number"
                        );



                FlightDAO dao =
                        new FlightDAO();



                Flight flight =
                        dao.getFlightByNumber(
                                flightNumber
                        );




                if(flight != null){



                    FlightDelayAI ai =
                            new FlightDelayAI();



                    JOptionPane.showMessageDialog(
                            null,
                            ai.predictDelay(flight)
                    );


                }

                else{


                    JOptionPane.showMessageDialog(
                            null,
                            "Flight Not Found"
                    );


                }



            }
            catch(Exception ex){


                JOptionPane.showMessageDialog(
                        null,
                        "Invalid Flight Number"
                );


            }




        });









        exitButton.addActionListener(e -> {


            dispose();


        });







        setVisible(true);



    }



}