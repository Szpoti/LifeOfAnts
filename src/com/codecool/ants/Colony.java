package com.codecool.ants;

import com.codecool.ants.ants.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Colony {

    private List<Ant> ants = new ArrayList<>();

    private int size;
    private Ant[][] colonyMap;
    private boolean isWaspPresent;
    private static final Random RND = new Random();
    public Colony(int size) {
        this.size = size;
        colonyMap = new Ant[size][size];
        colonyMap[size / 2][size / 2] = new Queen(new int[size / 2][size / 2]);
        setAnts();
    }

    private void setAnts() {
        int counter = 0;
        for (int i = 0; i < 30; i++) {
            int[] pos = getFreePosition();
            int posX = pos[0];
            int posY = pos[1];
            if (colonyMap[posX][posY] == null) {
                colonyMap[posX][posY] = new Drone(new int[posX][posY]);
                ants.add(colonyMap[posX][posY]);
            }
        }
        for (int i = 0; i < 30; i++) {
            int[] pos = getFreePosition();
            int posX = pos[0];
            int posY = pos[1];
            if (colonyMap[posX][posY] == null) {
                colonyMap[posX][posY] = new Soldier(new int[posX][posY]);
                ants.add(colonyMap[posX][posY]);
            }
        }
        for (int i = 0; i < 30; i++) {
            int[] pos = getFreePosition();
            int posX = pos[0];
            int posY = pos[1];
            if (colonyMap[posX][posY] == null) {
                colonyMap[posX][posY] = new Worker(new int[posX][posY]);
                ants.add(colonyMap[posX][posY]);
            }
        }
    }


    private int[] getFreePosition() {
        int[] pos = null;
        while (pos == null) {
            int posX = RND.nextInt(size);
            int posY = RND.nextInt(size);
            if (colonyMap[posX][posY] == null) {
                pos = new int[]{posX, posY};
            }
        }
        return pos;
    }

    public boolean getWasp() {
        return isWaspPresent;
    }

    public Ant[][] getColonyMap() {
        return colonyMap;
    }

    public void nextStep() {

    }

    public List<Ant> getAnts() {
        return ants;
    }

    @Override
    public String toString() {
        StringBuilder map = new StringBuilder();
        for (Ant[] level : getColonyMap()) {
            for (Ant ant : level) {
                if (ant != null) {
                    map.append(ant.getChar()).append(".");
                } else {
                    map.append(" ").append(".");
                }
            }
            map.append("\n");
        }
        return map.toString();
    }
}
