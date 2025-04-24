/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanager.dao;
import com.mycompany.taskmanager.model.TaskModel;
import com.mycompany.taskmanager.database.ConnectionMYSQL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import  java.util.ArrayList;
import java.sql.*;



/**
 *
 * @author Usuario
 */
public class TaskDAO {
    public static final int SUCCESS_UPDATE_TASK = 0;
    public static final int FAILED_UPDATE_TASK = 1;
    public static final int TASK_NOT_FOUND = 2;
    public static final int TASK_FOUND_SUCCESSFULLY = 3;
    public static final int INTERNAL_ERROR = 5;
    
    
    public static int createTask(TaskModel taskObject) {
        String sql = "INSERT INTO task (title_task, description_task, date, id_board) values(?,?,?,?)";
        
        try(PreparedStatement preparedStatement = ConnectionMYSQL.Connection().prepareStatement(sql) ) {
            preparedStatement.setString(1, taskObject.getTitle_task());
            preparedStatement.setString(2, taskObject.getDescription_task());
            preparedStatement.setString(3, taskObject.getDate());
            preparedStatement.setInt(4, taskObject.getId_board());
            
            preparedStatement.executeUpdate();
            System.out.println("TASK CRIADA COM SUCESSO");
            return SUCCESS_UPDATE_TASK;
            
            
        }catch(SQLException e) {
            System.out.println("ERRO AO CRIAR TASK" + ": " +e.getMessage());
            return FAILED_UPDATE_TASK;
        }
    }
    
    
    public static ArrayList<TaskModel> getTasksByIdBoard(int id_board) {
        String sql = "SELECT id_task, title_task, description_task, date, status FROM task WHERE id_board = ?";
        ArrayList<TaskModel> taskList  = new ArrayList<>();
        
        try(PreparedStatement pstmt = ConnectionMYSQL.Connection().prepareStatement(sql)) {
            pstmt.setInt(1, id_board);
            
            ResultSet rows = pstmt.executeQuery();
            
            while(rows.next()) {
                TaskModel task = new TaskModel(rows.getString("title_task"), rows.getString("description_task"), rows.getString("date"), id_board);
                task.setId_task(rows.getInt("id_task"));
                task.setStatus(rows.getString("status"));
                taskList.add(task);
            }
            
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return taskList;
    }
    
}
