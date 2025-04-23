/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanager.model;

/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class BoardModel {
    int id_board;
    String title_board;
    String description_board;
    // chave estrangeira ligada ao usuario da tabela user_cm
    int id_user;

    public BoardModel(String title_board, String description_board, int id_user) {
        this.title_board = title_board;
        this.description_board = description_board;
        this.id_user = id_user;
    }

    public int getId_board() {
        return id_board;
    }

    public void setId_board(int id_board) {
        this.id_board = id_board;
    }

    public String getTitle_board() {
        return title_board;
    }

    public void setTitle_board(String title_board) {
        this.title_board = title_board;
    }

    public String getDescription_board() {
        return description_board;
    }

    public void setDescription_board(String description_board) {
        this.description_board = description_board;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    
    

}
