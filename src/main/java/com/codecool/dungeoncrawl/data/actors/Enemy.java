package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.Util.Direction;
import com.codecool.dungeoncrawl.Util.Util;
import com.codecool.dungeoncrawl.data.Cell;

import static java.lang.Math.abs;


public abstract class Enemy extends Npc {
    private int visionRange;

    public Enemy(Cell cell, int health, int defense, int minDamage, int maxDamage
    , int visionRange) {
        super(cell,health,defense,minDamage,maxDamage);
        this.visionRange = visionRange;
    }

    public void moveEnemy(Actor player){
        int playerX = player.getX();
        int playerY = player.getY();

        int enemyX = getX();
        int enemyY = getY();

        int distanceX = abs(playerX - enemyX);
        int distanceY = abs(playerY - enemyY);

        if (distanceX == 0 && distanceY == 1 || distanceX == 1 && distanceY == 0) {
            attack(player);
        } else if (distanceX <= visionRange && distanceY <= visionRange) {
            if (distanceX > distanceY) {
                if (playerX > enemyX) {
                    move(1, 0);
                } else {
                    move(-1, 0);
                }
            } else {
                if (playerY > enemyY) {
                    move(0, 1);
                } else {
                    move(0, -1);
                }
            }
        } else {
            Direction direction = generateDirection();
            move(direction.getX(), direction.getY());
        }

    }

    public Direction generateDirection() {
        switch (Util.getRandomInt(1, 4)) {
            case 1:
                return Direction.UP;
            case 2:
                return Direction.DOWN;
            case 3:
                return Direction.RIGHT;
            case 4:
                return Direction.LEFT;
            default:
                throw new RuntimeException("no direction found");
        }
    }

}
