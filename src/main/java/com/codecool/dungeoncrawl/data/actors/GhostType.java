package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public abstract class GhostType extends Enemy {
    public GhostType(Cell cell, int health, int defense, int minDamage, int maxDamage,int visionRange) {
        super(cell, health, defense, minDamage, maxDamage,visionRange);
    }


}
