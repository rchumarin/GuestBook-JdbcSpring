package ru.icl.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBase {
   private static final String URL = "jdbc:postgresql://localhost:5432/rafael.chumarin";
    private static final String USERNAME = "rafael.chumarin";
    private static final String PASSWORD = "p@ssw0rd";

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
            return connection;
        }
    } 
}
