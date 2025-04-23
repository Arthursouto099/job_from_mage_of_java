/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanager.controller;

import com.mycompany.taskmanager.dao.*;
import com.mycompany.taskmanager.model.*;
import java.util.ArrayList;

/**
 *
 * @author ARTHURSANTOSTAVARESS
 */
public class BoardController {

    public static String createBoard(String board_title, String board_description, int id_user) {
        int isCreated = BoardDAO.createBoard(new BoardModel(board_title, board_description, id_user));
        String response = "";
        switch (isCreated) {
            case BoardDAO.SUCCESS_UPDATE_BOARD:
                response = "Board created successfuly";
                break;
            case BoardDAO.FAILED_UPDATE_BOARD:
                response = "OPERATION FAILED";
                break;
        }

        return response;
    }

    public static ArrayList<BoardModel> getAllBoardById(int id_user) {

        ArrayList<BoardModel> t = BoardDAO.getAllBoardsByIdUser(id_user);
        System.out.println("AAAA");
        for (BoardModel b : t) {
            System.out.println(b.getTitle_board());
        }
        return t;
    }

    public static String updateBoard(String board_title, String board_description, int id_user, int id_board) {
        BoardModel b = new BoardModel(board_title, board_description, id_user);
        b.setId_board(id_board);
        int isUpdated = BoardDAO.updateBoard(b);
        
        String response = "";
        switch (isUpdated) {
            case BoardDAO.SUCCESS_UPDATE_BOARD:
                response = "Board updated successfuly";
                break;
            case BoardDAO.FAILED_UPDATE_BOARD:
                response = "OPERATION FAILED";
                break;
        }

        return response;
    }
}
