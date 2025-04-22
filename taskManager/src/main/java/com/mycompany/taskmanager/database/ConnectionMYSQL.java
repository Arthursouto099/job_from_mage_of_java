/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanager.database;
import io.github.cdimascio.dotenv.Dotenv;
import java.sql.*;


/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class ConnectionMYSQL {
    static final String DB_URL = Dotenv.load().get("DB_URL");
    static final String DB_USER = Dotenv.load().get("DB_USER");
    static final  String DB_PASSWORD = Dotenv.load().get("DB_PASSWORD");
            
    public static Connection Connection() {
        try {
           return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);  
        }
        catch(SQLException e) {
            return null;
        }
    };
    
    public static void closeConnection(Connection conn){
        if(Connection() != null) {
            try {
                System.out.println("Connection is closed!");
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
