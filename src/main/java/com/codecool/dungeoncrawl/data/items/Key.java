package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public class Key extends Item {

    public Key(Cell cell) {
        super(cell);
    }
    public Key() {super();}

    @Override
    public String getTileName() {
        return "key";
    }
}
