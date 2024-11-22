package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.Util.Util;
import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Drawable;
import com.codecool.dungeoncrawl.data.items.Armor;
import com.codecool.dungeoncrawl.data.items.Item;
import com.codecool.dungeoncrawl.data.items.Key;
import com.codecool.dungeoncrawl.data.items.Weapon;

import java.util.ArrayList;
import java.util.List;

public abstract class Actor implements Drawable {
    private List<Item> inventories;
    private Cell cell;
    protected int health;
    protected int damageMin;
    protected int damageMax;
    protected int defense;
    //TODO: probably add wearing items list to avoid multiple item usage (equip, unequipped button)
    //TODO: Move default health, attack, defense into the constructor

    public Actor(Cell cell, int health, int defense, int damageMin, int damageMax) {
        this.cell = cell;
        this.cell.setActor(this);
        this.inventories = new ArrayList<>();
        this.health = health;
        this.defense = defense;
        this.damageMin = damageMin;
        this.damageMax = damageMax;
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (nextCell == null) {
            return;
        }
        switch (nextCell.getType()) {
            case WALL:
                break;
            case FLOOR:
                if (nextCell.getActor() == null) {
                    cell.setActor(null);
                    nextCell.setActor(this);
                    cell = nextCell;
                    break;
                }
            case EMPTY:
                break;
            case CLOSEDDOOR:
                for (Item item : inventories) {
                    if (item instanceof Key) {
                        cell.setActor(null);
                        nextCell.setActor(this);
                        cell = nextCell;
                        cell.setType(CellType.OPENDOOR);
                        removeInventories(item);
                        break;
                    }
                }
                break;
            case OPENDOOR:
                    cell.setActor(null);
                    nextCell.setActor(this);
                    cell = nextCell;
                    break;
        }
    }

    public void attack(Actor actor) {
        int minDamage = damageMin;
        int maxDamage = damageMax;
        for (Item item : inventories) {
            if (item instanceof Weapon){
                int[] weaponDamage = ((Weapon) item).getDamage();
                minDamage+=weaponDamage[0];
                maxDamage+=weaponDamage[1];

            }
        }
        actor.receiveDamage(Util.getRandomInt(minDamage,maxDamage));
    }

    public void receiveDamage(int damage) {
        int totalDefense= defense;
        for (Item item : inventories) {
            if (item instanceof Armor){
                totalDefense +=((Armor) item).getDefense();
            }
        }
        int receivedDamage = damage - totalDefense;
        if (receivedDamage > 0) setHealth(health-receivedDamage);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
        if (this.health <= 0) {
            eliminate();
        }
    }

    private void eliminate() {
        dropItem();
        this.cell.setActor(null);
        this.cell = null;
    }

    public Cell getCell() {
        return cell;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }

    public void addInventory(Item item) {
        inventories.add(item);
    }

    public void dropItem() {
        if (!inventories.isEmpty()) {
            Item item = inventories.get(Util.getRandomInt(0, inventories.size()));
            cell.setItem(item);
        }
    }
    public void removeInventories(Item item) {
        inventories.remove(item);
    }

    public List<Item> getInventories() {
        return inventories;

    }

}
