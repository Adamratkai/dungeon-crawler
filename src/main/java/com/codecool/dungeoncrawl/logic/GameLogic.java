package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.items.Item;

import java.util.stream.Collectors;

public class GameLogic {
    private GameMap map;

    public GameLogic() {
        this.map = MapLoader.loadMap();
    }

    public double getMapWidth() {
        return map.getWidth();
    }

    public double getMapHeight() {
        return map.getHeight();
    }

    public void setup() {
    }

    public Cell getCell(int x, int y) {
        return map.getCell(x, y);
    }

    public int[] getPlayerCoordinates() {
        return new int[]{map.getPlayer().getX(), map.getPlayer().getY()};
    }

    public String getPlayerHealth() {
        return Integer.toString(map.getPlayer().getHealth());
    }

    public String getPlayerInventory() {
        if (!map.getPlayer().getInventories().isEmpty()) {
            return map.getPlayer().getInventories()
                    .stream()
                    .map(Item::getTileName)
                    .collect(Collectors.joining("\n"));
        } else {
            return "";
        }
    }


    public GameMap getMap() {
        return map;
    }
}
