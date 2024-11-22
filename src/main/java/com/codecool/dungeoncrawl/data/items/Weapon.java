package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public abstract class Weapon extends Item {
    private final int damageMin;
    private final int damageMax;

    public Weapon(Cell cell, int damageMin, int damageMax) {
        super(cell);
        this.damageMin=damageMin;
        this.damageMax=damageMax;
    }
    public Weapon (int damageMin, int damageMax) {
        this.damageMin=damageMin;
        this.damageMax=damageMax;
    }
    public int[] getDamage(){
        return new int[]{damageMin, damageMax};
    }



}
