/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanager.model;

/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class userModel {
    private int id_user;
    private String username;
    private String email;
    private String user_password;

    public userModel(String username, String email, String user_password) {
        this.username = username;
        this.email = email;
        this.user_password = user_password;
    }
    
        public userModel( String email, String user_password) {
        this.email = email;
        this.user_password = user_password;
    }


    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }
    
    public String getInfo() {
        return  this.id_user + ":" + this.username + ":" + this.email;
    }
    
    
  
    
    
    
    
}
