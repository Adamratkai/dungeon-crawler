package com.codecool.dungeoncrawl.data.items.weapons;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.items.Weapon;

public class Spear extends Weapon {

    public Spear(Cell cell, int damageMin, int damageMax) {super(cell, damageMin, damageMax);}
    public Spear( int damageMin, int damageMax) {
        super(damageMin,damageMax);
    }

    @Override
    public String getTileName() {
        return "spear";
    }
}
