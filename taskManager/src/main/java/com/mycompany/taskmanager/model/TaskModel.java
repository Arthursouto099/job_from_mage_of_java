/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanager.model;

/**
 *
 * @author Usuario
 */
public class TaskModel {
    int id_task;
    String title_task;
    String description_task;
    String date;
    String status;
    int id_board;

    public TaskModel(String title_task, String description_task, String date, int id_board) {
        this.title_task = title_task;
        this.description_task = description_task;
        this.date = date;
        this.id_board = id_board;
    }

    public int getId_task() {
        return id_task;
    }

    public void setId_task(int id_task) {
        this.id_task = id_task;
    }

    public String getTitle_task() {
        return title_task;
    }

    public void setTitle_task(String title_task) {
        this.title_task = title_task;
    }

    public String getDescription_task() {
        return description_task;
    }

    public void setDescription_task(String description_task) {
        this.description_task = description_task;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId_board() {
        return id_board;
    }

    public void setId_board(int id_board) {
        this.id_board = id_board;
    }
    
    
    
    
}
