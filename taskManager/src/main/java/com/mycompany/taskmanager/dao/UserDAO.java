/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanager.dao;

import java.sql.*;
import com.mycompany.taskmanager.model.userModel;
import com.mycompany.taskmanager.database.*;
import org.mindrot.jbcrypt.*;

/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class UserDAO {
    public static final int SUCCESS_UPDATE_USER = 0;
    public static final int FAILED_UPDATE_USER = 1;
    public static final int USER_NOT_FOUND = 2;
    public static final int USER_FOUND_SUCCESSFULLY = 3;
    public static final int PASSWORD_INCORRECT = 4;
    public static final int INTERNAL_ERROR = 5;

    public static int createUser(userModel userObject) {
        String sql = "INSERT INTO user_cm(username, email, user_password) values(?,?,?) ";
        
        try(PreparedStatement preparedStatement = ConnectionMYSQL.Connection().prepareStatement(sql) ){
            preparedStatement.setString(1, userObject.getUsername() );
            preparedStatement.setString(2, userObject.getEmail());
            
            //FAZENDO UM HASH COM A SENHA DO USUARIO
            String hashPassword = BCrypt.hashpw(userObject.getUser_password(), BCrypt.gensalt());
            
            preparedStatement.setString(3, hashPassword);
            preparedStatement.executeUpdate();
            
            System.out.println("USER CREATED SUCCESSFULLY");
            return SUCCESS_UPDATE_USER;
        }
        catch(SQLException e) {
            System.out.println("USER OPERATION FAILED" + ": " + e.getMessage());
            return FAILED_UPDATE_USER;
        }
    }
    
    
   public static int login(userModel userObject) {
    String sql = "SELECT email, user_password FROM user_cm WHERE email = ?";
    
       try(PreparedStatement preparedStatemnt = ConnectionMYSQL.Connection().prepareStatement(sql)) {
           preparedStatemnt.setString(1, userObject.getEmail());
           
           ResultSet row =  preparedStatemnt.executeQuery();
           
           if(row.next()) {
              String hashPassword = row.getString("user_password");
              // Verificando se a senha é conpativel com o hash
              boolean isLogged = BCrypt.checkpw(userObject.getUser_password(), hashPassword);
              if(isLogged) {
                  System.out.println("USUARIO LOGADO COM SUCESSO");
                  return USER_FOUND_SUCCESSFULLY;
              }
              System.out.println("USUARIO NÂO ENCONTRADO");
              return PASSWORD_INCORRECT;
           }
           
           return USER_NOT_FOUND;
           
           
       } catch (Exception e) {
           System.out.println("OPERATION FAILED: " + e.getMessage());
           return INTERNAL_ERROR;
       }
       
}
   
   public static userModel getUserByEmailAndPassword(String email) {
       String sql = "SELECT * FROM user_cm where email = ?";
       
       try(PreparedStatement preparedStatement = ConnectionMYSQL.Connection().prepareStatement(sql)) {
           preparedStatement.setString(1, email);
           
           
           ResultSet row = preparedStatement.executeQuery();
           
           if(row.next()) {
               userModel userFinded = new userModel(
               row.getString("username"),
               row.getString("email"),
               row.getString("user_password")
               );
               
               userFinded.setId_user(row.getInt("id_user"));
               return userFinded; 
           }
           
           return  null;
           
       } catch (Exception e) {
           return  null;
       }
   }
    
   

}
