/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author nadiaislam
 */
public class Database {
     public static Connection getConnection() throws ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://127.0.0.1/finance";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, "root", "");

    }

    public static Statement getStatement(Connection connection) throws SQLException {
        return connection.createStatement();
    }
    
}
