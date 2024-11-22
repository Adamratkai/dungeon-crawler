package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.items.Item;

public class Player extends Actor {

    private static int starterHealth = 10;
    private static int starterDefense = 0;
    private static int minDamage = 3;
    private static int maxDamage = 4;

    public Player(Cell cell) {
        super(cell, starterHealth, starterDefense, minDamage,maxDamage);
    }

    public String getTileName() {
        return "player";
    }

    public void pickUpInventory(Item item) {
        addInventory(item);
        getCell().setItem(null);
    }

}
