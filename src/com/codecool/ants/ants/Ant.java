package com.codecool.ants.ants;

import com.codecool.ants.Colony;

public abstract class Ant {
    protected char elem;
    protected int[][] actualPosition;

    public Ant(int[][] actualPosition, char elem) {
        this.actualPosition = actualPosition;
        this.elem = elem;
    }

    protected void move() {

    }

    public Integer distanceFromQueen(){
        return null;
    }

    public Colony getColony() {
        return null;
    }

    public char getChar() {
        return this.elem;
    }
}
