package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Ghost;
import com.codecool.dungeoncrawl.data.actors.JailMonster;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.actors.Bat;
import com.codecool.dungeoncrawl.data.items.consumables.Apple;
import com.codecool.dungeoncrawl.data.items.Key;
import com.codecool.dungeoncrawl.data.items.consumables.Mermaid;
import com.codecool.dungeoncrawl.data.items.consumables.Potion;
import com.codecool.dungeoncrawl.data.items.weapons.Spear;
import com.codecool.dungeoncrawl.data.items.*;

import java.io.InputStream;
import java.util.Scanner;

public class MapLoader {
    public static GameMap loadMap() {
        InputStream is = MapLoader.class.getResourceAsStream("/map.txt");
        Scanner scanner = new Scanner(is);
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        scanner.nextLine(); // empty line

        GameMap map = new GameMap(width, height, CellType.EMPTY);
        for (int y = 0; y < height; y++) {
            String line = scanner.nextLine();
            for (int x = 0; x < width; x++) {
                if (x < line.length()) {
                    Cell cell = map.getCell(x, y);
                    switch (line.charAt(x)) {
                        case ' ':
                            cell.setType(CellType.EMPTY);
                            break;
                        case '#':
                            cell.setType(CellType.WALL);
                            break;
                        case '+':
                            cell.setType(CellType.WALL);
                            new Cellgrid(cell);
                            break;
                        case '.':
                            cell.setType(CellType.FLOOR);
                            break;
                        case '@':
                            cell.setType(CellType.FLOOR);
                            map.setPlayer(new Player(cell));
                            break;
                        case 'a':
                            cell.setType(CellType.FLOOR);
                            new Apple(cell);
                            break;
                        case 'b':
                            cell.setType(CellType.FLOOR);
                            map.addEnemy(new Bat(cell));
                            break;
                        case 'd':
                            cell.setType(CellType.CLOSEDDOOR);
                            break;
                        case 'g':
                            cell.setType(CellType.FLOOR);
                            map.addEnemy(new Ghost(cell));
                            break;
                        case 'j':
                            cell.setType(CellType.FLOOR);
                            map.addEnemy(new JailMonster(cell));
                            break;
                        case 'k':
                            cell.setType(CellType.FLOOR);
                            new Key(cell);
                            break;
                        case 'm':
                            cell.setType(CellType.FLOOR);
                            new Mermaid(cell);
                            break;
                        case 'p':
                            cell.setType(CellType.FLOOR);
                            new Potion(cell);
                            break;
                        case 's':
                            cell.setType(CellType.FLOOR);
                            new Spear(cell,3,5);
                            break;
                        default:
                            throw new RuntimeException("Unrecognized character: '" + line.charAt(x) + "'");
                    }
                }
            }
        }
        return map;
    }

}
