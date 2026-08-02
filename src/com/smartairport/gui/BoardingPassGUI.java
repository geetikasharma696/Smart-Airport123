package com.smartairport.gui;


import com.smartairport.dao.PassengerDAO;
import com.smartairport.model.Passenger;


import javax.swing.*;
import java.awt.*;


public class BoardingPassGUI extends JFrame {



    JTextField idField;

    JButton generateButton;



    public BoardingPassGUI(){



        setTitle("Generate Boarding Pass");


        setSize(450,350);


        setLayout(null);


        setLocationRelativeTo(null);


        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );





        JLabel title =
                new JLabel(
                        "SMART AIRPORT BOARDING PASS"
                );


        title.setBounds(
                80,
                40,
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






        JLabel label =
                new JLabel(
                        "Enter Passenger ID"
                );


        label.setBounds(
                60,
                110,
                130,
                25
        );


        add(label);







        idField =
                new JTextField();


        idField.setBounds(
                220,
                110,
                120,
                25
        );


        add(idField);







        generateButton =
                new JButton(
                        "GENERATE"
                );


        generateButton.setBounds(
                150,
                180,
                120,
                35
        );


        add(generateButton);








        generateButton.addActionListener(e -> {



            try{


                int id =
                        Integer.parseInt(
                                idField.getText()
                        );



                PassengerDAO dao =
                        new PassengerDAO();



                Passenger p =
                        dao.getPassengerById(id);





                if(p != null){



                    String pass =

                            "==============================\n"
                                    +"       SMART AIRPORT\n"
                                    +"      BOARDING PASS\n"
                                    +"==============================\n\n"
                                    +"Passenger Name : "
                                    +p.getName()
                                    +"\nFlight Number : "
                                    +p.getFlightNumber()
                                    +"\nDestination : "
                                    +p.getDestination()
                                    +"\nSeat Number : "
                                    +p.getSeatNumber()
                                    +"\nPassport No : "
                                    +p.getPassportNumber()
                                    +"\nStatus : CONFIRMED\n"
                                    +"==============================";




                    JOptionPane.showMessageDialog(
                            null,
                            pass
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
                        "Enter Valid Passenger ID"
                );


            }




        });







        setVisible(true);



    }


}