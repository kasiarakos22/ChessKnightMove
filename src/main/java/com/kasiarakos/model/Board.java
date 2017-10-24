package com.kasiarakos.model;

/**
 * Created by kasiarakos on 24/10/2017.
 */
public class Board {

    private int size ;
    private Position[][] positions;

    public Board(int size) {
        this.size = size;
        positions = new Position[size][size];

        for(int i=0; i<positions.length; i++){
            for(int j=0; j<positions.length; j++){
                this.positions[i][j] = new Position(i, j);
            }
        }
    }

    public int getSize(){
        return size;
    }

}