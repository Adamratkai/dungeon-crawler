package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public class Cellgrid extends Item{

    public Cellgrid(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "cellgrid";
    }
}
