package com.smartairport.gui;


import com.smartairport.dao.AdminDAO;

import javax.swing.*;
import java.awt.*;


public class LoginFrame extends JFrame {


    JTextField usernameField;
    JPasswordField passwordField;

    JButton loginButton;



    public LoginFrame() {


        setTitle("Smart Airport Admin Login");


        setSize(450,350);


        setLayout(null);


        setLocationRelativeTo(null);


        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );




        JLabel title =
                new JLabel(
                        "SMART AIRPORT LOGIN"
                );


        title.setBounds(
                120,
                40,
                250,
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





        JLabel userLabel =
                new JLabel("Username");


        userLabel.setBounds(
                60,
                100,
                100,
                25
        );


        add(userLabel);




        usernameField =
                new JTextField();


        usernameField.setBounds(
                180,
                100,
                170,
                25
        );


        add(usernameField);






        JLabel passLabel =
                new JLabel("Password");


        passLabel.setBounds(
                60,
                150,
                100,
                25
        );


        add(passLabel);





        passwordField =
                new JPasswordField();


        passwordField.setBounds(
                180,
                150,
                170,
                25
        );


        add(passwordField);







        loginButton =
                new JButton(
                        "LOGIN"
                );


        loginButton.setBounds(
                150,
                220,
                120,
                35
        );


        add(loginButton);








        loginButton.addActionListener(e -> {


            String username =
                    usernameField.getText();



            String password =
                    String.valueOf(
                            passwordField.getPassword()
                    );



            AdminDAO dao =
                    new AdminDAO();




            boolean result =
                    dao.login(
                            username,
                            password
                    );





            if(result) {


                JOptionPane.showMessageDialog(
                        null,
                        "Login Successful!"
                );


                new Dashboard();


                dispose();


            }

            else {


                JOptionPane.showMessageDialog(
                        null,
                        "Invalid Username or Password!"
                );


            }


        });





        setVisible(true);


    }



}