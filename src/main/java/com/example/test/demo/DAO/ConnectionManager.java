package com.example.test.demo.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    /** Database URL */
    private static final String URL = "jdbc:mysql://localhost:3306/test";

    /** Username */
    private static final String USER = "root";

    /** Password */
    private static final String PASSWORD = "kennethkin901";

    /**
     * Make a connection with thhe database
     * @return Database connection
     */

     public static Connection getConnection() throws SQLException{
        Connection con = null;
        try{
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        }catch(SQLException e){
            e.printStackTrace();
            throw e;
        }

        return con;
     }
}
