/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanager.controller;

import com.mycompany.taskmanager.dao.TaskDAO;
import com.mycompany.taskmanager.model.TaskModel;
import com.mycompany.taskmanager.model.userModel;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class TaskController {

    public static String createBoard(String task_title, String task_description, String date, String id_board) {
        int isCreated = TaskDAO.createTask(new TaskModel(task_title, task_description, date, Integer.parseInt(id_board)));
        String response = "";
        switch (isCreated) {
            case TaskDAO.SUCCESS_UPDATE_TASK:
                response = "Task created successfuly";
                break;
            case TaskDAO.FAILED_UPDATE_TASK:
                response = "OPERATION FAILED";
                break;
        }

        return response;
    }
    
    public static ArrayList<TaskModel> getAallTasksByIdBoard(String id_board) {
        
        return TaskDAO.getTasksByIdBoard(Integer.parseInt(id_board));
        
        
    }
}
