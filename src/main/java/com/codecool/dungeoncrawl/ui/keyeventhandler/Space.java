package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Enemy;
import com.codecool.dungeoncrawl.data.actors.Player;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;

public class Space implements KeyHandler {
    public static final KeyCode code = KeyCode.SPACE;

    @Override
    public void perform(KeyEvent event, GameMap map) {
        if (code.equals(event.getCode())) {
            List<Cell> cellsAroundPlayer = new ArrayList<>();
            Player player = map.getPlayer();
            cellsAroundPlayer.add(player.getCell().getNeighbor(0,1));
            cellsAroundPlayer.add(player.getCell().getNeighbor(0,-1));
            cellsAroundPlayer.add(player.getCell().getNeighbor(1,0));
            cellsAroundPlayer.add(player.getCell().getNeighbor(-1,0));

            for (Cell cell : cellsAroundPlayer) {
                if (cell.getActor() instanceof Enemy) {
                    player.attack(cell.getActor());
                    break;
                }
            }


        }
    }
}
