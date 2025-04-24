/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanager.database;

import com.mycompany.taskmanager.database.ConnectionMYSQL;
import java.sql.*;

/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class CreateTables {

    public static void createUSER_CM() {

        String sql = "CREATE TABLE user_cm( id_user INT PRIMARY KEY AUTO_INCREMENT,"
                + " username VARCHAR(40) NOT NULL,"
                + " email VARCHAR(100) NOT NULL, "
                + "user_password VARCHAR(100) NOT NULL )";

        try (Statement statement = ConnectionMYSQL.Connection().createStatement()) {
            System.out.println("TABELA CRIADA COM SUCESSO");
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

    public static void createBOARD() {
        String sql = "CREATE TABLE board ("
                + "id_board INT PRIMARY KEY AUTO_INCREMENT,"
                + "title_board VARCHAR(100) NOT NULL, "
                + "description_board VARCHAR(100)NOT NULL, "
                + "id_user INT,"
                + " FOREIGN KEY (id_user) REFERENCES user_cm(id_user)"
                + ") ";

        try (Statement statement = ConnectionMYSQL.Connection().createStatement()) {
            System.out.println("TABELA CRIADA COM SUCESSO");
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    
    
    public static void createTask() {
        String sql = "CREATE TABLE task ("
                + "id_task INT PRIMARY KEY AUTO_INCREMENT,"
                + "title_task VARCHAR(100) NOT NULL,"
                + "description_task VARCHAR(100) NOT NULL,"
                + "date VARCHAR(11) NOT NULL,"
                + " status ENUM('pending', 'concluded') DEFAULT 'pending',"
                + "id_board INT,"
                + "FOREIGN KEY (id_board) references board(id_board)"
                + ")";
        
         try (Statement statement = ConnectionMYSQL.Connection().createStatement()) {
            System.out.println("TABELA CRIADA COM SUCESSO");
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
