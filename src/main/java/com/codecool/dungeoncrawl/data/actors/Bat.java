package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Bat extends BeastType {

    private static int starterHealth = 10;
    private static int starterDefense = 0;
    private static int minDamage = 0;
    private static int maxDamage = 1;
    private static int visionRange = 2;


    public Bat(Cell cell) {
        super(cell,starterHealth,starterDefense,minDamage,maxDamage,visionRange);
    }

    @Override
    public String getTileName() {
        return "bat";
    }
}
