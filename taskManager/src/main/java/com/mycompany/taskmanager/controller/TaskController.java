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

    public static String createTask(String task_title, String task_description, String date, String id_board) {
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
    
    public static String editTask(String id_task, String task_title, String task_description, String date, String id_board ) {
        TaskModel m = new TaskModel(task_title, task_description, date, Integer.parseInt(id_board));
        m.setId_task(Integer.parseInt(id_task));
        int isUpdated = TaskDAO.editTask(m);
        String response = "";
        switch (isUpdated) {
            case TaskDAO.SUCCESS_UPDATE_TASK:
                response = "Task update successfuly";
                break;
            case TaskDAO.FAILED_UPDATE_TASK:
                response = "OPERATION FAILED";
                break;
        }

        return response;
        
    }
    
    
    public static  String completeTask(String id_task) {
        int response = TaskDAO.completeTask(Integer.parseInt(id_task.trim()));
        String responseForUser = "";
        switch (response) {
            case TaskDAO.SUCCESS_UPDATE_TASK:
                responseForUser = "Task concluded successfuly";
                break;
            case TaskDAO.FAILED_UPDATE_TASK:
                responseForUser = "OPERATION FAILED";
                break;
        }
        
        return responseForUser;
        
        
    }
    
    
    public static  String deleteTask(String id_task) {
         int response = TaskDAO.deleteTask(Integer.parseInt(id_task.trim()));
        String responseForUser = "";
        switch (response) {
            case TaskDAO.SUCCESS_UPDATE_TASK:
                responseForUser = "Task deleted successfuly";
                break;
            case TaskDAO.FAILED_UPDATE_TASK:
                responseForUser = "OPERATION FAILED";
                break;
        }
        
        return responseForUser;
    }
    
    
    public static ArrayList<TaskModel> getByStatus(String status, String id_board) {
        ArrayList<TaskModel> list = getAallTasksByIdBoard(id_board.trim());
        ArrayList<TaskModel> newList = new ArrayList<>();
        
        if (status.trim().equals("all")) {
            return getAallTasksByIdBoard(id_board.trim());
        }
        
        
        for (TaskModel taskModel : list) {
            if(taskModel.getStatus().equals(status)) {
                newList.add(taskModel);
            } 
        }
        
        return  newList;
        
    }
}
