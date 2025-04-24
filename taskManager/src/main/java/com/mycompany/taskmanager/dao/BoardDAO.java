/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanager.dao;
import java.sql.*;
import com.mycompany.taskmanager.model.BoardModel;
import com.mycompany.taskmanager.database.ConnectionMYSQL;
import java.util.ArrayList;
/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class BoardDAO {
    public static final int SUCCESS_UPDATE_BOARD = 0;
    public static final int FAILED_UPDATE_BOARD = 1;
    public static final int BOARD_NOT_BOARD = 2;
    public static final int BOARD_FOUND_SUCCESSFULLY = 3;
    public static final int INTERNAL_ERROR = 5;
    
    
    public static int createBoard(BoardModel boardObject) {
        String sql = "INSERT INTO board (title_board, description_board, id_user) values(?,?,?)";
        
        try(PreparedStatement preparedStatement = ConnectionMYSQL.Connection().prepareStatement(sql) ) {
            preparedStatement.setString(1, boardObject.getTitle_board());
            preparedStatement.setString(2, boardObject.getDescription_board());
            preparedStatement.setInt(3, boardObject.getId_user());
            
            preparedStatement.executeUpdate();
            System.out.println("BOARD CRIADO COM SUCESSO");
            return SUCCESS_UPDATE_BOARD;
            
            
        }catch(SQLException e) {
            System.out.println("ERRO AO CRIAR BOARD" + ": " +e.getMessage());
            return FAILED_UPDATE_BOARD;
        }
    }
//    
   public static ArrayList<BoardModel> getAllBoardsByIdUser(int id_user) {
       String sql = "SELECT id_board, title_board ,description_board FROM board where id_user = ?";
       ArrayList<BoardModel> listModel = new ArrayList<>(); 
      
       
       
       try(PreparedStatement preparedSt = ConnectionMYSQL.Connection().prepareStatement(sql)) {
           preparedSt.setInt(1, id_user);
           
           ResultSet rows = preparedSt.executeQuery();
           
           while (rows.next()) {               
               BoardModel boardObject = new BoardModel(rows.getString("title_board"), rows.getString("description_board"), id_user);
               boardObject.setId_board(rows.getInt("id_board"));
               listModel.add(boardObject);
           }
           
           
           
       } catch (Exception e) {
           System.out.println(e.getMessage());
           return  listModel;
       }
       
       return listModel;
       
   }
    
   
   public static int updateBoard(BoardModel boardObject) {
       String sql = "update board set title_board = ?, description_board =? where id_board = ?";
       
       
       try(PreparedStatement pstmt = ConnectionMYSQL.Connection().prepareStatement(sql)) {
           pstmt.setString(1, boardObject.getTitle_board());
           pstmt.setString(2, boardObject.getDescription_board());
           pstmt.setInt(3, boardObject.getId_board());
           
           int rows = pstmt.executeUpdate();
           System.out.println(rows);
           
           if(rows > 0) {
               return SUCCESS_UPDATE_BOARD;
           }
           
           return FAILED_UPDATE_BOARD;
           
           
       } catch (Exception e) {
           System.out.println(e.getMessage());
           return FAILED_UPDATE_BOARD;
       }
   }
   
   
      
  
    
}
