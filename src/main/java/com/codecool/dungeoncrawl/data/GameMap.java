package com.codecool.dungeoncrawl.data;

import com.codecool.dungeoncrawl.data.actors.Enemy;
import com.codecool.dungeoncrawl.data.actors.Player;

import java.util.ArrayList;
import java.util.List;

public class GameMap {
    private int width;
    private int height;
    private Cell[][] cells;

    private Player player;
    private List<Enemy> enemies = new ArrayList<>();

    public GameMap(int width, int height, CellType defaultCellType) {
        this.width = width;
        this.height = height;
        cells = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell(this, x, y, defaultCellType);
            }
        }
    }

    public Cell getCell(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return null;
        } else {
            return cells[x][y];
        }
    }

    public void moveMonsters() {
        List<Enemy> deadEnemies = new ArrayList<>();

        for (Enemy enemy : enemies) {
            if (enemy.getCell() == null) {
                deadEnemies.add(enemy);
            } else {
                enemy.moveEnemy(player);
            }
        }
        enemies.removeAll(deadEnemies);
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }


    public void addEnemy(Enemy enemy){
        enemies.add(enemy);
    }


    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
