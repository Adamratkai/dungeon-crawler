package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public abstract class Armor extends Item {
    private final int defense;

    public Armor(Cell cell, int defense) {
        super(cell);
        this.defense = defense;
    }
    public Armor(int defense){
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }
}
