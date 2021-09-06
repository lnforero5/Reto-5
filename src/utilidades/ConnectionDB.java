/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;


import java.sql.*;

/**
 *
 * @author Usuario
 */
public class ConnectionDB {

    public static Connection getConnection() {

        Connection conn = null;
        try {
            String host = "jdbc:mysql://localhost/java";
            String username = "root";
            String password = "";

            conn = DriverManager.getConnection(host, username, password);
            //if (conn != null) {
            //   System.out.println("Conectado!");
            //}

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
