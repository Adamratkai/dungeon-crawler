package com.codecool.dungeoncrawl.data.items.consumables;

import com.codecool.dungeoncrawl.Util.Util;
import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.items.Consumable;

public class Apple extends Consumable {

    public Apple(Cell cell) {
        super(cell);
        healthValue = Util.getRandomInt(1, 3);
    }

    @Override
    public String getTileName() {
        return "apple";
    }
}
