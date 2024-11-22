package com.codecool.dungeoncrawl.data.items.consumables;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.items.Consumable;

public class Mermaid extends Consumable{

    public Mermaid(Cell cell) {
        super(cell);
        healthValue = 0;
    }

    @Override
    public String getTileName() {
        return "mermaid";
    }
}
