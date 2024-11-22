package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public abstract class Consumable extends Item {

    protected int healthValue;

    public Consumable(Cell cell) {
        super(cell);
    }
    public Consumable() {}


    public int getHealthValue(){
        return healthValue;
    }

}
