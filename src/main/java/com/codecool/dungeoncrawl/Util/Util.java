package com.codecool.dungeoncrawl.Util;

public class Util {
    public static int getRandomInt(int min, int max) {
        int range = max - min + 1;
        return (int)(Math.random() * range) + min;
    }
}
