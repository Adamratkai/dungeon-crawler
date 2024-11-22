package com.codecool.dungeoncrawl.ui.keyeventhandler;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.items.Consumable;
import com.codecool.dungeoncrawl.data.items.Item;
import com.codecool.dungeoncrawl.data.items.consumables.Mermaid;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Pickup implements KeyHandler {
    public static final KeyCode code = KeyCode.E;

    @Override
    public void perform(KeyEvent event, GameMap map) {
        Item item = null;
        if (code.equals(event.getCode())) {
            item = map.getPlayer().getCell().getItem();
            if (item != null) {
                map.getPlayer().pickUpInventory(item);
            }
            if (item instanceof Consumable) {
                if (item instanceof Mermaid) {
                    map.getPlayer().setHealth(0);
                } else {
                    int health = ((Consumable) item).getHealthValue();
                    int playerHealth = map.getPlayer().getHealth();
                    map.getPlayer().setHealth(playerHealth + health);
                }
            }
        }
    }
}
