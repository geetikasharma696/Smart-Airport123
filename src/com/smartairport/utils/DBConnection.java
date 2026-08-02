package com.smartairport.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3305/SmartAirport";

    private static final String USER = "YOUR_DATABASE_USERNAME";

    private static final String PASSWORD = "YOUR_DATABASE_PASSWORD";


    public static Connection getConnection() {

        Connection connection = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");


            connection = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );


            System.out.println("Database Connected Successfully!");

        }
        catch (Exception e) {

            System.out.println("Database Connection Failed!");
            System.out.println(e.getMessage());

        }

        return connection;
    }
}
