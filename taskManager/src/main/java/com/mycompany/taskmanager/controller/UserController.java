/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanager.controller;
import com.mycompany.taskmanager.dao.UserDAO;
import com.mycompany.taskmanager.model.userModel;


/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class UserController {
    
    
    public static String[] login(String email, char[] user_password) {
        int isLogin = UserDAO.login(new userModel(email, new  String(user_password)));
        String response = "";
        String userLogged = "not";
         
        switch(isLogin) {
            case UserDAO.USER_FOUND_SUCCESSFULLY:
                userLogged = UserDAO.getUserByEmailAndPassword(email).getInfo();
                response = "successfully logged in";
                break;
            case UserDAO.USER_NOT_FOUND:
                response = "user not found, please try again";
                break;
        }
        
        return new String[]{response, userLogged};
        
    }
    
    public static String[] createUSer(String username, String email, char [] user_password) {
        int isCreated = UserDAO.createUser(new userModel(username, email, new String(user_password)));
        String response = "";
        String userCreated = "not";
        
                 
         switch(isCreated) {
             case UserDAO.SUCCESS_UPDATE_USER:
                 userCreated = UserDAO.getUserByEmailAndPassword(email).getInfo();
                 response = "user created successfuly";
                 break;
             case UserDAO.FAILED_UPDATE_USER:
                 response = "OPERATION FAILED";
                 break;
         }
         
         return  new String[]{response, userCreated};
    }
}
