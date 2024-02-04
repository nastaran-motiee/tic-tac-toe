package com.example.tictactoe;


public enum Player {
    X(1), O(2);
    private final int value;
    Player(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
