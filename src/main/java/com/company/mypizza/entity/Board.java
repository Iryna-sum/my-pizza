package com.company.mypizza.entity;

public class Board {
    private int id;
    private String BoardType;

    public Board() {
    }

    public Board(String boardType) {
        BoardType = boardType;
    }

    public Board(int id, String boardType) {
        this.id = id;
        BoardType = boardType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBoardType() {
        return BoardType;
    }

    public void setBoardType(String boardType) {
        BoardType = boardType;
    }
}
