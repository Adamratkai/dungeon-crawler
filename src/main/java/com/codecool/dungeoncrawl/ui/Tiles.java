package com.codecool.dungeoncrawl.ui;

import com.codecool.dungeoncrawl.data.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class Tiles {
    public static int TILE_WIDTH = 32;

    private static Image tileset = new Image("/tiles.png", 543 * 2, 543 * 2, true, false);
    private static Map<String, Tile> tileMap = new HashMap<>();
    public static class Tile {
        public final int x, y, w, h;
        Tile(int i, int j) {
            x = i * (TILE_WIDTH + 2);
            y = j * (TILE_WIDTH + 2);
            w = TILE_WIDTH;
            h = TILE_WIDTH;
        }
    }

    static {
        tileMap.put("empty", new Tile(0, 0));
        tileMap.put("wall", new Tile(0, 13));
        tileMap.put("floor", new Tile(2, 0));
        tileMap.put("player", new Tile(29, 6));
        tileMap.put("bat", new Tile(26, 8));
        tileMap.put("key", new Tile(16, 23));
        tileMap.put("apple", new Tile(15, 29));
        tileMap.put("potion", new Tile(16, 30));
        tileMap.put("mermaid", new Tile(31,9));
        tileMap.put("ghost", new Tile(26, 6));
        tileMap.put("closedDoor", new Tile(0, 9));
        tileMap.put("openDoor", new Tile(2, 9));
        tileMap.put("spear",new Tile(0, 25));
        tileMap.put("cellgrid", new Tile(5, 3));
        tileMap.put("jailMonster", new Tile(28, 6));
    }

    public static void drawTile(GraphicsContext context, Drawable d, int x, int y) {
        Tile tile = tileMap.get(d.getTileName());
        context.drawImage(tileset, tile.x, tile.y, tile.w, tile.h,
                x * TILE_WIDTH, y * TILE_WIDTH, TILE_WIDTH, TILE_WIDTH);
    }
}
