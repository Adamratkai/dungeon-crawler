package com.codecool.dungeoncrawl.data.items.consumables;

import com.codecool.dungeoncrawl.Util.Util;
import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.items.Consumable;

public class Potion extends Consumable {

    public Potion(Cell cell) {
        super(cell);
        healthValue = Util.getRandomInt(2, 5);;
    }

    @Override
    public String getTileName() {
        return "potion";
    }
}
