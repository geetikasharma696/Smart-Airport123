package com.smartairport.gui;


import com.smartairport.dao.FlightDAO;
import com.smartairport.model.Flight;


import javax.swing.*;
import java.awt.*;


public class FlightForm extends JFrame {


    JTextField flightNumberField;
    JTextField airlineField;
    JTextField sourceField;
    JTextField destinationField;
    JTextField departureField;
    JTextField arrivalField;


    JButton addButton;
    JButton searchButton;
    JButton updateButton;
    JButton deleteButton;
    JButton clearButton;



    public FlightForm(){


        setTitle("Flight Management");


        setSize(520,600);


        setLayout(null);


        setLocationRelativeTo(null);


        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );



        JLabel title =
                new JLabel("FLIGHT MANAGEMENT SYSTEM");


        title.setBounds(
                130,
                20,
                300,
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




        flightNumberField = new JTextField();
        airlineField = new JTextField();
        sourceField = new JTextField();
        destinationField = new JTextField();
        departureField = new JTextField();
        arrivalField = new JTextField();



        addField("Flight Number",flightNumberField,80);

        addField("Airline",airlineField,120);

        addField("Source",sourceField,160);

        addField("Destination",destinationField,200);

        addField("Departure Time",departureField,240);

        addField("Arrival Time",arrivalField,280);







        addButton =
                new JButton("ADD");


        addButton.setBounds(
                40,
                360,
                90,
                35
        );


        add(addButton);





        searchButton =
                new JButton("SEARCH");


        searchButton.setBounds(
                150,
                360,
                100,
                35
        );


        add(searchButton);






        updateButton =
                new JButton("UPDATE");


        updateButton.setBounds(
                270,
                360,
                100,
                35
        );


        add(updateButton);






        deleteButton =
                new JButton("DELETE");


        deleteButton.setBounds(
                100,
                430,
                100,
                35
        );


        add(deleteButton);






        clearButton =
                new JButton("CLEAR");


        clearButton.setBounds(
                250,
                430,
                100,
                35
        );


        add(clearButton);









        // ADD FLIGHT

        addButton.addActionListener(e -> {


            try{


                Flight flight =
                        createFlight();



                FlightDAO dao =
                        new FlightDAO();



                dao.addFlight(flight);



                JOptionPane.showMessageDialog(
                        null,
                        "Flight Added Successfully!"
                );


            }
            catch(Exception ex){


                JOptionPane.showMessageDialog(
                        null,
                        "Invalid Data!"
                );

            }



        });









        // SEARCH FLIGHT


        searchButton.addActionListener(e -> {



            FlightDAO dao =
                    new FlightDAO();



            Flight flight =
                    dao.searchFlightByNumber(
                            flightNumberField.getText()
                    );




            if(flight != null){



                airlineField.setText(
                        flight.getAirline()
                );


                sourceField.setText(
                        flight.getSource()
                );


                destinationField.setText(
                        flight.getDestination()
                );


                departureField.setText(
                        flight.getDepartureTime()
                );


                arrivalField.setText(
                        flight.getArrivalTime()
                );



                JOptionPane.showMessageDialog(
                        null,
                        "Flight Found!"
                );

            }

            else{


                JOptionPane.showMessageDialog(
                        null,
                        "Flight Not Found!"
                );


            }



        });









        // UPDATE FLIGHT


        updateButton.addActionListener(e -> {



            FlightDAO dao =
                    new FlightDAO();



            dao.updateFlight(
                    createFlight()
            );



            JOptionPane.showMessageDialog(
                    null,
                    "Flight Updated!"
            );


        });









        // DELETE FLIGHT


        deleteButton.addActionListener(e -> {



            FlightDAO dao =
                    new FlightDAO();



            dao.deleteFlight(
                    flightNumberField.getText()
            );



            JOptionPane.showMessageDialog(
                    null,
                    "Flight Deleted!"
            );



        });









        // CLEAR


        clearButton.addActionListener(e -> {


            flightNumberField.setText("");

            airlineField.setText("");

            sourceField.setText("");

            destinationField.setText("");

            departureField.setText("");

            arrivalField.setText("");


        });





        setVisible(true);



    }








    private Flight createFlight(){


        return new Flight(


                flightNumberField.getText(),

                airlineField.getText(),

                sourceField.getText(),

                destinationField.getText(),

                departureField.getText(),

                arrivalField.getText()


        );


    }







    private void addField(
            String text,
            JTextField field,
            int y
    ){


        JLabel label =
                new JLabel(text);


        label.setBounds(
                50,
                y,
                130,
                25
        );


        add(label);



        field.setBounds(
                200,
                y,
                200,
                25
        );


        add(field);


    }



}