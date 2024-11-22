package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public abstract class Npc extends Actor {

    protected final int starterCoordinateX;
    protected final int starterCoordinateY;

    public Npc(Cell cell, int health, int defense, int minDamage, int maxDamage) {
        super(cell, health, defense, minDamage, maxDamage);
        this.starterCoordinateX = cell.getX();
        this.starterCoordinateY = cell.getY();
    }


    //TODO: add automatization for moving and attacking
}
