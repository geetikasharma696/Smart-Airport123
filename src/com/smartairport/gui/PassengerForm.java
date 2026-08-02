package com.smartairport.gui;


import com.smartairport.dao.PassengerDAO;
import com.smartairport.model.Passenger;


import javax.swing.*;
import java.awt.*;



public class PassengerForm extends JFrame {



    JTextField idField;
    JTextField nameField;
    JTextField flightField;
    JTextField destinationField;
    JTextField ageField;
    JTextField emailField;
    JTextField passportField;
    JTextField nationalityField;
    JTextField baggageField;



    JButton addButton;
    JButton clearButton;
    JButton searchButton;
    JButton deleteButton;
    JButton updateButton;





    public PassengerForm() {



        setTitle("Passenger Management");


        setSize(520,720);


        setLayout(null);


        setLocationRelativeTo(null);


        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );





        JLabel title =
                new JLabel(
                        "PASSENGER MANAGEMENT SYSTEM"
                );


        title.setBounds(
                120,
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





        idField = new JTextField();
        nameField = new JTextField();
        flightField = new JTextField();
        destinationField = new JTextField();
        ageField = new JTextField();
        emailField = new JTextField();
        passportField = new JTextField();
        nationalityField = new JTextField();
        baggageField = new JTextField();





        addField("Passenger ID",idField,70);

        addField("Name",nameField,110);

        addField("Flight Number",flightField,150);

        addField("Destination",destinationField,190);

        addField("Age",ageField,230);

        addField("Email",emailField,270);

        addField("Passport Number",passportField,310);

        addField("Nationality",nationalityField,350);

        addField("Baggage Weight",baggageField,390);







        addButton =
                new JButton("ADD");


        addButton.setBounds(
                50,
                460,
                100,
                35
        );


        add(addButton);






        clearButton =
                new JButton("CLEAR");


        clearButton.setBounds(
                170,
                460,
                100,
                35
        );


        add(clearButton);






        searchButton =
                new JButton("SEARCH");


        searchButton.setBounds(
                290,
                460,
                100,
                35
        );


        add(searchButton);






        deleteButton =
                new JButton("DELETE");


        deleteButton.setBounds(
                100,
                520,
                120,
                35
        );


        add(deleteButton);







        updateButton =
                new JButton("UPDATE");


        updateButton.setBounds(
                260,
                520,
                120,
                35
        );


        add(updateButton);









        // ADD PASSENGER


        addButton.addActionListener(e -> {


            try {



                Passenger passenger =
                        createPassenger();



                PassengerDAO dao =
                        new PassengerDAO();



                dao.addPassenger(passenger);




                JOptionPane.showMessageDialog(
                        null,
                        "Passenger Added Successfully!"
                );



            }
            catch(Exception ex){


                JOptionPane.showMessageDialog(
                        null,
                        "Invalid Data!"
                );


            }


        });








        // SEARCH PASSENGER


        searchButton.addActionListener(e -> {



            try {



                int id =
                        Integer.parseInt(
                                idField.getText()
                        );



                PassengerDAO dao =
                        new PassengerDAO();



                Passenger passenger =
                        dao.getPassengerById(id);




                if(passenger != null){



                    nameField.setText(
                            passenger.getName()
                    );


                    flightField.setText(
                            passenger.getFlightNumber()
                    );


                    destinationField.setText(
                            passenger.getDestination()
                    );


                    ageField.setText(
                            String.valueOf(
                                    passenger.getAge()
                            )
                    );


                    emailField.setText(
                            passenger.getEmail()
                    );


                    passportField.setText(
                            passenger.getPassportNumber()
                    );


                    nationalityField.setText(
                            passenger.getNationality()
                    );


                    baggageField.setText(
                            String.valueOf(
                                    passenger.getBaggageWeight()
                            )
                    );



                    JOptionPane.showMessageDialog(
                            null,
                            "Passenger Found!"
                    );


                }
                else{


                    JOptionPane.showMessageDialog(
                            null,
                            "Passenger Not Found!"
                    );


                }



            }
            catch(Exception ex){


                JOptionPane.showMessageDialog(
                        null,
                        "Enter Valid ID"
                );


            }


        });










        // DELETE PASSENGER


        deleteButton.addActionListener(e -> {



            try {



                int id =
                        Integer.parseInt(
                                idField.getText()
                        );



                PassengerDAO dao =
                        new PassengerDAO();



                dao.deletePassenger(id);




                JOptionPane.showMessageDialog(
                        null,
                        "Passenger Deleted!"
                );



            }
            catch(Exception ex){


                JOptionPane.showMessageDialog(
                        null,
                        "Enter Valid ID"
                );


            }


        });









        // UPDATE PASSENGER


        updateButton.addActionListener(e -> {



            try {



                Passenger passenger =
                        createPassenger();



                PassengerDAO dao =
                        new PassengerDAO();



                dao.updatePassenger(passenger);




                JOptionPane.showMessageDialog(
                        null,
                        "Passenger Updated Successfully!"
                );



            }
            catch(Exception ex){


                JOptionPane.showMessageDialog(
                        null,
                        "Invalid Data!"
                );


            }


        });









        // CLEAR


        clearButton.addActionListener(e -> {


            idField.setText("");

            nameField.setText("");

            flightField.setText("");

            destinationField.setText("");

            ageField.setText("");

            emailField.setText("");

            passportField.setText("");

            nationalityField.setText("");

            baggageField.setText("");


        });






        setVisible(true);



    }








    private Passenger createPassenger(){



        return new Passenger(


                Integer.parseInt(
                        idField.getText()
                ),


                nameField.getText(),

                flightField.getText(),

                destinationField.getText(),


                Integer.parseInt(
                        ageField.getText()
                ),


                emailField.getText(),


                passportField.getText(),


                nationalityField.getText(),


                Double.parseDouble(
                        baggageField.getText()
                )


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
                140,
                25
        );


        add(label);



        field.setBounds(
                210,
                y,
                180,
                25
        );


        add(field);



    }



}
