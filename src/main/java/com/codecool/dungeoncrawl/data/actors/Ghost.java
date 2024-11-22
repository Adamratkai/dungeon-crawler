package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Ghost extends GhostType{

    private static int starterHealth = 20;
    private static int starterDefense = 2;
    private static int minDamage = 1;
    private static int maxDamage = 3;
    private static int visionRange= 4;

    public Ghost(Cell cell) {
        super(cell,starterHealth,starterDefense,minDamage,maxDamage,visionRange);
    }

    @Override
    public String getTileName() {
        return "ghost";
    }
}
